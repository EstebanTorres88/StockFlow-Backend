package com.stockflow.stockflow_backend.services.PurchaseService;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.stockflow.stockflow_backend.dtos.PurchaseDTOs.PurchaseRequestDTO;
import com.stockflow.stockflow_backend.dtos.PurchaseDetailDTOs.PurchaseDetailRequestDTO;
import com.stockflow.stockflow_backend.entities.History;
import com.stockflow.stockflow_backend.entities.Product;
import com.stockflow.stockflow_backend.entities.Purchase;
import com.stockflow.stockflow_backend.entities.PurchaseDetail;
import com.stockflow.stockflow_backend.entities.Stock;
import com.stockflow.stockflow_backend.enums.MovementType;
import com.stockflow.stockflow_backend.exceptions.PurchaseNotFoundException;
import com.stockflow.stockflow_backend.exceptions.StockNotFoundException;
import com.stockflow.stockflow_backend.repositories.HistoryRepository;
import com.stockflow.stockflow_backend.repositories.PurchaseRepository;
import com.stockflow.stockflow_backend.repositories.StockRepository;

@Service
public class PurchaseService implements IPurchaseService {

    @Autowired
    private PurchaseRepository purchaseRepository;

    @Autowired
    private StockRepository stockRepository;
    
    @Autowired
    private HistoryRepository historyRepository;

    private static final int PAGE_SIZE = 10;

    @Override
    public Page<Purchase> getAll(int page) {
        Pageable pageable = PageRequest.of(page, PAGE_SIZE, Sort.by("id").descending());
        
        Page<Purchase> purchases = purchaseRepository.findAll(pageable);
        purchases.forEach(purchase -> {
            calculatePurchaseProductsAmount(purchase);
            calculatePurchaseTotal(purchase);
        });

    

        return purchases;
    }

    @Override
    public Purchase addPurchase(PurchaseRequestDTO purchaseRequestDTO) {

        Purchase purchase = Purchase.builder()
        .date(purchaseRequestDTO.getDate())
        .reason(purchaseRequestDTO.getReason())
        .resourceId(UUID.randomUUID())
        .purchaseDetails(new ArrayList<>())
        .build();


        for (PurchaseDetailRequestDTO purchaseDetailDTO : purchaseRequestDTO.getPurchaseDetails()) {

            Stock stock = stockRepository.findByResourceId(purchaseDetailDTO.getStockResourceId()).orElseThrow(() -> new StockNotFoundException());
            Integer newQuantity = stock.getQuantity() + purchaseDetailDTO.getQuantity();
            stock.setQuantity(newQuantity); 


            PurchaseDetail purchaseDetail = PurchaseDetail.builder()
            .purchase(purchase)
            .stock(stock)
            .quantity(purchaseDetailDTO.getQuantity())
            .unitPrice(stock.getProduct().getPrice())
            .resourceId(UUID.randomUUID())
            .build();

            Product product = stock.getProduct();

            History record = History.builder()
            .movementType(MovementType.PURCHASE)
            .date(LocalDateTime.now())
            .product(product)
            .resourceId(UUID.randomUUID())
            .build();

            historyRepository.addRecord(record);

            purchase.getPurchaseDetails().add(purchaseDetail);
        }


        calculatePurchaseTotal(purchase);
        calculatePurchaseProductsAmount(purchase);

        return purchaseRepository.addPurchase(purchase);
        
    }

    @Override
    public Purchase getByResourceId(UUID resourceId) {
        Purchase purchase =  purchaseRepository.findByResourceId(resourceId)
            .orElseThrow(() -> new PurchaseNotFoundException(resourceId));


        calculatePurchaseProductsAmount(purchase);
        calculatePurchaseTotal(purchase);
        
        
        return purchase;
    }





    private void calculatePurchaseProductsAmount(Purchase purchase) {

        Integer productsAmount = purchase.getPurchaseDetails().stream()
                                .mapToInt(purchaseDetail -> purchaseDetail.getQuantity())
                                .sum();

        purchase.setTotalProductsAmount(productsAmount);                        
        
    }



    private void calculatePurchaseTotal(Purchase purchase) {
        BigDecimal purchaseTotal = purchase.getPurchaseDetails().stream()
                                    .map(purchaseDetail -> purchaseDetail.getUnitPrice().multiply(BigDecimal.valueOf(purchaseDetail.getQuantity())))
                                    .reduce(BigDecimal.ZERO, BigDecimal::add);
    


        purchase.setPurchaseTotal(purchaseTotal);
    }


  

 
}

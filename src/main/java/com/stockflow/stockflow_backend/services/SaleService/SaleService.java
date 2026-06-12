package com.stockflow.stockflow_backend.services.SaleService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.stockflow.stockflow_backend.dtos.SaleDTOs.SaleRequestDTO;
import com.stockflow.stockflow_backend.dtos.SaleDetailDTOs.SaleDetailRequestDTO;
import com.stockflow.stockflow_backend.entities.Sale;
import com.stockflow.stockflow_backend.entities.SaleDetail;
import com.stockflow.stockflow_backend.entities.Stock;
import com.stockflow.stockflow_backend.exceptions.SaleNotFoundException;
import com.stockflow.stockflow_backend.exceptions.StockNotFoundException;
import com.stockflow.stockflow_backend.repositories.SaleRepository;
import com.stockflow.stockflow_backend.repositories.StockRepository;

@Service
public class SaleService implements ISaleService {

    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private StockRepository stockRepository;


    private static final int PAGE_SIZE = 10;

    @Override
    public Page<Sale> getAll(int page) {
        Pageable pageable = PageRequest.of(page, PAGE_SIZE, Sort.by("id").descending());
        
        Page<Sale> sales = saleRepository.findAll(pageable);
        sales.forEach(sale -> {
            calculateSaleProductsAmount(sale);
            calculateSaleTotal(sale);
        });

    

        return sales;
    }

    @Override
    public Sale addSale(SaleRequestDTO saleRequestDTO) {

        Sale sale = Sale.builder()
        .date(saleRequestDTO.getDate())
        .resourceId(UUID.randomUUID())
        .saleDetails(new ArrayList<>())
        .build();


        for (SaleDetailRequestDTO saleDetailDTO : saleRequestDTO.getSaleDetails()) {

            Stock stock = stockRepository.findByResourceId(saleDetailDTO.getStockResourceId()).orElseThrow(() -> new StockNotFoundException());
            Integer newQuantity = stock.getQuantity() - saleDetailDTO.getQuantity();
            stock.setQuantity(newQuantity); 


            SaleDetail saleDetail = SaleDetail.builder()
            .sale(sale)
            .stock(stock)
            .quantity(saleDetailDTO.getQuantity())
            .unitPrice(stock.getProduct().getPrice())
            .resourceId(UUID.randomUUID())
            .build();

            sale.getSaleDetails().add(saleDetail);
        }


        calculateSaleTotal(sale);
        calculateSaleProductsAmount(sale);
        sale.getSaleDetails().forEach(saleDetail -> calculateDetailSubTotal(saleDetail));

        return saleRepository.addSale(sale);
        
    }

    @Override
    public Sale getByResourceId(UUID resourceId) {
        Sale sale =  saleRepository.findByResourceId(resourceId)
            .orElseThrow(() -> new SaleNotFoundException(resourceId));


        calculateSaleProductsAmount(sale);
        calculateSaleTotal(sale);
        sale.getSaleDetails().forEach(saleDetail -> calculateDetailSubTotal(saleDetail));
        
        
        return sale;
    }

    private void calculateSaleProductsAmount(Sale sale) {

        Integer productsAmount = sale.getSaleDetails().stream()
                                .mapToInt(saleDetail -> saleDetail.getQuantity())
                                .sum();

        sale.setTotalProductsAmount(productsAmount);                        
        
    }

    private void calculateSaleTotal(Sale sale) {
        BigDecimal saleTotal = sale.getSaleDetails().stream()
                                    .map(saleDetail -> saleDetail.getUnitPrice().multiply(BigDecimal.valueOf(saleDetail.getQuantity())))
                                    .reduce(BigDecimal.ZERO, BigDecimal::add);
    


        sale.setSaleTotal(saleTotal);
    }


    private void calculateDetailSubTotal(SaleDetail saleDetail){
        BigDecimal saleSubTotal = saleDetail.getUnitPrice().multiply(BigDecimal.valueOf(saleDetail.getQuantity()));
        saleDetail.setSubtotal(saleSubTotal);

    }
}

package com.stockflow.stockflow_backend.services.PurchaseDetailService;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stockflow.stockflow_backend.dtos.PurchaseDetailDTOs.PurchaseDetailRequestDTO;
import com.stockflow.stockflow_backend.entities.Purchase;
import com.stockflow.stockflow_backend.entities.PurchaseDetail;
import com.stockflow.stockflow_backend.entities.Stock;
import com.stockflow.stockflow_backend.exceptions.PurchaseDetailNotFoundException;
import com.stockflow.stockflow_backend.repositories.PurchaseDetailRepository;
import com.stockflow.stockflow_backend.services.PurchaseService.IPurchaseService;
import com.stockflow.stockflow_backend.services.StockService.IStockService;
@Service
public class PurchaseDetailService implements IPurchaseDetailService {

    @Autowired
    private PurchaseDetailRepository purchaseDetailRepository;

    @Autowired
    private IPurchaseService purchaseService;

    @Autowired
    private IStockService stockService;

    @Override
    public List<PurchaseDetail> getAll() {
       return purchaseDetailRepository.getAll();
    }

    @Override
    public PurchaseDetail addPurchaseDetail(PurchaseDetailRequestDTO dto) {
        
        Purchase purchase = purchaseService.getByResourceId(dto.getPurchaseResourceId());
        
        Stock stock = stockService.findByResourceId(dto.getStockResourceId());

        PurchaseDetail purchaseDetail = PurchaseDetail.builder()
            .purchase(purchase)  
            .stock(stock)       
            .quantity(dto.getQuantity())
            .unitPrice(dto.getUnitPrice())
            .resourceId(UUID.randomUUID()) 
            .build();

        return purchaseDetailRepository.addPurchaseDetail(purchaseDetail);
        
    }

    @Override
    public PurchaseDetail getByResourceId(UUID resourceId) {
    
        return purchaseDetailRepository.findByResourceId(resourceId)
        .orElseThrow(() -> new PurchaseDetailNotFoundException(resourceId));
   
    }

    @Override
    public PurchaseDetail updatePurchaseDetail(UUID resourceId, PurchaseDetailRequestDTO dto) {
         
        PurchaseDetail purchaseDetail = purchaseDetailRepository.findByResourceId(resourceId)
            .orElseThrow(() -> new PurchaseDetailNotFoundException(resourceId));

    
        Purchase purchase = purchaseService.getByResourceId(dto.getPurchaseResourceId());
        Stock stock = stockService.findByResourceId(dto.getStockResourceId());

        purchaseDetail.setPurchase(purchase);
        purchaseDetail.setStock(stock);
        purchaseDetail.setQuantity(dto.getQuantity());
        purchaseDetail.setUnitPrice(dto.getUnitPrice());

        return purchaseDetailRepository.updatePurchaseDetail(purchaseDetail);
    }

    @Override
    public void removePurchaseDetail(UUID resourceId) {
      PurchaseDetail purchaseDetail = purchaseDetailRepository.findByResourceId(resourceId)
            .orElseThrow(() -> new PurchaseDetailNotFoundException(resourceId));
            
        purchaseDetailRepository.removePurchaseDetail(purchaseDetail);
    }

   
    
}

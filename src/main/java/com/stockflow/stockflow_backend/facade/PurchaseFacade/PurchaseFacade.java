package com.stockflow.stockflow_backend.facade.PurchaseFacade;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.stockflow.stockflow_backend.dtos.PurchaseDTOs.PurchaseDTO;
import com.stockflow.stockflow_backend.dtos.PurchaseDTOs.PurchaseRequestDTO;
import com.stockflow.stockflow_backend.entities.Purchase;
import com.stockflow.stockflow_backend.mappers.PurchaseMapper;
import com.stockflow.stockflow_backend.services.PurchaseService.IPurchaseService;

import jakarta.transaction.Transactional;

@Component
public class PurchaseFacade implements IPurchaseFacade {
    @Autowired
    private IPurchaseService purchaseService;

    @Autowired
    private PurchaseMapper purchaseMapper;

    @Override
    public List<PurchaseDTO> getAll() {
        return purchaseMapper.toPurchaseDTOList(purchaseService.getAll());
    }

    @Override
    @Transactional
    public PurchaseDTO addPurchase(PurchaseRequestDTO dto) {
        Purchase purchase = purchaseService.addPurchase(dto);
        return purchaseMapper.toPurchaseDTO(purchase);
    }

    @Override
    public PurchaseDTO getByResourceId(UUID resourceId) {
        Purchase purchase = purchaseService.getByResourceId(resourceId);
        return purchaseMapper.toPurchaseDTO(purchase);
    }

    @Override
    @Transactional
    public PurchaseDTO updatePurchase(UUID resourceId, PurchaseRequestDTO dto) {
        Purchase purchase = purchaseService.updatePurchase(resourceId, dto);
        return purchaseMapper.toPurchaseDTO(purchase);
    }


    @Override
    @Transactional
    public void removePurchase(UUID resourceId) {
        purchaseService.removePurchase(resourceId);
    }
    
}

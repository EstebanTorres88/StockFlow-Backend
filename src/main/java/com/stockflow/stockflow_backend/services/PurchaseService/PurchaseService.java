package com.stockflow.stockflow_backend.services.PurchaseService;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stockflow.stockflow_backend.dtos.PurchaseDTOs.PurchaseRequestDTO;
import com.stockflow.stockflow_backend.entities.Purchase;
import com.stockflow.stockflow_backend.exceptions.PurchaseNotFoundException;
import com.stockflow.stockflow_backend.repositories.PurchaseRepository;

@Service
public class PurchaseService implements IPurchaseService {

    @Autowired
    private PurchaseRepository purchaseRepository;

    @Override
    public List<Purchase> getAll() {
        return purchaseRepository.findAll();
    }

    @Override
    public Purchase addPurchase(PurchaseRequestDTO dto) {
        Purchase purchase = Purchase.builder()
            .date(dto.getDate())
            .reason(dto.getReason())
            .resourceId(UUID.randomUUID())
            .build();
        return purchaseRepository.save(purchase);
    }

    @Override
    public Purchase getByResourceId(UUID resourceId) {
        return purchaseRepository.findByResourceId(resourceId)
            .orElseThrow(() -> new PurchaseNotFoundException(resourceId));
    }

    @Override
    public Purchase updatePurchase(UUID resourceId, PurchaseRequestDTO dto) {
        Purchase purchase = purchaseRepository.findByResourceId(resourceId)
            .orElseThrow(() -> new PurchaseNotFoundException(resourceId));
        purchase.setDate(dto.getDate());
        purchase.setReason(dto.getReason());
        return purchaseRepository.save(purchase);
    }

    @Override
    public void removePurchase(UUID resourceId) {
        Purchase purchase = purchaseRepository.findByResourceId(resourceId)
            .orElseThrow(() -> new PurchaseNotFoundException(resourceId));
        purchaseRepository.delete(purchase);
    }

}

package com.stockflow.stockflow_backend.services.PurchaseService;

import java.util.List;
import java.util.UUID;

import com.stockflow.stockflow_backend.dtos.PurchaseDTOs.PurchaseRequestDTO;
import com.stockflow.stockflow_backend.entities.Purchase;

public interface IPurchaseService {
    List<Purchase> getAll();
    Purchase addPurchase(PurchaseRequestDTO dto);
    Purchase getByResourceId(UUID resourceId);
    Purchase updatePurchase(UUID resourceId, PurchaseRequestDTO dto);
    void removePurchase(UUID resourceId);
}

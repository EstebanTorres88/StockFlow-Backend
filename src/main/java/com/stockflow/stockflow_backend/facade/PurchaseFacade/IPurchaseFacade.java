package com.stockflow.stockflow_backend.facade.PurchaseFacade;

import java.util.List;
import java.util.UUID;

import com.stockflow.stockflow_backend.dtos.PurchaseDTOs.PurchaseDTO;
import com.stockflow.stockflow_backend.dtos.PurchaseDTOs.PurchaseRequestDTO;

public interface IPurchaseFacade {
    List<PurchaseDTO> getAll();
    PurchaseDTO addPurchase(PurchaseRequestDTO dto);
    PurchaseDTO getByResourceId(UUID resourceId);
    PurchaseDTO updatePurchase(UUID resourceId, PurchaseRequestDTO dto);
    void removePurchase(UUID resourceId);
}

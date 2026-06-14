package com.stockflow.stockflow_backend.facade.PurchaseFacade;

import java.util.UUID;

import org.springframework.data.domain.Page;

import com.stockflow.stockflow_backend.dtos.PurchaseDTOs.PurchaseDTO;
import com.stockflow.stockflow_backend.dtos.PurchaseDTOs.PurchaseRequestDTO;

public interface IPurchaseFacade {
    Page<PurchaseDTO> getAll(int page);
    PurchaseDTO addPurchase(PurchaseRequestDTO dto);
    PurchaseDTO getByResourceId(UUID resourceId);
 
}

package com.stockflow.stockflow_backend.services.PurchaseDetailService;

import java.util.List;
import java.util.UUID;

import com.stockflow.stockflow_backend.dtos.PurchaseDetailDTOs.PurchaseDetailRequestDTO;
import com.stockflow.stockflow_backend.entities.PurchaseDetail;

public interface IPurchaseDetailService {
    List<PurchaseDetail> getAll();
    PurchaseDetail addPurchaseDetail(PurchaseDetailRequestDTO dto);
    PurchaseDetail getByResourceId(UUID resourceId);
    PurchaseDetail updatePurchaseDetail(UUID resourceId, PurchaseDetailRequestDTO dto);
    void removePurchaseDetail(UUID resourceId);
    
} 
package com.stockflow.stockflow_backend.facade.PurchaseDetailFacade;

import java.util.List;
import java.util.UUID;

import com.stockflow.stockflow_backend.dtos.PurchaseDetailDTOs.PurchaseDetailDTO;
import com.stockflow.stockflow_backend.dtos.PurchaseDetailDTOs.PurchaseDetailRequestDTO;

public interface IPurchaseDetailFacade {
    List<PurchaseDetailDTO> getAll();
    PurchaseDetailDTO addPurchaseDetail(PurchaseDetailRequestDTO dto);
    PurchaseDetailDTO getByResourceId(UUID resourceId);
    PurchaseDetailDTO updatePurchaseDetail(UUID resourceId, PurchaseDetailRequestDTO dto);
    void removePurchaseDetail(UUID resourceId);
}

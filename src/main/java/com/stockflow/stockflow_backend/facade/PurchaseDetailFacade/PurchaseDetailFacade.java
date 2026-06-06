package com.stockflow.stockflow_backend.facade.PurchaseDetailFacade;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import com.stockflow.stockflow_backend.dtos.PurchaseDetailDTOs.PurchaseDetailDTO;
import com.stockflow.stockflow_backend.dtos.PurchaseDetailDTOs.PurchaseDetailRequestDTO;
import com.stockflow.stockflow_backend.entities.PurchaseDetail;
import com.stockflow.stockflow_backend.mappers.PurchaseDetailMapper;
import com.stockflow.stockflow_backend.services.PurchaseDetailService.IPurchaseDetailService;

import jakarta.transaction.Transactional;

public class PurchaseDetailFacade implements IPurchaseDetailFacade {

    @Autowired
    private IPurchaseDetailService purchaseDetailService;

    @Autowired
    private PurchaseDetailMapper purchaseDetailMapper;

    @Override
    public List<PurchaseDetailDTO> getAll() {
        return purchaseDetailMapper.toPurchaseDetailDTOList(purchaseDetailService.getAll());
    }

    @Override
    @Transactional
    public PurchaseDetailDTO addPurchaseDetail(PurchaseDetailRequestDTO dto) {
        PurchaseDetail purchaseDetail = purchaseDetailService.addPurchaseDetail(dto);
        return purchaseDetailMapper.toPurchaseDetailDTO(purchaseDetail);
    }

    @Override
    public PurchaseDetailDTO getByResourceId(UUID resourceId) {
        PurchaseDetail purchaseDetail = purchaseDetailService.getByResourceId(resourceId);
        return purchaseDetailMapper.toPurchaseDetailDTO(purchaseDetail);
    }

    @Override
    @Transactional
    public PurchaseDetailDTO updatePurchaseDetail(UUID resourceId, PurchaseDetailRequestDTO dto) {
        PurchaseDetail purchaseDetail = purchaseDetailService.updatePurchaseDetail(resourceId, dto);
        return purchaseDetailMapper.toPurchaseDetailDTO(purchaseDetail);
    }

    @Override
    @Transactional
    public void removePurchaseDetail(UUID resourceId) {
        purchaseDetailService.removePurchaseDetail(resourceId);
    }

}

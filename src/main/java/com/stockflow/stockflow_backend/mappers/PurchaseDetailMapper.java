package com.stockflow.stockflow_backend.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.stockflow.stockflow_backend.dtos.PurchaseDetailDTOs.PurchaseDetailDTO;
import com.stockflow.stockflow_backend.dtos.PurchaseDetailDTOs.PurchaseDetailRequestDTO;
import com.stockflow.stockflow_backend.entities.PurchaseDetail;
import com.stockflow.stockflow_backend.models.PurchaiseDetailModels.PurchaseDetailRequestModel;
import com.stockflow.stockflow_backend.models.PurchaiseDetailModels.PurchaseDetailResponseModel;
import com.stockflow.stockflow_backend.models.PurchaseModels.PurchaseResponseModel;
import com.stockflow.stockflow_backend.models.StockModels.StockResponseModel;

@Component
public class PurchaseDetailMapper {

    @Autowired
    private PurchaseMapper purchaseMapper;

    @Autowired
    private StockMapper stockMapper;

    public PurchaseDetailDTO toPurchaseDetailDTO(PurchaseDetail purchaseDetail) {
        if (purchaseDetail == null){
             return null;
        }
        return new PurchaseDetailDTO( purchaseDetail.getResourceId(), purchaseMapper.toPurchaseDTO(purchaseDetail.getPurchase()),
        stockMapper.toStockDTO(purchaseDetail.getStock()), purchaseDetail.getQuantity(), purchaseDetail.getUnitPrice());
    }

    public List<PurchaseDetailDTO> toPurchaseDetailDTOList(List<PurchaseDetail> purchaseDetails) {
        if (purchaseDetails == null){
             return null;
        }
        return purchaseDetails.stream()
            .map(this::toPurchaseDetailDTO)
            .collect(Collectors.toList());
    }

    public PurchaseDetailResponseModel toPurchaseDetailResponseModel(PurchaseDetailDTO dto) {
        if (dto == null){
            return null;
        }

        PurchaseResponseModel purchaseResponseModel = purchaseMapper.toPurchaseResponseModel(dto.purchaseDTO());
        StockResponseModel stockResponseModel = stockMapper.toStockResponseModel(dto.stockDTO());

        return new PurchaseDetailResponseModel(dto.resourceId(), purchaseResponseModel, stockResponseModel, dto.quantity(), dto.unitPrice() );
    }

    public List<PurchaseDetailResponseModel> toPurchaseDetailResponseModelList(List<PurchaseDetailDTO> dtos) {
        if (dtos == null){
            return null;
        }
        return dtos.stream()
            .map(this::toPurchaseDetailResponseModel)
            .collect(Collectors.toList());
    }

    public PurchaseDetailRequestDTO toPurchaseDetailRequestDTO(PurchaseDetailRequestModel model) {
        if (model == null){
            return null;
        }

        PurchaseDetailRequestDTO dto = new PurchaseDetailRequestDTO();
        
        dto.setPurchaseResourceId(model.purchaseResourceId());
        dto.setStockResourceId(model.stockResourceId());
        dto.setQuantity(model.quantity());
        dto.setUnitPrice(model.unitPrice());
        return dto;
    }
}
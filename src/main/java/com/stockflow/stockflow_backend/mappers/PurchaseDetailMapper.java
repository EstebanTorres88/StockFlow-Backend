package com.stockflow.stockflow_backend.mappers;

import java.util.List;
import org.springframework.stereotype.Component;

import com.stockflow.stockflow_backend.dtos.PurchaseDetailDTOs.PurchaseDetailRequestDTO;
import com.stockflow.stockflow_backend.models.PurchaiseDetailModels.PurchaseDetailRequestModel;

@Component
public class PurchaseDetailMapper {

  

    public PurchaseDetailRequestDTO toPurchaseDetailRequestDTO(PurchaseDetailRequestModel purchaseDetailRequestModel) {
        if (purchaseDetailRequestModel == null){
            return null;
        }

        PurchaseDetailRequestDTO dto = new PurchaseDetailRequestDTO();
        dto.setStockResourceId(purchaseDetailRequestModel.stockResourceId());
        dto.setQuantity(purchaseDetailRequestModel.quantity());
        return dto;
    }


    public List<PurchaseDetailRequestDTO> toPurchaseDetailRequestDTOList(List<PurchaseDetailRequestModel> purchaseDetailRequestModelList) {
        if (purchaseDetailRequestModelList == null){
            return null;
        }
        return purchaseDetailRequestModelList.stream()
            .map(this::toPurchaseDetailRequestDTO)
            .toList();
    }
}
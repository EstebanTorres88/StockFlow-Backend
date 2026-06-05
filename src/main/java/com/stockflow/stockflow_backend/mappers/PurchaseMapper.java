package com.stockflow.stockflow_backend.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.stockflow.stockflow_backend.dtos.PurchaseDTOs.PurchaseDTO;
import com.stockflow.stockflow_backend.dtos.PurchaseDTOs.PurchaseRequestDTO;
import com.stockflow.stockflow_backend.entities.Purchase;
import com.stockflow.stockflow_backend.models.PurchaseModels.PurchaseRequestModel;
import com.stockflow.stockflow_backend.models.PurchaseModels.PurchaseResponseModel;

@Component
public class PurchaseMapper {

    public PurchaseDTO toPurchaseDTO(Purchase purchase) {
        if (purchase == null){
            return null;
        }
        return new PurchaseDTO(purchase.getDate(), purchase.getReason(), purchase.getResourceId());
    }

    public List<PurchaseDTO> toPurchaseDTOList(List<Purchase> purchases) {
        if (purchases == null){
            return null;
        }
        return purchases.stream()
        .map(this::toPurchaseDTO)
        .collect(Collectors.toList());
        
    }

    public PurchaseResponseModel toPurchaseResponseModel(PurchaseDTO dto) {
        if (dto == null){
            return null;
         }
        return new PurchaseResponseModel(dto.date(), dto.reason(), dto.resourceId());
    }

    public List<PurchaseResponseModel> toPurchaseResponseModelList(List<PurchaseDTO> dtos) {
        if (dtos == null){
            return null;
        } 
        return dtos.stream().map(this::toPurchaseResponseModel).toList();
    }

    public PurchaseRequestDTO toPurchaseRequestDTO(PurchaseRequestModel model) {
        if (model == null) return null;
        PurchaseRequestDTO dto = new PurchaseRequestDTO();
        dto.setDate(model.date());
        dto.setReason(model.reason());
        return dto;
    }
}

package com.stockflow.stockflow_backend.mappers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.stockflow.stockflow_backend.dtos.PurchaseDTOs.PurchaseDTO;
import com.stockflow.stockflow_backend.dtos.PurchaseDTOs.PurchaseRequestDTO;
import com.stockflow.stockflow_backend.dtos.PurchaseDetailDTOs.PurchaseDetailRequestDTO;
import com.stockflow.stockflow_backend.entities.Purchase;
import com.stockflow.stockflow_backend.models.PurchaseModels.PurchaseRequestModel;
import com.stockflow.stockflow_backend.models.PurchaseModels.PurchaseResponseModel;

@Component
public class PurchaseMapper {

    @Autowired
        private PurchaseDetailMapper purchaseDetailMapper;

    public PurchaseDTO toPurchaseDTO(Purchase purchase) {
        if (purchase == null){
            return null;
        }
        

        return new PurchaseDTO(purchase.getDate(), purchase.getReason(), purchase.getResourceId(), purchase.getPurchaseTotal(), purchase.getTotalProductsAmount());
    }


    public Page<PurchaseDTO> toPurchaseDTOPage(Page<Purchase> purchasePage) {
        if (purchasePage == null){
            return null;
        }
        return purchasePage.map(this::toPurchaseDTO);
        
        
    }

    public PurchaseResponseModel toPurchaseResponseModel(PurchaseDTO purchaseDTO) {
        if (purchaseDTO == null){
            return null;
         }

         return new PurchaseResponseModel(purchaseDTO.date(), purchaseDTO.reason(), purchaseDTO.resourceId(), purchaseDTO.purchaseTotal(), purchaseDTO.totalProductsAmount());
    }

    public Page<PurchaseResponseModel> toPurchaseResponseModelPage(Page<PurchaseDTO> purchaseDTOPage) {
        if (purchaseDTOPage == null){
            return null;
        }
        return purchaseDTOPage.map(this::toPurchaseResponseModel);
    }

    public PurchaseRequestDTO toPurchaseRequestDTO(PurchaseRequestModel purchaseRequestModel) {
        if (purchaseRequestModel == null){
            return null;
        }

        List<PurchaseDetailRequestDTO> purchaseDetailRequestDTOs = purchaseDetailMapper.toPurchaseDetailRequestDTOList(purchaseRequestModel.purchaseDetails());   
       
        PurchaseRequestDTO purchaseRequestDTO = new PurchaseRequestDTO();
        purchaseRequestDTO.setDate(purchaseRequestModel.date());
        purchaseRequestDTO.setReason(purchaseRequestModel.reason());
        purchaseRequestDTO.setPurchaseDetails(purchaseDetailRequestDTOs);
        
        return purchaseRequestDTO;
    }



}

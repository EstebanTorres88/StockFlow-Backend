package com.stockflow.stockflow_backend.mappers;

import java.util.List;

import org.springframework.stereotype.Component;

import com.stockflow.stockflow_backend.dtos.SaleDetailDTOs.SaleDetailDTO;
import com.stockflow.stockflow_backend.dtos.SaleDetailDTOs.SaleDetailRequestDTO;
import com.stockflow.stockflow_backend.entities.SaleDetail;
import com.stockflow.stockflow_backend.models.SaleDetailModels.SaleDetailsRequestModel;
import com.stockflow.stockflow_backend.models.SaleDetailModels.SaleDetailsResponseModel;

@Component
public class SaleDetailMapper {
    
    public SaleDetailDTO toSaleDetailDTO(SaleDetail saleDetail) {
        if (saleDetail == null){
             return null;
        }

        
        return new SaleDetailDTO(saleDetail.getResourceId(), saleDetail.getStock().getProduct().getName(), saleDetail.getStock().getProduct().getImageURL(),  saleDetail.getQuantity(), saleDetail.getUnitPrice(), saleDetail.getSubtotal());
    }

    public List<SaleDetailDTO> toSaleDetailDTOList(List<SaleDetail> saleDetails) {
        if (saleDetails == null){
             return null;
        }
        return saleDetails.stream()
            .map(this::toSaleDetailDTO)
            .toList();
    }

    public SaleDetailsResponseModel toSaleDetailResponseModel(SaleDetailDTO saleDetailDTO) {
        if (saleDetailDTO == null){
            return null;
        }


        return new SaleDetailsResponseModel(saleDetailDTO.resourceId(), saleDetailDTO.productName(), saleDetailDTO.imageURL(), saleDetailDTO.quantity(), saleDetailDTO.unitPrice(), saleDetailDTO.subtotal());
    }

    public List<SaleDetailsResponseModel> toSaleDetailResponseModelList(List<SaleDetailDTO> saleDetailDTOList) {
        if (saleDetailDTOList == null){
            return null;
        }
        return saleDetailDTOList.stream()
            .map(this::toSaleDetailResponseModel)
            .toList();
    }

    public SaleDetailRequestDTO toSaleDetailRequestDTO(SaleDetailsRequestModel saleDetailRequestModel) {
        if (saleDetailRequestModel == null){
            return null;
        }

        SaleDetailRequestDTO dto = new SaleDetailRequestDTO();
        dto.setStockResourceId(saleDetailRequestModel.stockResourceId());
        dto.setQuantity(saleDetailRequestModel.quantity());
        return dto;
    }


    public List<SaleDetailRequestDTO> toSaleDetailRequestDTOList(List<SaleDetailsRequestModel> saleDetailRequestModelList) {
        if (saleDetailRequestModelList == null){
            return null;
        }
        return saleDetailRequestModelList.stream()
            .map(this::toSaleDetailRequestDTO)
            .toList();
    }
}

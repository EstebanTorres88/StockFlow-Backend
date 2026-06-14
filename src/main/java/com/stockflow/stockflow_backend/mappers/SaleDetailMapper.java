package com.stockflow.stockflow_backend.mappers;

import java.util.List;

import org.springframework.stereotype.Component;

import com.stockflow.stockflow_backend.dtos.SaleDetailDTOs.SaleDetailRequestDTO;
import com.stockflow.stockflow_backend.models.SaleDetailModels.SaleDetailsRequestModel;

@Component
public class SaleDetailMapper {
   

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

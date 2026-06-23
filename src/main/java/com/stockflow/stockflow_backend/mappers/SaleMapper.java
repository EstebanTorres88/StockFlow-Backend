package com.stockflow.stockflow_backend.mappers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;


import com.stockflow.stockflow_backend.dtos.SaleDTOs.SaleDTO;
import com.stockflow.stockflow_backend.dtos.SaleDTOs.SaleRequestDTO;
import com.stockflow.stockflow_backend.dtos.SaleDetailDTOs.SaleDetailRequestDTO;
import com.stockflow.stockflow_backend.entities.Sale;
import com.stockflow.stockflow_backend.models.SaleModels.SaleRequestModel;
import com.stockflow.stockflow_backend.models.SaleModels.SaleResponseModel;



@Component
public class SaleMapper {

    @Autowired
    private SaleDetailMapper saleDetailMapper;

    public SaleDTO toSaleDto(Sale sale) {
        if (sale == null) {
            return null;
        }


        return new SaleDTO(sale.getDate(), sale.getResourceId(), sale.getSaleTotal(), sale.getTotalProductsAmount());
    } 

    public Page<SaleDTO> toSaleDTOPage(Page<Sale> salePage) {
        if (salePage == null){
            return null;
        }
        return salePage.map(this::toSaleDto);
        
        
    }

    public SaleResponseModel toSaleResponseModel(SaleDTO saleDTO) {
        if (saleDTO == null){
            return null;
         }

         return new SaleResponseModel(saleDTO.date(), saleDTO.resourceId(), saleDTO.saleTotal(), saleDTO.totalProductsAmount());
    }

    public Page<SaleResponseModel> toSaleResponseModelPage(Page<SaleDTO> saleDTOPage) {
        if (saleDTOPage == null){
            return null;
        }
        return saleDTOPage.map(this::toSaleResponseModel);
    }

    public SaleRequestDTO toSaleRequestDTO(SaleRequestModel saleRequestModel) {
        if (saleRequestModel == null){
            return null;
        }

        List<SaleDetailRequestDTO> saleDetailRequestDTOs = saleDetailMapper.toSaleDetailRequestDTOList(saleRequestModel.saleDetails());   
       
        SaleRequestDTO saleRequestDTO = new SaleRequestDTO();
        saleRequestDTO.setDate(saleRequestModel.date());
        saleRequestDTO.setSaleDetails(saleDetailRequestDTOs);
        
        return saleRequestDTO;
    }


}

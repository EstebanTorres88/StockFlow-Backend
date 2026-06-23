package com.stockflow.stockflow_backend.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.data.domain.Page;

import com.stockflow.stockflow_backend.dtos.HistoryDTOs.HistoryDTO;
import com.stockflow.stockflow_backend.dtos.ProductDTOs.ProductDTO;
import com.stockflow.stockflow_backend.entities.History;
import com.stockflow.stockflow_backend.models.HistoryModels.HistoryResponseModel;
import com.stockflow.stockflow_backend.models.ProductModels.ProductResponseModel;

@Component
public class HistoryMapper {
    @Autowired
    private ProductMapper productMapper;

    public HistoryDTO toRecordDTO(History record) {
        if (record == null) {
            return null;
        }

        ProductDTO productDTO = productMapper.toProductDto(record.getProduct());

        return new HistoryDTO(record.getMovementType(), record.getDate(), record.getResourceId(), productDTO);
    }

    public Page<HistoryDTO> toHistoryDTOPage(Page<History> historyPage) {
        if (historyPage == null) {
            return null;
        }

        return historyPage.map(this::toRecordDTO);
    }


    public HistoryResponseModel toHistoryResponseModel(HistoryDTO historyDTO){
        if (historyDTO == null) {
            return null;
        }

        ProductResponseModel productResponseModel = productMapper.toProductResponseModel(historyDTO.productDTO());

        return new HistoryResponseModel(historyDTO.movementType(), historyDTO.date(), historyDTO.resourceId(), productResponseModel);
    }


    public Page<HistoryResponseModel> toHistoryResponseModelPage(Page<HistoryDTO> historyDTOPage){
        if (historyDTOPage == null) {
            return null;
        }

        return historyDTOPage.map(this::toHistoryResponseModel);

    }
}

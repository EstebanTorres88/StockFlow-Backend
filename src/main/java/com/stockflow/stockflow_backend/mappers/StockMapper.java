package com.stockflow.stockflow_backend.mappers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.stockflow.stockflow_backend.dtos.ProductDTOs.ProductDTO;
import com.stockflow.stockflow_backend.dtos.StockDTOs.StockDTO;
import com.stockflow.stockflow_backend.entities.Stock;
import com.stockflow.stockflow_backend.models.ProductModels.ProductResponseModel;
import com.stockflow.stockflow_backend.models.StockModels.StockResponseModel;

@Component
public class StockMapper {

    @Autowired
    private ProductMapper productMapper;

    public StockDTO toStockDTO(Stock stock){
        if (stock == null) {
            return null;
        }

        ProductDTO productDTO = productMapper.toProductDto(stock.getProduct());

        return new StockDTO(stock.getQuantity(),stock.getMinimumQuantity(), stock.getResourceId(), productDTO);
        
    }


    public List<StockDTO> toStockDTOList(List<Stock> stockList){

        if (stockList == null) {
            return null;
        }

        return stockList.stream().map(this::toStockDTO).toList();
    }



    public StockResponseModel toStockResponseModel(StockDTO stockDTO){
        if (stockDTO == null) {
            return null;
        }

        ProductResponseModel productResponseModel = productMapper.toProductResponseModel(stockDTO.productDTO());

        return new StockResponseModel(stockDTO.quantity(),stockDTO.minimumQuantity(),stockDTO.resourceId(), productResponseModel);

    }




    public List<StockResponseModel> toStockResponseModelList(List<StockDTO> stockDTOList){
        if (stockDTOList == null) {
            return null;
        }

        return stockDTOList.stream().map(this::toStockResponseModel).toList();

    }
    
}

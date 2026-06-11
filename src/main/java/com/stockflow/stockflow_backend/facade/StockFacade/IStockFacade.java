package com.stockflow.stockflow_backend.facade.StockFacade;

import java.util.UUID;

import org.springframework.data.domain.Page;

import com.stockflow.stockflow_backend.dtos.StockDTOs.StockDTO;
import com.stockflow.stockflow_backend.dtos.StockDTOs.StockStatsDTO;

public interface IStockFacade {

    Page<StockDTO>getAll(int page);
    StockDTO findByResourceId(UUID resourceId);
    StockStatsDTO getStockStats();
    
}

package com.stockflow.stockflow_backend.facade.SaleFacade;

import java.util.UUID;

import org.springframework.data.domain.Page;

import com.stockflow.stockflow_backend.dtos.SaleDTOs.SaleDTO;
import com.stockflow.stockflow_backend.dtos.SaleDTOs.SaleRequestDTO;

public interface ISaleFacade {
    Page<SaleDTO> getAll(int page);
    SaleDTO addSale(SaleRequestDTO dto);
    SaleDTO getByResourceId(UUID resourceId);
}

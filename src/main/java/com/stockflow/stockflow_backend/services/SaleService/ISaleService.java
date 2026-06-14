package com.stockflow.stockflow_backend.services.SaleService;

import java.util.UUID;

import org.springframework.data.domain.Page;

import com.stockflow.stockflow_backend.dtos.SaleDTOs.SaleRequestDTO;
import com.stockflow.stockflow_backend.entities.Sale;

public interface ISaleService {
    Page<Sale> getAll(int page);
    Sale addSale(SaleRequestDTO dto);
    Sale getByResourceId(UUID resourceId);
}

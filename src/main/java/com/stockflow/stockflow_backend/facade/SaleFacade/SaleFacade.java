package com.stockflow.stockflow_backend.facade.SaleFacade;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.stockflow.stockflow_backend.dtos.SaleDTOs.SaleDTO;
import com.stockflow.stockflow_backend.dtos.SaleDTOs.SaleRequestDTO;
import com.stockflow.stockflow_backend.dtos.SaleDTOs.SaleSummaryDTO;
import com.stockflow.stockflow_backend.entities.Sale;
import com.stockflow.stockflow_backend.mappers.SaleMapper;
import com.stockflow.stockflow_backend.services.SaleService.ISaleService;

import jakarta.transaction.Transactional;

@Component
public class SaleFacade implements ISaleFacade {

    @Autowired
    private ISaleService saleService; 
  
    @Autowired
    private SaleMapper saleMapper;

    @Override
    public Page<SaleSummaryDTO> getAll(int page) {
        return saleMapper.toSaleSummaryDTOPage(saleService.getAll(page));
    }

    @Override
    @Transactional
    public SaleDTO addSale(SaleRequestDTO saleDto) {
        Sale entity = saleService.addSale(saleDto);
        return saleMapper.toSaleDto(entity);
    }

    @Override
    public SaleDTO getByResourceId(UUID resourceId) {
        Sale entity = saleService.getByResourceId(resourceId);
        return saleMapper.toSaleDto(entity);
    }
    
}

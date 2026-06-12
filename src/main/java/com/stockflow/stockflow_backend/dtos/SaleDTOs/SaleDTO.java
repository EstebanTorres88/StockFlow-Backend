package com.stockflow.stockflow_backend.dtos.SaleDTOs;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import com.stockflow.stockflow_backend.dtos.SaleDetailDTOs.SaleDetailDTO;



public record SaleDTO(  LocalDate date, 
    UUID resourceId,
    BigDecimal saleTotal,
    Integer totalProductsAmount,
    List<SaleDetailDTO> saleDetails) {}

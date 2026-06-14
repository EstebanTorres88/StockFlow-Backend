package com.stockflow.stockflow_backend.dtos.SaleDTOs;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public record SaleDTO(LocalDate date,
        UUID resourceId,
        BigDecimal saleTotal,
        Integer totalProductsAmount) {
}

package com.stockflow.stockflow_backend.dtos.StockDTOs;

import java.math.BigDecimal;

public record StockStatsDTO(
    Integer totalProducts,
    Integer lowStockProducts,
    BigDecimal inventoryValue

) {}

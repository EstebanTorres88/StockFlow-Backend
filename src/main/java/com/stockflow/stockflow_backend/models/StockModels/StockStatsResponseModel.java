package com.stockflow.stockflow_backend.models.StockModels;

import java.math.BigDecimal;

public record StockStatsResponseModel(
    Integer totalProducts,
    Integer lowStockProducts,
    BigDecimal inventoryValue
) {}
package com.stockflow.stockflow_backend.dtos.PurchaseDetailDTOs;

import java.math.BigDecimal;
import java.util.UUID;

import com.stockflow.stockflow_backend.dtos.PurchaseDTOs.PurchaseDTO;
import com.stockflow.stockflow_backend.dtos.StockDTOs.StockDTO;

public record PurchaseDetailDTO(
    UUID resourceId,
    PurchaseDTO purchaseDTO,
    StockDTO stockDTO,
    Integer quantity,
    BigDecimal unitPrice
) {}
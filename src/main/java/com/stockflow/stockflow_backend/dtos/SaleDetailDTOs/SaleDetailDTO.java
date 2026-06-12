package com.stockflow.stockflow_backend.dtos.SaleDetailDTOs;

import java.math.BigDecimal;
import java.util.UUID;

public record SaleDetailDTO (
    UUID resourceId,
    String productName,
    String imageURL,
    Integer quantity,
    BigDecimal unitPrice,
    BigDecimal subtotal
    )
{}

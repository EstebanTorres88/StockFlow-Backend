package com.stockflow.stockflow_backend.models.SaleDetailModels;

import java.math.BigDecimal;
import java.util.UUID;

public record SaleDetailsResponseModel (
    UUID resourceId,
    String productName,
    String imageURL,
    Integer quantity,
    BigDecimal unitPrice,
    BigDecimal subtotal
){}

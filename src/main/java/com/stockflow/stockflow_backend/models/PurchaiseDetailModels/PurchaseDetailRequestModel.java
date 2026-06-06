package com.stockflow.stockflow_backend.models.PurchaiseDetailModels;

import java.math.BigDecimal;
import java.util.UUID;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record PurchaseDetailRequestModel(
    @NotNull(message = "Purchase resource ID is required") UUID purchaseResourceId,
    @NotNull(message = "Stock resource ID is required") UUID stockResourceId,
    @NotNull(message = "Quantity is required") @Positive(message = "Quantity must be higher than 0") Integer quantity,
    @NotNull(message = "Unit price is required") @Positive(message = "Unit price must be higher than 0") BigDecimal unitPrice
) {}
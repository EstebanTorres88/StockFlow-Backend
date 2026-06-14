package com.stockflow.stockflow_backend.models.SaleDetailModels;

import java.util.UUID;

import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.NotNull;


public record SaleDetailsRequestModel (
    @NotNull(message = "Stock resource ID is required") UUID stockResourceId,
    @NotNull(message = "Quantity is required") @Positive(message = "Quantity must be higher than 0") Integer quantity
) {
    
}

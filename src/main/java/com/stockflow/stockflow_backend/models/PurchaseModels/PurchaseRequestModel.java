package com.stockflow.stockflow_backend.models.PurchaseModels;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PurchaseRequestModel(
    @NotNull(message = "Date field is required") LocalDate date,
    @NotBlank(message = "Reason field is required") String reason
) {
    
}
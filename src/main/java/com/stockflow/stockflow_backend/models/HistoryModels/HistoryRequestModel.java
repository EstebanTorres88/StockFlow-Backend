package com.stockflow.stockflow_backend.models.HistoryModels;

import java.time.LocalDateTime;
import java.util.UUID;

import com.stockflow.stockflow_backend.enums.MovementType;

import jakarta.validation.constraints.NotBlank;

public record HistoryRequestModel (
    @NotBlank(message = "Movement type is required") MovementType movementType,
    @NotBlank(message = "Date is required") LocalDateTime date,
    @NotBlank(message = "Product Id is required") UUID productResourceId
) {}

package com.stockflow.stockflow_backend.models.HistoryModels;

import java.time.LocalDateTime;
import java.util.UUID;

import com.stockflow.stockflow_backend.enums.MovementType;
import com.stockflow.stockflow_backend.models.ProductModels.ProductResponseModel;

public record HistoryResponseModel (
    MovementType movementType,
    LocalDateTime date,
    UUID resourceId,
    ProductResponseModel productResponseModel
) {}
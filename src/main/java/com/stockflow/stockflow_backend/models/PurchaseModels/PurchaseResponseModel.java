package com.stockflow.stockflow_backend.models.PurchaseModels;

import java.time.LocalDate;
import java.util.UUID;

public record PurchaseResponseModel(
    LocalDate date,
    String reason,
    UUID resourceId
) {}
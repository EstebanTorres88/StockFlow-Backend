package com.stockflow.stockflow_backend.dtos.PurchaseDTOs;
import java.time.LocalDate;
import java.util.UUID;

public record PurchaseDTO (
    LocalDate date, 
    String reason,
    UUID resourceId
) {
}



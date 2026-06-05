package com.stockflow.stockflow_backend.dtos.PurchaseDTOs;
import java.time.LocalDate;



public record PurchaseDTO (
    Long id, 
    LocalDate date, 
    String reason) {
}



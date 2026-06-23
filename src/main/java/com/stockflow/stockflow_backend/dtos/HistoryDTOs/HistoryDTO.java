package com.stockflow.stockflow_backend.dtos.HistoryDTOs;

import java.time.LocalDateTime;

import java.util.UUID;

import com.stockflow.stockflow_backend.dtos.ProductDTOs.ProductDTO;
import com.stockflow.stockflow_backend.enums.MovementType;

public record HistoryDTO(
    MovementType movementType,
    LocalDateTime date,
    UUID resourceId,
    ProductDTO productDTO
) {
}

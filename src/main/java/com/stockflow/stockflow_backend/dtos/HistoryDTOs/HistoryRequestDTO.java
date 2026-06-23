package com.stockflow.stockflow_backend.dtos.HistoryDTOs;

import java.time.LocalDateTime;
import java.util.UUID;

import com.stockflow.stockflow_backend.enums.MovementType;

public record HistoryRequestDTO (
    MovementType movementType,
    LocalDateTime date,
    UUID productResourceId
) { }
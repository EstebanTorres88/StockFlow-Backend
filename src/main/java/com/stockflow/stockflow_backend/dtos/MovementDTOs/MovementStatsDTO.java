package com.stockflow.stockflow_backend.dtos.MovementDTOs;

public record MovementStatsDTO(
    long totalMovements,
    int totalInflows,
    int totalOutflows
) {}

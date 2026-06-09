package com.stockflow.stockflow_backend.models.MovementModels;

public record MovementStatsResponseModel(
    long totalMovements,
    int totalInflows,
    int totalOutflows
) {}

package com.stockflow.stockflow_backend.models.SaleModels;

import java.time.LocalDate;
import java.util.List;

import com.stockflow.stockflow_backend.models.SaleDetailModels.SaleDetailsRequestModel;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record SaleRequestModel (
    @NotNull(message = "Date field is required")LocalDate date,
    @NotEmpty(message = "Sale details list cannot be empty") @Valid List<SaleDetailsRequestModel> saleDetails
    ) {
  
    
}

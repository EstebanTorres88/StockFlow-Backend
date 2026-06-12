package com.stockflow.stockflow_backend.models.SaleModels;

import java.time.LocalDate;
import java.util.List;

import com.stockflow.stockflow_backend.models.SaleDetailModels.SaleDetailsRequestModel;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

public record SaleRequestModel (
    @NotBlank(message = "Date field can't be null") LocalDate date,
    @NotEmpty(message = "Sale details list cannot be empty") @Valid List<SaleDetailsRequestModel> saleDetails
    ) {
  
    
}

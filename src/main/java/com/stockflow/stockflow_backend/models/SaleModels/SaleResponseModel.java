package com.stockflow.stockflow_backend.models.SaleModels;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;


public record SaleResponseModel (
  LocalDate date,
  UUID resourceId,
  BigDecimal saleTotal,
  Integer totalProductsAmount
){}

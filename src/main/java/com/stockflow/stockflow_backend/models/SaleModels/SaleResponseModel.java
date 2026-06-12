package com.stockflow.stockflow_backend.models.SaleModels;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import com.stockflow.stockflow_backend.models.SaleDetailModels.SaleDetailsResponseModel;

public record SaleResponseModel (
  LocalDate date,
  UUID resourceId,
  BigDecimal saleTotal,
  Integer totalProductsAmount,
  List<SaleDetailsResponseModel> saleDetails){
    
}

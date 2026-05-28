package com.stockflow.stockflow_backend.models;

import java.math.BigDecimal;
import java.util.UUID;

public record ProductResponseModel (
  String name,
  String description,
  BigDecimal price,
  UUID resourceId
) {}

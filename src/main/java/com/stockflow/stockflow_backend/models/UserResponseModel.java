package com.stockflow.stockflow_backend.models;

import java.util.UUID;

public record UserResponseModel (
  String name,
  String lastName,
  String email,
  UUID resourceId
) {}

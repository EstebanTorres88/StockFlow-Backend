package com.stockflow.stockflow_backend.exceptions;

import java.util.UUID;

public class MovementNotFoundException extends RuntimeException {

  public MovementNotFoundException() {
    super("Movement Not Found");
  }

  public MovementNotFoundException(UUID resourceId) {
    super("Movement Not Found with ID: " + resourceId);
  }

}

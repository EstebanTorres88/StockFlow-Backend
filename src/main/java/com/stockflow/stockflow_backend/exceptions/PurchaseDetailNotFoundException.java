package com.stockflow.stockflow_backend.exceptions;

import java.util.UUID;

public class PurchaseDetailNotFoundException extends RuntimeException {

   public PurchaseDetailNotFoundException() {
        super("Purchase detail not found");
    }

    public PurchaseDetailNotFoundException(UUID resourceId) {
        super("Purchase detail not found with id: " + resourceId);
    }
}

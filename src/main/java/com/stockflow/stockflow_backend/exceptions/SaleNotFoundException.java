package com.stockflow.stockflow_backend.exceptions;

import java.util.UUID;

public class SaleNotFoundException extends RuntimeException {
    
    public SaleNotFoundException() {
        super("Sale not found");
    }

    public SaleNotFoundException(UUID resourceId) {
        super("Sale not found with id: " + resourceId);
    }

}

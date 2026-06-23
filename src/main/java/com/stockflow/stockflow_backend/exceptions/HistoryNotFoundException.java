package com.stockflow.stockflow_backend.exceptions;

import java.util.UUID;

public class HistoryNotFoundException extends RuntimeException {


    public HistoryNotFoundException(){
        super("Record Not Found");
    }

    public HistoryNotFoundException(UUID resourceId){
        super("Record Not Found with ID: " + resourceId);
    }

   
    
}

package com.stockflow.stockflow_backend.models.PurchaiseDetailModels;


import java.math.BigDecimal;
import java.util.UUID;

import com.stockflow.stockflow_backend.models.PurchaseModels.PurchaseResponseModel;
import com.stockflow.stockflow_backend.models.StockModels.StockResponseModel;

public record PurchaseDetailResponseModel(
    UUID resourceId,
    PurchaseResponseModel purchaseResponseModel,
    StockResponseModel stockResponseModel,
    Integer quantity,
    BigDecimal unitPrice
) {}
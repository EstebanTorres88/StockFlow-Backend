package com.stockflow.stockflow_backend.dtos.PurchaseDetailDTOs;

import java.math.BigDecimal;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseDetailRequestDTO {
    private UUID purchaseResourceId;
    private UUID stockResourceId;
    private Integer quantity;
    private BigDecimal unitPrice;
}

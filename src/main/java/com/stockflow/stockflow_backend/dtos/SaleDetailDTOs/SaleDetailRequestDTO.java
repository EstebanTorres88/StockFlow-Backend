package com.stockflow.stockflow_backend.dtos.SaleDetailDTOs;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SaleDetailRequestDTO {
    private UUID stockResourceId;
    private Integer quantity;
}

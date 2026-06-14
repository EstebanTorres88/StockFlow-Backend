package com.stockflow.stockflow_backend.dtos.SaleDTOs;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import com.stockflow.stockflow_backend.dtos.SaleDetailDTOs.SaleDetailRequestDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SaleRequestDTO {

    private LocalDate date;
    private UUID resourceId;
    private List<SaleDetailRequestDTO> saleDetails;
}

package com.stockflow.stockflow_backend.facade.HistoryFacade;

import java.util.UUID;

import org.springframework.data.domain.Page;

import com.stockflow.stockflow_backend.dtos.HistoryDTOs.HistoryDTO;

public interface IHistoryFacade {
    Page<HistoryDTO> getAll(int page);
    HistoryDTO getByResourceId(UUID resourceId);
}

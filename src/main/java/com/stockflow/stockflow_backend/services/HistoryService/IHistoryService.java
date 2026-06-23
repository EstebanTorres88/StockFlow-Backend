package com.stockflow.stockflow_backend.services.HistoryService;

import java.util.UUID;
import org.springframework.data.domain.Page;

import com.stockflow.stockflow_backend.dtos.HistoryDTOs.HistoryRequestDTO;
import com.stockflow.stockflow_backend.entities.History;

public interface IHistoryService {
    Page<History> getAll(int page);
    History addRecord(HistoryRequestDTO dto);
    History getByResourceId(UUID resourceId);
}

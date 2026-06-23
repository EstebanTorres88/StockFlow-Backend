package com.stockflow.stockflow_backend.facade.HistoryFacade;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.stockflow.stockflow_backend.dtos.HistoryDTOs.HistoryDTO;
import com.stockflow.stockflow_backend.dtos.HistoryDTOs.HistoryRequestDTO;
import com.stockflow.stockflow_backend.entities.History;
import com.stockflow.stockflow_backend.mappers.HistoryMapper;
import com.stockflow.stockflow_backend.services.HistoryService.IHistoryService;

@Component
public class HistoryFacade implements IHistoryFacade {
    @Autowired
    private IHistoryService historyService;

    @Autowired
    private HistoryMapper historyMapper;
    
    @Override
    public Page<HistoryDTO> getAll(int page) {
        Page<History> historyPage = historyService.getAll(page);
        return historyMapper.toHistoryDTOPage(historyPage);
    }

    @Override
    public HistoryDTO getByResourceId(UUID resourceId) {
        History record = historyService.getByResourceId(resourceId);
        return historyMapper.toRecordDTO(record);
    }
}

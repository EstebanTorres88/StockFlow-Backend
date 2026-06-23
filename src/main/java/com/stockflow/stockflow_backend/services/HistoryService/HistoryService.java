package com.stockflow.stockflow_backend.services.HistoryService;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.stockflow.stockflow_backend.dtos.HistoryDTOs.HistoryRequestDTO;
import com.stockflow.stockflow_backend.entities.History;
import com.stockflow.stockflow_backend.exceptions.HistoryNotFoundException;
import com.stockflow.stockflow_backend.repositories.HistoryRepository;

import jakarta.transaction.Transactional;

@Service
public class HistoryService implements IHistoryService {

    @Autowired
    private HistoryRepository historyRepository;

    private static final int PAGE_SIZE = 5;

    @Override
    public Page<History> getAll(int page) {
        Pageable pageable = PageRequest.of(page, PAGE_SIZE, Sort.by("id").descending());

        return historyRepository.findAll(pageable);
    }

    @Override
    @Transactional
    public History addRecord(HistoryRequestDTO dto) {
        History record = History
            .builder()
            .movementType(dto.movementType())
            .date(dto.date())
            .resourceId(UUID.randomUUID())
            .build();

        return historyRepository.addRecord(record);
    }

    @Override
    public History getByResourceId(UUID resourceId) {
        return historyRepository.findByResourceId(resourceId)
        .orElseThrow(() -> new HistoryNotFoundException(resourceId));
    }
}
package com.stockflow.stockflow_backend.repositories;

import java.util.List;
import java.util.Optional;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

import com.stockflow.stockflow_backend.entities.History;

public interface HistoryRepository extends JpaRepository<History, Long> {
    default List<History> getAll() {
        return findAll();
    };

    default History addRecord(History record) {
        return save(record);
    }

    Optional<History> findByResourceId(UUID resourceId);
}

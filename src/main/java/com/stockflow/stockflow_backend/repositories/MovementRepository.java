package com.stockflow.stockflow_backend.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.stockflow.stockflow_backend.entities.Movement;

public interface MovementRepository extends JpaRepository<Movement, Long> {
    Optional<Movement> findByResourceId(UUID resourceId);

    @Query("SELECT COALESCE(SUM(m.quantity), 0) FROM Movement m WHERE m.quantity > 0")
    int sumInflows();

    @Query("SELECT COALESCE(SUM(m.quantity), 0) FROM Movement m WHERE m.quantity < 0")
    int sumOutflows();
}

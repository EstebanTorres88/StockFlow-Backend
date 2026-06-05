package com.stockflow.stockflow_backend.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.stockflow.stockflow_backend.entities.Purchase;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
    //los metodos los hereda de JpaRepository, no es necesario definirlos aqui
    Optional<Purchase> findByResourceId(UUID resourceId);
    
}
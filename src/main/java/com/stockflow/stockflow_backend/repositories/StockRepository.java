package com.stockflow.stockflow_backend.repositories;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.stockflow.stockflow_backend.entities.Stock;
import java.util.UUID;


public interface StockRepository extends JpaRepository<Stock, Long> {

   
    @Query("SELECT stock FROM Stock stock WHERE stock.product.active = true")
     Page<Stock> findAll(Pageable pageable);
    
    @Query("SELECT stock FROM Stock stock WHERE stock.resourceId = :resourceId AND stock.product.active = true")
    Optional<Stock> findByResourceId(UUID resourceId);

}

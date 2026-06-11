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

   
     Page<Stock> findAll(Pageable pageable);
    
    Optional<Stock> findByResourceId(UUID resourceId);

    @Query("SELECT COUNT(DISTINCT stock.product.id) FROM Stock stock")
    Integer countTotalProducts();


    @Query("SELECT COUNT(stock) FROM Stock stock WHERE stock.quantity < stock.minimumQuantity")
    Integer countLowStockProducts();


    @Query("SELECT SUM(stock.quantity * stock.product.price) FROM Stock stock")
    BigDecimal sumInventoryValue();

}

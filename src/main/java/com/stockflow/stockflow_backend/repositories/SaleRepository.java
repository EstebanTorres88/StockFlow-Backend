package com.stockflow.stockflow_backend.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stockflow.stockflow_backend.entities.Sale;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long>{

    Page<Sale> findAll(Pageable pageable);

    default Sale addSale(Sale sale) {
        return save(sale);
    }
  
    @EntityGraph(attributePaths = {
        "saleDetails",
        "saleDetails.stock",
        "saleDetails.stock.product",
    })

    Optional<Sale> findByResourceId(UUID resourceId);
}

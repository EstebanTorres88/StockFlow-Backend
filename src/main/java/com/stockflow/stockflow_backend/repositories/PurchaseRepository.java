package com.stockflow.stockflow_backend.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stockflow.stockflow_backend.entities.Purchase;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Long> {

    default List<Purchase> getAll() {
        return findAll();
    }

    default Purchase addPurchase(Purchase purchase) {
        return save(purchase);
    }

    default Purchase updatePurchase(Purchase purchase) {
        return save(purchase);
    }

    default void removePurchase(Purchase purchase) {
        delete(purchase);
    }

    Optional<Purchase> findByResourceId(UUID resourceId);
}
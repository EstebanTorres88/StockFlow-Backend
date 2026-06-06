package com.stockflow.stockflow_backend.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stockflow.stockflow_backend.entities.PurchaseDetail;

@Repository
public interface PurchaseDetailRepository extends JpaRepository<PurchaseDetail, Long> {

    default List<PurchaseDetail> getAll() {
        return findAll();
    }

    default PurchaseDetail addPurchaseDetail(PurchaseDetail purchaseDetail) {
        return save(purchaseDetail);
    }

    default PurchaseDetail updatePurchaseDetail(PurchaseDetail purchaseDetail) {
        return save(purchaseDetail);
    }

    default void removePurchaseDetail(PurchaseDetail purchaseDetail) {
        delete(purchaseDetail);
    }

    Optional<PurchaseDetail> findByResourceId(UUID resourceId);
}
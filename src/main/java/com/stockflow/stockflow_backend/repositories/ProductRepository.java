package com.stockflow.stockflow_backend.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.stockflow.stockflow_backend.entities.Product;
import java.util.UUID;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

  @Query("SELECT product FROM Product product WHERE product.active = true")
  List<Product> findAll();
  

  default Product addProduct(Product product) {
    return save(product);
  }

  default Product updateProduct(Product product) {
    return save(product);
  }

  default void removeProduct(Product product){
    save(product);
  }
  
  Optional<Product> findByResourceId(UUID resourceId);

}
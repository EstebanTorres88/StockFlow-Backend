package com.stockflow.stockflow_backend.services;

import java.util.List;
import java.util.UUID;

import com.stockflow.stockflow_backend.dtos.ProductRequestDto;
import com.stockflow.stockflow_backend.entities.Product;

public interface IProductService {
  List<Product> getAll();  
  Product addProduct(ProductRequestDto product);
  Product getByResourceId(UUID resourceId);
  Product updateProduct(UUID resourceId, ProductRequestDto productDto);
  void removeProduct(UUID resourceId);
}

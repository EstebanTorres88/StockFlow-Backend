package com.stockflow.stockflow_backend.facade;

import java.util.List;
import java.util.UUID;

import com.stockflow.stockflow_backend.dtos.ProductDto;
import com.stockflow.stockflow_backend.dtos.ProductRequestDto;

public interface IProductFacade {
  List<ProductDto> getAll();  
  ProductDto addProduct(ProductRequestDto productDto);
  ProductDto getByResourceId(UUID resourceId);
  ProductDto updateProduct(UUID resourceId, ProductRequestDto productDto);
  void removeProduct(UUID resourceId);
}

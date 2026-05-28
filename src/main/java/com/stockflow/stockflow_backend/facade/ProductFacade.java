package com.stockflow.stockflow_backend.facade;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.stockflow.stockflow_backend.dtos.ProductDto;
import com.stockflow.stockflow_backend.dtos.ProductRequestDto;
import com.stockflow.stockflow_backend.mappers.ProductMapper;
import com.stockflow.stockflow_backend.services.IProductService;

import jakarta.transaction.Transactional;

@Component
public class ProductFacade implements IProductFacade {
  @Autowired
  private IProductService productService;
  
  @Autowired
  private ProductMapper productMapper;

  @Override
  public List<ProductDto> getAll() {
    return productMapper.toProductDtoList(productService.getAll());
  }

  @Override
  @Transactional
  public ProductDto addProduct(ProductRequestDto productDto) {
    var entity = productService.addProduct(productDto);
    return productMapper.toProductDto(entity);
  }

  @Override
  public ProductDto getByResourceId(UUID resourceId) {
    var entity = productService.getByResourceId(resourceId);
    return productMapper.toProductDto(entity);
  }

  @Override
  @Transactional
  public ProductDto updateProduct(UUID resourceId, ProductRequestDto productDto) {
    var entity = productService.updateProduct(resourceId, productDto);
    return productMapper.toProductDto(entity);
  }

  @Override
  @Transactional
  public void removeProduct(UUID resourceId) {
    productService.removeProduct(resourceId);
  }
}

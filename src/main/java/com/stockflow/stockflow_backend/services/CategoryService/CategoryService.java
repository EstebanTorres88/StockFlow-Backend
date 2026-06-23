package com.stockflow.stockflow_backend.services.CategoryService;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stockflow.stockflow_backend.dtos.CategoryDTOs.CategoryRequestDTO;
import com.stockflow.stockflow_backend.entities.Category;
import com.stockflow.stockflow_backend.exceptions.CategoryNotFoundException;
import com.stockflow.stockflow_backend.repositories.CategoryRepository;

@Service
public class CategoryService implements ICategoryService {

     @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAll() {
        List<Category> categories = categoryRepository.findAll();
        categories.forEach(category -> calculateProductCount(category));
        return categories;
    }


    @Override
    public Category addCategory(CategoryRequestDTO categoryRequestDTO) {
        Category category = Category.builder()
        .name(categoryRequestDTO.getName())
        .resourceId(UUID.randomUUID())
        .imageURL(categoryRequestDTO.getImageUrl())
        .build();

        return categoryRepository.addCategory(category);
    }


    @Override
    public Category updateCategory(UUID resourceId, CategoryRequestDTO categoryRequestDTO) {
        Category category = categoryRepository.findByResourceId(resourceId).orElseThrow(()-> new CategoryNotFoundException());
        category.setName(categoryRequestDTO.getName());
        category.setImageURL(categoryRequestDTO.getImageUrl());

        calculateProductCount(category);

        return categoryRepository.updateCategory(category);
    }



    @Override
    public void removeCategory(Category category) {

        category.getProducts().forEach(product -> product.setActive(false));
        category.setActive(false);
        categoryRepository.removeCategory(category);
    }

    @Override
    public Category getByResourceId(UUID resourceId) {
        Category category = categoryRepository.findByResourceId(resourceId).orElseThrow(()-> new CategoryNotFoundException(resourceId));
        calculateProductCount(category);
        return category;
    }


    private void calculateProductCount(Category category){
        Long productCount = category.getProducts().stream().filter(product -> product.isActive()).count();
        category.setProductCount(productCount);
    }
}

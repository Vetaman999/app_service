package com.example.app_service.domain.service;

import com.example.app_service.domain.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface ProductService{
    Page<Product> getAllProducts(Pageable pageable);
    Product getProductById(Long productId);
    Product createProduct(Product product);
    Product updateProduct(Long productId, Product productRequest);
    ResponseEntity<?> deleteProduct(Long productId);
}

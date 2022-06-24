package com.example.app_service.service;

import com.example.app_service.domain.model.Product;
import com.example.app_service.domain.repository.ProductRepository;
import com.example.app_service.domain.service.ProductService;
import com.example.app_service.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Page<Product> getAllProducts(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public Product getProductById(Long productId) {
        return productRepository.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Bill not found with Id " + productId));
    }

    @Override
    public Product createProduct(Product productId) {
        return productRepository.save(productId);
    }

    @Override
    public Product updateProduct(Long productId, Product productRequest) {
        return null;
    }

    @Override
    public ResponseEntity<?> deleteProduct(Long productId) {
        if(!productRepository.existsById(productId))
            throw new ResourceNotFoundException("product", "Id", productId);
        return productRepository.findById(productId).map(bill -> {
            productRepository.delete(bill);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Product", "Id", productId));
    }
}

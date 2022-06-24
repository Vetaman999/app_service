package com.example.app_service.controller;

import com.example.app_service.domain.model.Product;
import com.example.app_service.domain.service.ProductService;
import com.example.app_service.resource.ProductResource;
import com.example.app_service.resource.SaveProductResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private ModelMapper mapper;

    @Operation(summary = "Get Product All", description = "Get Product All", tags = {"Product"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product returned", content = @Content(mediaType =
                    "application/json"))
    })
    @GetMapping("/products")
    public Page<ProductResource> getAllBills(Pageable pageable) {
        Page<Product> productPage = productService.getAllProducts(pageable);
        List<ProductResource> resources = productPage.getContent().
                stream().map(this::convertToResource).
                collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }

    @Operation(summary = "Get Product By Id", description = "Get Product by Id", tags = {"Product"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product returned", content = @Content(mediaType =
                    "application/json"))
    })
    @GetMapping("/products/{productId}")
    public ProductResource getProductById(@PathVariable(name = "productId") Long productId) {
        return convertToResource(productService.getProductById(productId));
    }

    @Operation(summary = "Post Product ", description = "Post Product", tags = {"Product"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product returned", content = @Content(mediaType =
                    "application/json"))
    })
    @PostMapping("/products")
    public ProductResource createProduct(@Valid @RequestBody SaveProductResource resource){
        return convertToResource(productService.createProduct(convertToEntity(resource)));
    }

    @Operation(summary = "Delete By Id", description = "Delete Product", tags = {"Product"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product returned", content = @Content(mediaType =
                    "application/json"))
    })
    @DeleteMapping("/product/{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable(name = "productId") Long productId){
        return productService.deleteProduct(productId);
    }

    private Product convertToEntity(SaveProductResource resource) {
        return mapper.map(resource, Product.class);
    }

    private ProductResource convertToResource(Product entity) {
        return mapper.map(entity, ProductResource.class);
    }


}

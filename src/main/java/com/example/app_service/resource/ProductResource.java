package com.example.app_service.resource;

public class ProductResource {
    private Long id;
    private String name;
    private Long price;

    public Long getId() {
        return id;
    }

    public ProductResource setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ProductResource setName(String name) {
        this.name = name;
        return this;
    }

    public Long getPrice() {
        return price;
    }

    public ProductResource setPrice(Long price) {
        this.price = price;
        return this;
    }
}

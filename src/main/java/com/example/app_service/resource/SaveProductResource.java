package com.example.app_service.resource;

import javax.persistence.Column;

public class SaveProductResource {

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = true)
    private Long price;

    public String getName() {
        return name;
    }

    public SaveProductResource setName(String name) {
        this.name = name;
        return this;
    }

    public Long getPrice() {
        return price;
    }

    public SaveProductResource setPrice(Long price) {
        this.price = price;
        return this;
    }
}

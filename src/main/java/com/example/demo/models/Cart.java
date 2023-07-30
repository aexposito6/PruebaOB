package com.example.demo.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Product> products = new ArrayList<>();

    private LocalDateTime lastActiveDateTime;

    public Cart(Long id, List<Product> products, LocalDateTime lastActiveDateTime) {
        this.id = id;
        this.products = products;
        this.lastActiveDateTime = lastActiveDateTime;
    }

    public Cart() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public LocalDateTime getLastActiveDateTime() {
        return lastActiveDateTime;
    }

    public void setLastActiveDateTime(LocalDateTime lastActiveDateTime) {
        this.lastActiveDateTime = lastActiveDateTime;
    }
}

package com.example.demo.services;

import com.example.demo.models.Product;
import com.example.demo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product createProduct(Product p) {
        return productRepository.save(p);
    }

    public Product findById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public void delete(Long id) {
        Product p = productRepository.findById(id).orElse(null);

        if (p != null) {
            productRepository.deleteById(id);
        }
    }
}

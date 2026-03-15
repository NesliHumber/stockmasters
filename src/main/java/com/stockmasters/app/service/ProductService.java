package com.stockmasters.app.service;

import com.stockmasters.app.model.Product;
import com.stockmasters.app.repository.ProductRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repo;

    public ProductService(ProductRepository repo) {
        this.repo = repo;
    }

    public List<Product> search(String keyword) {

        if (keyword == null || keyword.isEmpty()) {
            return repo.findAll();
        }

        return repo.findByNameContainingIgnoreCase(keyword);
    }
}
package com.stockmasters.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.stockmasters.app.model.Product;
import com.stockmasters.app.repository.ProductRepository;

@Service
public class ProductService {

    private final ProductRepository repo;

    public ProductService(ProductRepository repo){
        this.repo = repo;
    }

    // ===============================
    // SEARCH PRODUCTS
    // ===============================

    public List<Product> search(String search){

        if(search == null || search.isEmpty()){
            return repo.findAll();
        }

        return repo.findByNameContainingIgnoreCase(search);
    }

    // ===============================
    // SAVE PRODUCT
    // ===============================

    public void save(Product product){
        repo.save(product);
    }

    // ===============================
    // FIND PRODUCT BY ID
    // ===============================

    public Product findById(Long id){
        return repo.findById(id).orElse(null);
    }

    // ===============================
    // DELETE PRODUCT
    // ===============================

    public void delete(Long id){
        repo.deleteById(id);
    }

}
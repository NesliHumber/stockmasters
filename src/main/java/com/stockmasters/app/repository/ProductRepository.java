package com.stockmasters.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stockmasters.app.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByNameContainingIgnoreCase(String name);

}

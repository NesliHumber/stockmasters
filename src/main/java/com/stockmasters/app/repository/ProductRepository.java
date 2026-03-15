package com.stockmasters.app.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.stockmasters.app.model.Brand;
import com.stockmasters.app.model.Category;
import com.stockmasters.app.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Page<Product> findByBrandAndCategory(
            Brand brand,
            Category category,
            Pageable pageable
    );

    Page<Product> findByNameContainingIgnoreCase(
            String name,
            Pageable pageable
    );

    Page<Product> findByBrand(
            Brand brand,
            Pageable pageable
    );

    Page<Product> findByCategory(
            Category category,
            Pageable pageable
    );
}

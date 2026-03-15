package com.stockmasters.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stockmasters.app.model.Brand;

public interface BrandRepository extends JpaRepository<Brand, Long> {
}   
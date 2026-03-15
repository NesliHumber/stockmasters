package com.stockmasters.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stockmasters.app.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}   

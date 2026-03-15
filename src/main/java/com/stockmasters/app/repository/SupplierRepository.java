package com.stockmasters.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stockmasters.app.model.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {
}
package com.stockmasters.app.repository;

import com.stockmasters.app.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {

    @Query("SELECT COUNT(i) FROM Inventory i WHERE i.quantity < 10")
    Long countLowStock();

    @Query("SELECT SUM(i.quantity * i.product.price) FROM Inventory i")
    Double totalStockValue();
}

package com.stockmasters.app.controller;

import com.stockmasters.app.repository.ProductRepository;
import com.stockmasters.app.repository.InventoryRepository;
import com.stockmasters.app.repository.CenterRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    private final ProductRepository productRepo;
    private final InventoryRepository inventoryRepo;
    private final CenterRepository centerRepo;

    public DashboardController(ProductRepository productRepo,
                               InventoryRepository inventoryRepo,
                               CenterRepository centerRepo) {
        this.productRepo = productRepo;
        this.inventoryRepo = inventoryRepo;
        this.centerRepo = centerRepo;
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {

        model.addAttribute("totalProducts", productRepo.count());
        model.addAttribute("totalCenters", centerRepo.count());
        model.addAttribute("lowStock", inventoryRepo.countLowStock());
        model.addAttribute("stockValue", inventoryRepo.totalStockValue());

        return "dashboard";
    }
}
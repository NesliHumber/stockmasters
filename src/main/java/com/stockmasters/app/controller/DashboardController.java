package com.stockmasters.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.stockmasters.app.repository.CenterRepository;
import com.stockmasters.app.repository.InventoryRepository;
import com.stockmasters.app.repository.ProductRepository;

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
        model.addAttribute("totalInventory", inventoryRepo.count());
        model.addAttribute("totalCenters", centerRepo.count());

        return "dashboard";
    }

}
package com.stockmasters.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.stockmasters.app.repository.CenterRepository;
import com.stockmasters.app.repository.InventoryRepository;
import com.stockmasters.app.repository.ProductRepository;

@Controller
public class HomeController {

    private final ProductRepository productRepo;
    private final InventoryRepository inventoryRepo;
    private final CenterRepository centerRepo;

    public HomeController(ProductRepository productRepo,
                          InventoryRepository inventoryRepo,
                          CenterRepository centerRepo) {

        this.productRepo = productRepo;
        this.inventoryRepo = inventoryRepo;
        this.centerRepo = centerRepo;
    }

    @GetMapping("/")
    public String home(Model model) {

        model.addAttribute("totalProducts", productRepo.count());
        model.addAttribute("totalInventory", inventoryRepo.count());
        model.addAttribute("totalCenters", centerRepo.count());

        return "home";
    }
}

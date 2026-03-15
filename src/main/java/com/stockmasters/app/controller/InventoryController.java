package com.stockmasters.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.stockmasters.app.repository.InventoryRepository;

@Controller
public class InventoryController {

    private final InventoryRepository repo;

    public InventoryController(InventoryRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/inventory")
    public String inventory(Model model) {

        model.addAttribute("inventory", repo.findAll());

        Double total = repo.totalStockValue();

        if(total == null){
            total = 0.0;
        }

        model.addAttribute("totalValue", total);

        return "inventory";
    }
}

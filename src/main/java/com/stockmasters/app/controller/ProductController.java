package com.stockmasters.app.controller;

import com.stockmasters.app.model.Product;
import com.stockmasters.app.service.ProductService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping("/products")
    public String products(Model model,
                           @RequestParam(required = false) String search) {

        List<Product> products = service.search(search);

        model.addAttribute("products", products);

        return "products";
    }
}

package com.stockmasters.app.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.stockmasters.app.model.Product;
import com.stockmasters.app.service.ProductService;

@Controller
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    // ===============================
    // SHOW PRODUCT LIST
    // ===============================

    @GetMapping("/products")
    public String products(Model model,
                           @RequestParam(required = false) String search) {

        List<Product> products = service.search(search);

        model.addAttribute("products", products);

        return "products";
    }

    // ===============================
    // CREATE PRODUCT PAGE
    // ===============================

    @GetMapping("/products/new")
    public String newProduct(Model model){

        model.addAttribute("product", new Product());

        return "product-form";
    }

    // ===============================
    // SAVE NEW PRODUCT
    // ===============================

    @PostMapping("/products/save")
    public String saveProduct(@ModelAttribute Product product){

        service.save(product);

        return "redirect:/products";
    }

    // ===============================
    // EDIT PRODUCT PAGE
    // ===============================

    @GetMapping("/products/edit/{id}")
    public String editProduct(@PathVariable Long id, Model model){

        Product product = service.findById(id);

        model.addAttribute("product", product);

        return "product-edit";
    }

    // ===============================
    // UPDATE PRODUCT
    // ===============================

    @PostMapping("/products/update")
    public String updateProduct(@ModelAttribute Product product){

        service.save(product);

        return "redirect:/products";
    }

    // ===============================
    // DELETE PRODUCT
    // ===============================

    @GetMapping("/products/delete/{id}")
    public String deleteProduct(@PathVariable Long id){

        service.delete(id);

        return "redirect:/products";
    }

}
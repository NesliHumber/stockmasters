package com.stockmasters.app.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.stockmasters.app.model.Brand;
import com.stockmasters.app.model.Category;
import com.stockmasters.app.model.Product;
import com.stockmasters.app.repository.BrandRepository;
import com.stockmasters.app.repository.CategoryRepository;
import com.stockmasters.app.service.ProductService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;
    private final BrandRepository brandRepo;
    private final CategoryRepository categoryRepo;

    public ProductController(ProductService productService,
                             BrandRepository brandRepo,
                             CategoryRepository categoryRepo){
        this.productService = productService;
        this.brandRepo = brandRepo;
        this.categoryRepo = categoryRepo;
    }

    // ===============================
    // LIST PRODUCTS
    // ===============================

    @GetMapping
    public String listProducts(
            @RequestParam(required=false) String search,
            @RequestParam(required=false) Long brand,
            @RequestParam(required=false) Long category,
            @RequestParam(defaultValue="0") int page,
            @RequestParam(defaultValue="name") String sort,
            @RequestParam(defaultValue = "asc") String direction,
            Model model){


        Sort.Direction sortDirection = direction.equalsIgnoreCase("desc") ? Sort.Direction.DESC : Sort.Direction.ASC;        
        Pageable pageable = PageRequest.of(page, 10, Sort.by(Sort.Direction.fromString(direction), sort));

        Brand selectedBrand = null;
        Category selectedCategory = null;

        if(brand != null){
            selectedBrand = brandRepo.findById(brand).orElse(null);
        }

        if(category != null){
            selectedCategory = categoryRepo.findById(category).orElse(null);
        }

        Page<Product> products =
                productService.search(search, selectedBrand, selectedCategory, pageable);

        model.addAttribute("products", products);
        model.addAttribute("brands", brandRepo.findAll());
        model.addAttribute("categories", categoryRepo.findAll());
        model.addAttribute("search", search);
        model.addAttribute("selectedBrand", selectedBrand);
        model.addAttribute("selectedCategory", selectedCategory);
        model.addAttribute("sort", sort);
        model.addAttribute("direction", direction);

        return "products";
    }

    // ===============================
    // NEW PRODUCT FORM
    // ===============================

    @GetMapping("/new")
    public String newProduct(Model model){

        model.addAttribute("product", new Product());
        model.addAttribute("brands", brandRepo.findAll());
        model.addAttribute("categories", categoryRepo.findAll());

        return "product-form";
    }

    // ===============================
    // SAVE PRODUCT
    // ===============================

    @PostMapping("/save")
    public String saveProduct(
            @Valid @ModelAttribute Product product,
            BindingResult result,
            Model model){

        if(result.hasErrors()){

            model.addAttribute("brands", brandRepo.findAll());
            model.addAttribute("categories", categoryRepo.findAll());

            return "product-form";
        }

        productService.save(product);

        return "redirect:/products";
    }
}
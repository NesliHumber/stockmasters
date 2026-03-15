package com.stockmasters.app.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.stockmasters.app.model.Brand;
import com.stockmasters.app.model.Category;
import com.stockmasters.app.model.DistributionCenter;
import com.stockmasters.app.model.Inventory;
import com.stockmasters.app.model.Product;
import com.stockmasters.app.repository.CenterRepository;
import com.stockmasters.app.repository.InventoryRepository;
import com.stockmasters.app.repository.ProductRepository;

@Service
public class ProductService {

    private final ProductRepository repo;
    private final InventoryRepository inventoryRepo;
    private final CenterRepository centerRepo;

    public ProductService(ProductRepository repo,
                          InventoryRepository inventoryRepo,
                          CenterRepository centerRepo){
        this.repo = repo;
        this.inventoryRepo = inventoryRepo;
        this.centerRepo = centerRepo;
    }

    public Page<Product> search(String search, Brand brand, Category category, Pageable pageable){

        if(search != null && !search.isBlank()){
            return repo.findByNameContainingIgnoreCase(search, pageable);
        }

        if(brand != null && category != null){
            return repo.findByBrandAndCategory(brand, category, pageable);
        }

        if(brand != null){
            return repo.findByBrand(brand, pageable);
        }

        if(category != null){
            return repo.findByCategory(category, pageable);
        }

        return repo.findAll(pageable);
    }

    public void save(Product product){

        // save product first
        Product savedProduct = repo.save(product);

        // assign inventory to first distribution center
        DistributionCenter center = centerRepo.findAll().stream().findFirst().orElse(null);

        if(center != null){

            Inventory inventory = new Inventory();

            inventory.setProduct(savedProduct);
            inventory.setCenter(center);
            inventory.setQuantity(savedProduct.getQuantity());

            inventoryRepo.save(inventory);
        }
    }

    public Product findById(Long id){
        return repo.findById(id).orElse(null);
    }

    public void delete(Long id){
        repo.deleteById(id);
    }
}
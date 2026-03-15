package com.stockmasters.app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "center_id")
    private DistributionCenter center;

    private Integer quantity;

    public Inventory() {}

    public Inventory(Product product, DistributionCenter center, Integer quantity) {
        this.product = product;
        this.center = center;
        this.quantity = quantity;
    }

    public Long getId() { return id; }

    public Product getProduct() { return product; }

    public void setProduct(Product product) { this.product = product; }

    public DistributionCenter getCenter() { return center; }

    public void setCenter(DistributionCenter center) { this.center = center; }

    public Integer getQuantity() { return quantity; }

    public void setQuantity(Integer quantity) { this.quantity = quantity; }
}
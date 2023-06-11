package com.nbu.getyours.models;

import jakarta.persistence.*;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String productCode;
    private String name;
    private String brand;
    @ManyToOne
    private Category category;

    public Product() {
    }

    public Product(String productCode, String name, String brand, Category category) {
        this.productCode = productCode;
        this.name = name;
        this.brand = brand;
        this.category = category;
    }

    public String getProductCode() {
        return productCode;
    }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public Category getCategory() {
        return category;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}

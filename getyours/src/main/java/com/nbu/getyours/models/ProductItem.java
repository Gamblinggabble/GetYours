package com.nbu.getyours.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.math.BigDecimal;

@Entity
public class ProductItem {
    @Id
    private String item_url;
    @ManyToOne()
    private Product product;
    @ManyToOne
    private Website website;
    private BigDecimal initialPrice;
    private BigDecimal newPrice;
    private String picture_url;

    public ProductItem() {
    }

    public ProductItem(Product product, Website website, BigDecimal initialPrice, BigDecimal newPrice, String item_url, String picture_url) {
        this.product = product;
        this.website = website;
        this.initialPrice = initialPrice;
        this.newPrice = newPrice;
        this.item_url = item_url;
        this.picture_url = picture_url;
    }

    public Product getProduct() {
        return product;
    }

    public Website getWebsite() {
        return website;
    }

    public BigDecimal getInitialPrice() {
        return initialPrice;
    }

    public BigDecimal getNewPrice() {
        return newPrice;
    }

    public String getItem_url() {
        return item_url;
    }

    public String getPicture_url() {
        return picture_url;
    }

    public void setItem_url(String item_url) {
        this.item_url = item_url;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setWebsite(Website website) {
        this.website = website;
    }

    public void setInitialPrice(BigDecimal initialPrice) {
        this.initialPrice = initialPrice;
    }

    public void setNewPrice(BigDecimal newPrice) {
        this.newPrice = newPrice;
    }

    public void setPicture_url(String picture_url) {
        this.picture_url = picture_url;
    }
}

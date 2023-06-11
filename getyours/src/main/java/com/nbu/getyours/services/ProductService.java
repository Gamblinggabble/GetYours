package com.nbu.getyours.services;

import com.nbu.getyours.models.Category;
import com.nbu.getyours.models.MyUser;
import com.nbu.getyours.models.Product;
import com.nbu.getyours.repos.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepository;

    public List<Product> getALl() {
        return this.productRepository.findAll();
    }

    public Product getById(String id) {
        Optional<Product> product = this.productRepository.findById(id);
        if (product.isEmpty()) {
            System.out.println("Product with product code " + id + " does not exist");
            return null;
        }

        return product.get();
    }

    public Product add(Product product) {
        Product newProduct = null;
        if (this.productRepository.findById(product.getProductCode()).isPresent()) {
            System.out.println("Product with product code " + product.getProductCode() + " already exists");
        } else {
            newProduct = this.productRepository.save(product);
        }

        return newProduct;
    }

    public void delete(Product product) {
        this.productRepository.delete(product);
    }

    public List<Product> getAllByCategory(Category category) {
        return productRepository.getAllByCategory(category);
    }
}

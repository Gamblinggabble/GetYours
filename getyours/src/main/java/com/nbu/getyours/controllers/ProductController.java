package com.nbu.getyours.controllers;

import com.nbu.getyours.models.Category;
import com.nbu.getyours.models.Product;
import com.nbu.getyours.services.CategoryService;
import com.nbu.getyours.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/all")
    public List<Product> getAll(@RequestParam(required = false) Optional<String> categoryName) {
        if(categoryName.isPresent()) {
            Category category = categoryService.getByName(categoryName.get());
            return this.productService.getAllByCategory(category);
        }
        return this.productService.getALl();
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable String id) {
        return this.productService.getById(id);
    }

    @PostMapping("/add")
    public Product add(@RequestBody Product product) {
        return this.productService.add(product);
    }

    @PostMapping("delete")
    public void deleteUser(@RequestBody Product product) {
        this.productService.delete(product);
    }

}

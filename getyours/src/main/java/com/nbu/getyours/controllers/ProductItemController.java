package com.nbu.getyours.controllers;

import com.nbu.getyours.models.ProductItem;
import com.nbu.getyours.services.ProductItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("items")
public class ProductItemController {

    @Autowired
    private ProductItemService productItemService;

    @GetMapping("/all")
    public List<ProductItem> getAll() {
        return this.productItemService.getAll();
    }

    @GetMapping("/{item_url}")
    public ProductItem getById(@PathVariable String item_url) {
        return this.productItemService.getById(item_url);
    }

    @GetMapping("/all/brand")
    public List<ProductItem> getAllByBrand(@RequestParam String brand) {
        return this.productItemService.getByBrand(brand);
    }

    @GetMapping("/all/category")
    public List<ProductItem> getAll(@RequestParam String categoryName) {
        return this.productItemService.getByCategory(categoryName);
    }

    @PostMapping("/add")
    public ProductItem add(@RequestBody ProductItem item) {
        return this.productItemService.add(item);
    }

    @PostMapping("delete")
    public void deleteUser(@RequestBody ProductItem item) {
        this.productItemService.delete(item);
    }

}

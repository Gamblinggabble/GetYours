package com.nbu.getyours.controllers;

import com.nbu.getyours.models.ProductItem;
import com.nbu.getyours.services.ProductItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("items")
@CrossOrigin(origins = "http://localhost:4200")
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

    @GetMapping("/all/user")
    public List<ProductItem> getAllByUser(@RequestParam String email) {
        System.out.println(email);
        System.out.println(this.productItemService.getByUser(email).get(0).getWebsite().getName());
        return this.productItemService.getByUser(email);
    }

    @GetMapping("/all/category")
    public List<ProductItem> getAll(@RequestParam String categoryName) {
        return this.productItemService.getByCategory(categoryName);
    }

    @PostMapping("/add2")
    public ProductItem add(@RequestBody ProductItem item) {
        return this.productItemService.add(item);
    }

    @PostMapping("/add")
    public ProductItem add(@RequestParam String productUrl) {
        return this.productItemService.upload(productUrl);
    }

    @PostMapping("delete")
    public void delete(@RequestBody ProductItem item) {
        this.productItemService.delete(item);
    }

}

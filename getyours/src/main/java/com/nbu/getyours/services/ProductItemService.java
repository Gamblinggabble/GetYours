package com.nbu.getyours.services;

import com.nbu.getyours.models.Category;
import com.nbu.getyours.models.Product;
import com.nbu.getyours.models.ProductItem;
import com.nbu.getyours.repos.ProductItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductItemService {

    @Autowired
    private ProductItemRepo productItemRepository;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ProductService productService;

    public List<ProductItem> getAll() {
        return this.productItemRepository.findAll();
    }

    public ProductItem getById(String item_url) {
        Optional<ProductItem> productItem = this.productItemRepository.findById(item_url);
        if (productItem.isEmpty()) {
            System.out.println("Product item with url " + item_url + " does not exist");
            return null;
        }

        return productItem.get();
    }

    public List<ProductItem> getByCategory(String categoryName) {
        Category category = categoryService.getByName(categoryName);
        List<Product> products = this.productService.getAllByCategory(category);
        List<ProductItem> itemsOfCategory = this.getAll().stream().filter(i -> products.contains(i.getProduct())).collect(Collectors.toList());

        return itemsOfCategory;
    }

    public List<ProductItem> getByBrand(String brand) {
        List<Product> products = this.productService.getAllByBrand(brand);
        List<ProductItem> itemsOfBrand = this.getAll().stream().filter(i -> products.contains(i.getProduct())).collect(Collectors.toList());

        return itemsOfBrand;
    }

    public ProductItem add(ProductItem item) {
        ProductItem newItem = null;
        if (this.productItemRepository.findById(item.getItem_url()).isPresent()) {
            System.out.println("Product item with url " + item.getItem_url() + " already exists");
        } else {
            newItem = this.productItemRepository.save(item);
        }

        return newItem;
    }

    public void delete(ProductItem item) {
        this.productItemRepository.delete(item);
    }

}

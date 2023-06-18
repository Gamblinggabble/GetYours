package com.nbu.getyours.services;

import com.nbu.getyours.models.Category;
import com.nbu.getyours.models.Product;
import com.nbu.getyours.models.ProductItem;
import com.nbu.getyours.models.Website;
import com.nbu.getyours.repos.ProductItemRepo;
import com.nbu.getyours.scripts.PythonScriptRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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
    @Autowired
    private SubscriptionService subscriptionService;

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

    public ProductItem upload(String productUrl) {
        if (this.productItemRepository.findById(productUrl).isEmpty()) {
            ProductItem newProductItem = createNewItem(productUrl);
//            ProductItem newProduct = new ProductItem(productUrl, new Product(), new Website(), BigDecimal.valueOf(10.0), BigDecimal.valueOf(30.0), "https://");
            return newProductItem;
        } else {
            return this.productItemRepository.findById(productUrl).get();
        }
    }

    private ProductItem createNewItem(String productUrl) {
        PythonScriptRunner scriptRunner = new PythonScriptRunner();
        String divs = scriptRunner.executeScript();
        ProductItem newItem = new ProductItem(productUrl, new Product(), new Website(), BigDecimal.valueOf(10.0), BigDecimal.valueOf(30.0), "https://");
        return newItem;
    }

    public List<ProductItem> getByUser(String userEmail) {
        List<ProductItem> products = this.subscriptionService.getAllByUser(userEmail);
        System.out.println("in PIService, products: " + products.get(0).getWebsite().getName());
        List<ProductItem> itemsOfUser = this.getAll().stream().filter(i -> products.contains(i)).collect(Collectors.toList());
        System.out.println("in PIService, itemsOfUser: " + itemsOfUser.get(0).getWebsite().getName());

        return itemsOfUser;
    }
}

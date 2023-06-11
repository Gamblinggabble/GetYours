package com.nbu.getyours.repos;

import com.nbu.getyours.models.Category;
import com.nbu.getyours.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product, String> {
    List<Product> getAllByCategory(Category category);
    List<Product> getAllByBrand(String brand);
}

package com.nbu.getyours.repos;

import com.nbu.getyours.models.ProductItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductItemRepo extends JpaRepository<ProductItem, String> {
}

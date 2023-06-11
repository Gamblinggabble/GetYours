package com.nbu.getyours.services;

import com.nbu.getyours.models.Category;
import com.nbu.getyours.models.Product;
import com.nbu.getyours.repos.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepo categoryRepository;

    public List<Category> getALl() {
        return this.categoryRepository.findAll();
    }

    public Category getById(Long id) {
        Optional<Category> user = this.categoryRepository.findById(id);
        if (user.isEmpty()) {
            System.out.println("Category with id " + id + " does not exist");
            return null;
        }

        return user.get();
    }

    public Category getByName(String name) {
        Optional<Category> category = this.categoryRepository.findByName(name);
        if (category.isEmpty()) {
            System.out.println("User with email " + name + " does not exist");
            return null;
        }

        return category.get();
    }

}

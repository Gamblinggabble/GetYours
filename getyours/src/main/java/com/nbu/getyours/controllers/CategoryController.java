package com.nbu.getyours.controllers;

import com.nbu.getyours.models.Category;
import com.nbu.getyours.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/all")
    public List<Category> getAll() {
        return this.categoryService.getALl();
    }

    @GetMapping("/{id}")
    public Category getById(@PathVariable Long id) {
        return this.categoryService.getById(id);
    }

    @GetMapping()
    public Category getByName(@RequestParam String name) {
        return this.categoryService.getByName(name);
    }
}

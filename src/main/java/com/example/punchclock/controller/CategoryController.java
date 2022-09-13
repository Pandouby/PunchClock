package com.example.punchclock.controller;

import com.example.punchclock.model.Category;
import com.example.punchclock.service.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {

    CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/categories")
    public List<Category> getCategories() {
        return categoryService.getCategories();
    }

    @PostMapping("/category")
    public ResponseEntity postCategory(@RequestBody Category category) {
        categoryService.postCategory(category);
        return new ResponseEntity(category, HttpStatus.OK);
    }

    @PutMapping("/category/{id}")
    public ResponseEntity putCategory(@PathVariable Long id, @RequestBody Category category) {
        categoryService.updateCategory(id, category);
        return new ResponseEntity(category, HttpStatus.OK);
    }

    @DeleteMapping("/category/{id}")
    public ResponseEntity deleteTag(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}

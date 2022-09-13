package com.example.punchclock.service.category;

import com.example.punchclock.model.Category;
import com.example.punchclock.service.category.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getCategories() {
        return (List<Category>) categoryRepository.findAll();
    }

    public Category postCategory(Category category) {
        categoryRepository.save(category);
        return category;
    }

    public Category updateCategory(Long id, Category category) {
        Category categoryToUpdate = categoryRepository.findById(id).get();
        categoryToUpdate.setTitle(category.getTitle());
        categoryRepository.save(categoryToUpdate);
        return categoryToUpdate;
    }

    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}

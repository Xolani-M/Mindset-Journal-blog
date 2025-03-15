package com.mindsetjournal.services;

import com.mindsetjournal.domain.entities.Category;

import java.util.List;

public interface CategoryService {
    List<Category> listCategories();
    Category createCategory(Category category);
}

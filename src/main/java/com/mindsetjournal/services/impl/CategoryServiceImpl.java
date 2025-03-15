package com.mindsetjournal.services.impl;

import com.mindsetjournal.domain.entities.Category;
import com.mindsetjournal.repository.CategoryRepository;
import com.mindsetjournal.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public List<Category> listCategories() {
        return categoryRepository.findAllWithPostCount();
    }
}

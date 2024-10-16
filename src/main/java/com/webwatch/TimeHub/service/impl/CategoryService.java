package com.webwatch.TimeHub.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.webwatch.TimeHub.domain.Category;
import com.webwatch.TimeHub.repository.CategoryRepository;
import com.webwatch.TimeHub.service.ICategoryService;

@Service
public class CategoryService implements ICategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category save(Category category) {
        return this.categoryRepository.save(category);
    }

    @Override
    public List<Category> findAll() {
        return this.categoryRepository.findAll();
    }

}

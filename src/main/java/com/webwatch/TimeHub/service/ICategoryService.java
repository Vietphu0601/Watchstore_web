package com.webwatch.TimeHub.service;

import java.util.List;

import com.webwatch.TimeHub.domain.Category;

public interface ICategoryService {
    public Category save(Category category);

    public List<Category> findAll();
}

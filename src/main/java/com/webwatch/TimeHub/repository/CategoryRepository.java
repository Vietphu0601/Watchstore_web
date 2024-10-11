package com.webwatch.TimeHub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webwatch.TimeHub.domain.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    // public Category save(Category category);
}

package com.yegor.service;

import com.yegor.model.CategoryEntity;

import java.util.List;

/**
 * Created by YegorKost on 04.05.2017.
 */
public interface CategoryService {
    CategoryEntity addCategory(CategoryEntity category);
    CategoryEntity getCategory(int id);
    List<CategoryEntity> getAllCategories();
    CategoryEntity updateCategory(CategoryEntity category);
    void deleteCategory(CategoryEntity category);
}

package com.yegor.dal;

import com.yegor.model.CategoryEntity;

import java.util.List;

/**
 * Created by YegorKost on 26.04.2017.
 */
public interface CategoryDao {
    CategoryEntity addCategory(CategoryEntity category);
    CategoryEntity getCategory(int id);
    List<CategoryEntity> getAllCategories();
    CategoryEntity updateCategory(CategoryEntity category);
    void deleteCategory(CategoryEntity category);
}

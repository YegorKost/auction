package com.yegor.service.serviceImpl;

import com.yegor.dal.CategoryDao;
import com.yegor.dal.daoImpl.CategoryDaoImpl;
import com.yegor.model.CategoryEntity;
import com.yegor.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by YegorKost on 09.05.2017.
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryDao categoryDao;

    @Autowired
    public CategoryServiceImpl(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @Override
    public CategoryEntity addCategory(CategoryEntity category) {
        return categoryDao.addCategory(category);
    }

    @Override
    public CategoryEntity getCategory(int id) {
        return categoryDao.getCategory(id);
    }

    @Override
    public List<CategoryEntity> getAllCategories() {
        return categoryDao.getAllCategories();
    }

    @Override
    public CategoryEntity updateCategory(CategoryEntity category) {
        return categoryDao.updateCategory(category);
    }

    @Override
    public void deleteCategory(CategoryEntity category) {
        categoryDao.deleteCategory(category);
    }
}

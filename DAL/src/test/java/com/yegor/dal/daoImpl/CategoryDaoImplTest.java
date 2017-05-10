package com.yegor.dal.daoImpl;

import com.yegor.model.CategoryEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by YegorKost on 26.04.2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class CategoryDaoImplTest extends DalTest {

    @Test
    public void addCategoryTest() throws Exception {
        CategoryEntity category = new CategoryEntity();
        category.setCategory("Houses");
        categoryDao.addCategory(category);
        assertEquals(category, categoryDao.getCategory(category.getId()));
    }

    @Test
    public void getCategoryTest() throws Exception {
        assertEquals(category1, categoryDao.getCategory(category1.getId()));
        assertEquals(category2, categoryDao.getCategory(category2.getId()));
        assertEquals(category3, categoryDao.getCategory(category3.getId()));
    }

    @Test
    public void getAllCategoriesTest() throws Exception {
        List<CategoryEntity> categories = categoryDao.getAllCategories();
        assertEquals(3, categories.size());
        assertTrue(categories.contains(category1));
        assertTrue(categories.contains(category2));
        assertTrue(categories.contains(category3));
    }

    @Test
    public void updateCategoryTest() throws Exception {
        CategoryEntity category = categoryDao.getCategory(category1.getId());
        assertEquals("Cars", category.getCategory());
        category.setCategory("updated");
        categoryDao.updateCategory(category);
        assertEquals("updated", categoryDao.getCategory(category1.getId()).getCategory());
    }

    @Test
    public void deleteCategoryTest() throws Exception {
        List<CategoryEntity> categories = categoryDao.getAllCategories();
        assertEquals(3, categories.size());
        assertTrue(categories.contains(category3));
        categoryDao.deleteCategory(category3);
        categories = categoryDao.getAllCategories();
        assertEquals(2, categories.size());
        assertFalse(categories.contains(category3));
    }

    @Test(expected = Exception.class)
    public void deleteCategoryTest1() throws Exception {
        categoryDao.deleteCategory(category1);
    }

}
package com.yegor.dal.daoImpl;

import com.yegor.dal.CategoryDao;
import com.yegor.model.CategoryEntity;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * Created by YegorKost on 26.04.2017.
 */
@Transactional
@Repository
public class CategoryDaoImpl implements CategoryDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(CategoryDaoImpl.class);

    private SessionFactory sessionFactory;

    @Resource(name = "sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        LOGGER.info("------- Getting SessionFactory {} ", sessionFactory);
        this.sessionFactory = sessionFactory;
    }

    @Override
    public CategoryEntity addCategory(CategoryEntity categoryEntity) {
        Serializable id = sessionFactory
                .getCurrentSession()
                .save(categoryEntity);
        LOGGER.info("Adding the category with id - {}", id);
        return categoryEntity;
    }

    @Override
    public CategoryEntity getCategory(int id) {
        CategoryEntity categoryEntity = sessionFactory
                .getCurrentSession()
                .get(CategoryEntity.class, id);
        LOGGER.info("Getting the category with id - {} ", categoryEntity.getId());
        return categoryEntity;
    }

    @Override
    public List<CategoryEntity> getAllCategories() {
        List<CategoryEntity> allCategories = sessionFactory
                .getCurrentSession()
                .createNamedQuery("getAllCategories", CategoryEntity.class)
                .getResultList();
        LOGGER.info("Getting all categories");
        return allCategories;
    }

    @Override
    public CategoryEntity updateCategory(CategoryEntity categoryEntity) {
        sessionFactory
                .getCurrentSession()
                .update(categoryEntity);
        LOGGER.info("Updating the category with id - {}", categoryEntity.getId());
        return categoryEntity;
    }

    @Override
    public void deleteCategory(CategoryEntity categoryEntity) {
        sessionFactory
                .getCurrentSession()
                .delete(categoryEntity);
        LOGGER.info("Deleting the category with id - {} successful", categoryEntity.getId());
    }
}

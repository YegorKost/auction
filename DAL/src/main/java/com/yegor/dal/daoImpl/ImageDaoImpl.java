package com.yegor.dal.daoImpl;

import com.yegor.dal.ImageDao;
import com.yegor.model.ImageEntity;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * Created by YegorKost on 02.05.2017.
 */
@Transactional
@Repository
public class ImageDaoImpl implements ImageDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(ImageDaoImpl.class);

    private SessionFactory sessionFactory;

    @Resource(name = "sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public ImageEntity addImage(ImageEntity imageEntity) {
        Serializable id = sessionFactory
                .getCurrentSession()
                .save(imageEntity);
        LOGGER.info("Adding the image with id - {}", id);
        return imageEntity;
    }

    @Override
    public ImageEntity getImage(long id) {
        ImageEntity imageEntity = sessionFactory
                .getCurrentSession()
                .get(ImageEntity.class, id);
        LOGGER.info("Getting the image with id - {}", imageEntity.getId());
        return imageEntity;
    }

    @Override
    public List<ImageEntity> getAllImages() {
        List<ImageEntity> allImages = sessionFactory
                .getCurrentSession()
                .createNamedQuery("getAllImages", ImageEntity.class)
                .getResultList();
        LOGGER.info("Getting all images");
        return allImages;
    }

    @Override
    public ImageEntity updateImage(ImageEntity imageEntity) {
        sessionFactory
                .getCurrentSession()
                .update(imageEntity);
        LOGGER.info("Updating the image with id - {}", imageEntity.getId());
        return imageEntity;
    }

    @Override
    public void deleteImage(ImageEntity imageEntity) {
        sessionFactory
                .getCurrentSession()
                .delete(imageEntity);
        LOGGER.info("Deleting the image with id - {} successful", imageEntity.getId());
    }
}

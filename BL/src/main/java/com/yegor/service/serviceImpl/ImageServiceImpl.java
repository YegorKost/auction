package com.yegor.service.serviceImpl;

import com.yegor.dal.ImageDao;
import com.yegor.model.ImageEntity;
import com.yegor.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by YegorKost on 10.05.2017.
 */
@Service
public class ImageServiceImpl implements ImageService {

    private final ImageDao imageDao;

    @Autowired
    public ImageServiceImpl(ImageDao imageDao) {
        this.imageDao = imageDao;
    }

    @Override
    public ImageEntity addImage(ImageEntity image) {
        return imageDao.addImage(image);
    }

    @Override
    public ImageEntity getImage(long id) {
        return imageDao.getImage(id);
    }

    @Override
    public List<ImageEntity> getAllImages() {
        return imageDao.getAllImages();
    }

    @Override
    public ImageEntity updateImage(ImageEntity image) {
        return imageDao.updateImage(image);
    }

    @Override
    public void deleteImage(ImageEntity image) {
        imageDao.deleteImage(image);
    }
}

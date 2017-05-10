package com.yegor.service;

import com.yegor.model.ImageEntity;

import java.util.List;

/**
 * Created by YegorKost on 10.05.2017.
 */
public interface ImageService {
    ImageEntity addImage(ImageEntity image);
    ImageEntity getImage(long id);
    List<ImageEntity> getAllImages();
    ImageEntity updateImage(ImageEntity image);
    void deleteImage(ImageEntity image);
}

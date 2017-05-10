package com.yegor.dal;

import com.yegor.model.ImageEntity;

import java.util.List;

/**
 * Created by YegorKost on 26.04.2017.
 */
public interface ImageDao {
    ImageEntity addImage(ImageEntity image);
    ImageEntity getImage(long id);
    List<ImageEntity> getAllImages();
    ImageEntity updateImage(ImageEntity image);
    void deleteImage(ImageEntity image);
}

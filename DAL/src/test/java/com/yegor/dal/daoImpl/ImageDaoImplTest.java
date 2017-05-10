package com.yegor.dal.daoImpl;

import com.yegor.model.ImageEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by YegorKost on 02.05.2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class ImageDaoImplTest extends DalTest{
    @Test
    public void addImageTest() throws Exception {
        ImageEntity imageEntity = new ImageEntity();
        imageEntity.setLink("newLink");
        imageEntity.setLot(lot1);
        imageDao.addImage(imageEntity);
        assertEquals(imageEntity, imageDao.getImage(imageEntity.getId()));
    }

    @Test
    public void getImageTest() throws Exception {
        assertEquals(image1, imageDao.getImage(image1.getId()));
        assertEquals(image2, imageDao.getImage(image2.getId()));
        assertEquals(image3, imageDao.getImage(image3.getId()));
    }

    @Test
    public void getAllImagesTest() throws Exception {
        List<ImageEntity> allImages = imageDao.getAllImages();
        assertEquals(3, allImages.size());
        assertTrue(allImages.contains(image1));
        assertTrue(allImages.contains(image2));
        assertTrue(allImages.contains(image3));
    }

    @Test
    public void updateImageTest() throws Exception {
        ImageEntity image = imageDao.getImage(image1.getId());
        image.setLink("updated");
        imageDao.updateImage(image);
        assertEquals("updated", imageDao.getImage(image.getId()).getLink());
    }

    @Test
    public void deleteImageTest() throws Exception {
        List<ImageEntity> allImages = imageDao.getAllImages();
        assertEquals(3, allImages.size());
        assertTrue(allImages.contains(image1));
        imageDao.deleteImage(image1);
        allImages = imageDao.getAllImages();
        assertEquals(2, allImages.size());
        assertFalse(allImages.contains(image1));
    }

}
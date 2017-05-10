package com.yegor.dal.daoImpl;

import com.yegor.model.LotEntity;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by YegorKost on 02.05.2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class LotDaoImplTest extends DalTest{
    @Test
    public void addLotTest() throws Exception {
        LotEntity lotEntity = new LotEntity();
        lotEntity.setName("newName");
        lotEntity.setDescription("newDescription");
        lotEntity.setStartPrice(BigInteger.valueOf(100));
        lotEntity.setCategory(category1);
        lotEntity.setLotDate(Timestamp.valueOf("2017-07-22 04:05:06"));
        lotEntity.setStartDate(Timestamp.valueOf("2017-07-23 04:05:06"));
        lotEntity.setFinishDate(Timestamp.valueOf("2017-07-25 04:05:06"));
        lotEntity.setOwner(user2);
        lotEntity.setLotStatus(lotStatus2);
        lotDao.addLot(lotEntity);
        assertEquals(lotEntity, lotDao.getLot(lotEntity.getId()));
    }

    @Test
    public void getLotTest() throws Exception {
        assertEquals(lot1, lotDao.getLot(lot1.getId()));
        assertEquals(lot2, lotDao.getLot(lot2.getId()));
    }

    @Test
    public void getLotsByNameTest() throws Exception {
        assertTrue(lotDao.getLotsByName(lot1.getName()).contains(lot1));
        assertTrue(lotDao.getLotsByName(lot2.getName()).contains(lot2));
    }

    @Test
    public void getAllLotsTest() throws Exception {
        List<LotEntity> allLots = lotDao.getAllLots();
        assertEquals(2, allLots.size());
        assertTrue(allLots.contains(lot1));
        assertTrue(allLots.contains(lot2));
    }

    @Test
    public void updateLotTest() throws Exception {
        LotEntity lot = lotDao.getLot(lot1.getId());
        lot.setName("updated");
        lotDao.updateLot(lot);
        assertEquals("updated", lotDao.getLot(lot1.getId()).getName());
    }

    @Test
    public void deleteLotTest() throws Exception {
        List<LotEntity> allLots = lotDao.getAllLots();
        assertEquals(2, allLots.size());
        assertTrue(allLots.contains(lot2));
        lotDao.deleteLot(lot2);
        allLots = lotDao.getAllLots();
        assertEquals(1, allLots.size());
        assertFalse(allLots.contains(lot2));
    }

    @Test(expected = Exception.class)
    public void deleteLotTest1() throws Exception {
        lotDao.deleteLot(lot1);
    }

}
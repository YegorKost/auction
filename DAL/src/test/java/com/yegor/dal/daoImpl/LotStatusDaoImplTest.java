package com.yegor.dal.daoImpl;

import com.yegor.model.LotStatusEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by YegorKost on 02.05.2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class LotStatusDaoImplTest extends DalTest{
    @Test
    public void addLotStatusTest() throws Exception {
        LotStatusEntity lotStatusEntity = new LotStatusEntity();
        lotStatusEntity.setStatus("newStatus");
        lotStatusDao.addLotStatus(lotStatusEntity);
        assertEquals(lotStatusEntity, lotStatusDao.getLotStatus(lotStatusEntity.getId()));
    }

    @Test
    public void getLotStatusTest() throws Exception {
        assertEquals(lotStatus1, lotStatusDao.getLotStatus(lotStatus1.getId()));
        assertEquals(lotStatus2, lotStatusDao.getLotStatus(lotStatus2.getId()));
        assertEquals(lotStatus3, lotStatusDao.getLotStatus(lotStatus3.getId()));
    }

    @Test
    public void getAllLotsStatusesTest() throws Exception {
        List<LotStatusEntity> allLotsStatuses = lotStatusDao.getAllLotsStatuses();
        assertEquals(3, allLotsStatuses.size());
        assertTrue(allLotsStatuses.contains(lotStatus1));
        assertTrue(allLotsStatuses.contains(lotStatus2));
        assertTrue(allLotsStatuses.contains(lotStatus3));
    }

    @Test
    public void updateLotStatusTest() throws Exception {
        LotStatusEntity lotStatus = lotStatusDao.getLotStatus(lotStatus1.getId());
        lotStatus.setStatus("updated");
        lotStatusDao.updateLotStatus(lotStatus);
        assertEquals("updated", lotStatusDao.getLotStatus(lotStatus1.getId()).getStatus());
    }

    @Test
    public void deleteLotStatusTest() throws Exception {
        List<LotStatusEntity> allLotsStatuses = lotStatusDao.getAllLotsStatuses();
        assertEquals(3, allLotsStatuses.size());
        assertTrue(allLotsStatuses.contains(lotStatus3));
        lotStatusDao.deleteLotStatus(lotStatus3);
        allLotsStatuses = lotStatusDao.getAllLotsStatuses();
        assertEquals(2, allLotsStatuses.size());
        assertFalse(allLotsStatuses.contains(lotStatus3));
    }

    @Test(expected = Exception.class)
    public void deleteLotStatusTest1() throws Exception {
        lotStatusDao.deleteLotStatus(lotStatus1);
    }

}
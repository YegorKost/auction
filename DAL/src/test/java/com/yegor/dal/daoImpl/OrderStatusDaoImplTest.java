package com.yegor.dal.daoImpl;

import com.yegor.model.OrderStatusEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by YegorKost on 02.05.2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class OrderStatusDaoImplTest extends DalTest{
    @Test
    public void addOrderStatus() throws Exception {
        OrderStatusEntity orderStatusEntity = new OrderStatusEntity();
        orderStatusEntity.setStatus("newStatus");
        orderStatusDao.addOrderStatus(orderStatusEntity);
        assertEquals(orderStatusEntity, orderStatusDao.getOrderStatus(orderStatusEntity.getId()));
    }

    @Test
    public void getOrderStatus() throws Exception {
        assertEquals(orderStatus1, orderStatusDao.getOrderStatus(orderStatus1.getId()));
        assertEquals(orderStatus2, orderStatusDao.getOrderStatus(orderStatus2.getId()));
        assertEquals(orderStatus3, orderStatusDao.getOrderStatus(orderStatus3.getId()));
    }

    @Test
    public void getAllOrdersStatuses() throws Exception {
        List<OrderStatusEntity> allOrdersStatuses = orderStatusDao.getAllOrdersStatuses();
        assertEquals(3, allOrdersStatuses.size());
        assertTrue(allOrdersStatuses.contains(orderStatus1));
        assertTrue(allOrdersStatuses.contains(orderStatus2));
        assertTrue(allOrdersStatuses.contains(orderStatus3));
    }

    @Test
    public void updateOrderStatus() throws Exception {
        OrderStatusEntity orderStatus = orderStatusDao.getOrderStatus(orderStatus1.getId());
        orderStatus.setStatus("updated");
        orderStatusDao.updateOrderStatus(orderStatus);
        assertEquals("updated", orderStatusDao.getOrderStatus(orderStatus1.getId()).getStatus());
    }

    @Test
    public void deleteOrderStatus() throws Exception {
        List<OrderStatusEntity> allOrdersStatuses = orderStatusDao.getAllOrdersStatuses();
        assertEquals(3, allOrdersStatuses.size());
        assertTrue(allOrdersStatuses.contains(orderStatus3));
        orderStatusDao.deleteOrderStatus(orderStatus3);
        allOrdersStatuses = orderStatusDao.getAllOrdersStatuses();
        assertEquals(2, allOrdersStatuses.size());
        assertFalse(allOrdersStatuses.contains(orderStatus3));
    }

    @Test(expected = Exception.class)
    public void deleteOrderStatus1() throws Exception {
        orderStatusDao.deleteOrderStatus(orderStatus1);
    }

}
package com.yegor.dal.daoImpl;

import com.yegor.model.OrderEntity;
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
public class OrderDaoImplTest extends DalTest{
    @Test
    public void addOrderTest() throws Exception {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setLot(lot2);
        orderEntity.setOrderDate(Timestamp.valueOf("2017-07-24 17:07:07"));
        orderEntity.setBuyer(user2);
        orderEntity.setPrice(BigInteger.valueOf(300));
        orderEntity.setOrderStatus(orderStatus1);
        orderDao.addOrder(orderEntity);
        assertEquals(orderEntity, orderDao.getOrder(orderEntity.getId()));
    }

    @Test
    public void getOrderTest() throws Exception {
        assertEquals(order1, orderDao.getOrder(order1.getId()));
        assertEquals(order2, orderDao.getOrder(order2.getId()));
    }

    @Test
    public void getAllOrdersTest() throws Exception {
        List<OrderEntity> allOrders = orderDao.getAllOrders();
        assertEquals(2, allOrders.size());
        assertTrue(allOrders.contains(order1));
        assertTrue(allOrders.contains(order2));
    }

    @Test
    public void updateOrderTest() throws Exception {
        OrderEntity order = orderDao.getOrder(order1.getId());
        order.setOrderStatus(orderStatus3);
        orderDao.updateOrder(order);
        assertEquals(orderStatus3, orderDao.getOrder(order1.getId()).getOrderStatus());
    }

    @Test
    public void deleteOrderTest() throws Exception {
        List<OrderEntity> allOrders = orderDao.getAllOrders();
        assertEquals(2, allOrders.size());
        assertTrue(allOrders.contains(order2));
        orderDao.deleteOrder(order2);
        allOrders = orderDao.getAllOrders();
        assertEquals(1, allOrders.size());
        assertFalse(allOrders.contains(order2));
    }

}
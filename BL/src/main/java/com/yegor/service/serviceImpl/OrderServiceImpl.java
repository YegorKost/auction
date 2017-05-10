package com.yegor.service.serviceImpl;

import com.yegor.dal.OrderDao;
import com.yegor.model.OrderEntity;
import com.yegor.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by YegorKost on 10.05.2017.
 */
@Service
public class OrderServiceImpl implements OrderService {

    private final OrderDao orderDao;

    @Autowired
    public OrderServiceImpl(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    @Override
    public OrderEntity addOrder(OrderEntity order) {
        return orderDao.addOrder(order);
    }

    @Override
    public OrderEntity getOrder(long id) {
        return orderDao.getOrder(id);
    }

    @Override
    public List<OrderEntity> getAllOrders() {
        return orderDao.getAllOrders();
    }

    @Override
    public OrderEntity updateOrder(OrderEntity order) {
        return orderDao.updateOrder(order);
    }

    @Override
    public void deleteOrder(OrderEntity order) {
        orderDao.deleteOrder(order);
    }
}

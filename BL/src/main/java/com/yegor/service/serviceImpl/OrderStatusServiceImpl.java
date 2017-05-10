package com.yegor.service.serviceImpl;

import com.yegor.dal.OrderStatusDao;
import com.yegor.model.OrderStatusEntity;
import com.yegor.service.OrderStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by YegorKost on 10.05.2017.
 */
@Service
public class OrderStatusServiceImpl implements OrderStatusService {

    private final OrderStatusDao orderStatusDao;

    @Autowired
    public OrderStatusServiceImpl(OrderStatusDao orderStatusDao) {
        this.orderStatusDao = orderStatusDao;
    }

    @Override
    public OrderStatusEntity addOrderStatus(OrderStatusEntity orderStatus) {
        return orderStatusDao.addOrderStatus(orderStatus);
    }

    @Override
    public OrderStatusEntity getOrderStatus(int id) {
        return orderStatusDao.getOrderStatus(id);
    }

    @Override
    public List<OrderStatusEntity> getAllOrdersStatuses() {
        return orderStatusDao.getAllOrdersStatuses();
    }

    @Override
    public OrderStatusEntity updateOrderStatus(OrderStatusEntity orderStatus) {
        return orderStatusDao.updateOrderStatus(orderStatus);
    }

    @Override
    public void deleteOrderStatus(OrderStatusEntity orderStatus) {
        orderStatusDao.deleteOrderStatus(orderStatus);
    }
}

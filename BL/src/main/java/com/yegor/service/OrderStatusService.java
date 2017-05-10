package com.yegor.service;

import com.yegor.model.OrderStatusEntity;

import java.util.List;

/**
 * Created by YegorKost on 10.05.2017.
 */
public interface OrderStatusService {
    OrderStatusEntity addOrderStatus(OrderStatusEntity orderStatus);
    OrderStatusEntity getOrderStatus(int id);
    List<OrderStatusEntity> getAllOrdersStatuses();
    OrderStatusEntity updateOrderStatus(OrderStatusEntity orderStatus);
    void deleteOrderStatus(OrderStatusEntity orderStatus);
}

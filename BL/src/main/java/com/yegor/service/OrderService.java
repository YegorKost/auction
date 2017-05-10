package com.yegor.service;

import com.yegor.model.OrderEntity;

import java.util.List;

/**
 * Created by YegorKost on 10.05.2017.
 */
public interface OrderService {
    OrderEntity addOrder(OrderEntity order);
    OrderEntity getOrder(long id);
    List<OrderEntity> getAllOrders();
    OrderEntity updateOrder(OrderEntity order);
    void deleteOrder(OrderEntity order);
}

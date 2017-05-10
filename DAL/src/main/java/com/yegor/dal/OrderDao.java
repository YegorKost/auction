package com.yegor.dal;

import com.yegor.model.OrderEntity;

import java.util.List;

/**
 * Created by YegorKost on 26.04.2017.
 */
public interface OrderDao {
    OrderEntity addOrder(OrderEntity order);
    OrderEntity getOrder(long id);
    List<OrderEntity> getAllOrders();
    OrderEntity updateOrder(OrderEntity order);
    void deleteOrder(OrderEntity order);
}

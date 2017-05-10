package com.yegor.dal;

import com.yegor.model.OrderStatusEntity;

import java.util.List;

/**
 * Created by YegorKost on 26.04.2017.
 */
public interface OrderStatusDao {
    OrderStatusEntity addOrderStatus(OrderStatusEntity orderStatus);
    OrderStatusEntity getOrderStatus(int id);
    List<OrderStatusEntity> getAllOrdersStatuses();
    OrderStatusEntity updateOrderStatus(OrderStatusEntity orderStatus);
    void deleteOrderStatus(OrderStatusEntity orderStatus);

}

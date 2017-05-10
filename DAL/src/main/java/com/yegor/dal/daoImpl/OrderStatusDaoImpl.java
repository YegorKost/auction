package com.yegor.dal.daoImpl;

import com.yegor.dal.OrderStatusDao;
import com.yegor.model.OrderStatusEntity;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * Created by YegorKost on 02.05.2017.
 */
@Transactional
@Repository
public class OrderStatusDaoImpl implements OrderStatusDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderStatusDaoImpl.class);

    private SessionFactory sessionFactory;

    @Resource(name = "sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public OrderStatusEntity addOrderStatus(OrderStatusEntity orderStatusEntity) {
        Serializable id = sessionFactory
                .getCurrentSession()
                .save(orderStatusEntity);
        LOGGER.info("Adding the order status with id - {}", id);
        return orderStatusEntity;
    }

    @Override
    public OrderStatusEntity getOrderStatus(int id) {
        OrderStatusEntity orderStatusEntity = sessionFactory
                .getCurrentSession()
                .get(OrderStatusEntity.class, id);
        LOGGER.info("Getting the order status with id - {}", orderStatusEntity.getId());
        return orderStatusEntity;
    }

    @Override
    public List<OrderStatusEntity> getAllOrdersStatuses() {
        List<OrderStatusEntity> allOrderStatus = sessionFactory
                .getCurrentSession()
                .createNamedQuery("getAllOrderStatus", OrderStatusEntity.class)
                .getResultList();
        LOGGER.info("Getting all orders statuses");
        return allOrderStatus;
    }

    @Override
    public OrderStatusEntity updateOrderStatus(OrderStatusEntity orderStatusEntity) {
        sessionFactory
                .getCurrentSession()
                .update(orderStatusEntity);
        LOGGER.info("Updating the order status with id - {}", orderStatusEntity.getId());
        return orderStatusEntity;
    }

    @Override
    public void deleteOrderStatus(OrderStatusEntity orderStatusEntity) {
        sessionFactory
                .getCurrentSession()
                .delete(orderStatusEntity);
        LOGGER.info("Deleting the order status with id - {}", orderStatusEntity.getId());
    }
}

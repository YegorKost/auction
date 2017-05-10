package com.yegor.dal.daoImpl;

import com.yegor.dal.OrderDao;
import com.yegor.model.OrderEntity;
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
public class OrderDaoImpl implements OrderDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderDaoImpl.class);

    private SessionFactory sessionFactory;

    @Resource(name = "sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        LOGGER.info("------- Getting SessionFactory {} ", sessionFactory);
        this.sessionFactory = sessionFactory;
    }

    @Override
    public OrderEntity addOrder(OrderEntity orderEntity) {
        Serializable id = sessionFactory
                .getCurrentSession()
                .save(orderEntity);
        LOGGER.info("Adding the order with id - {}", id);
        return orderEntity;
    }

    @Override
    public OrderEntity getOrder(long id) {
        OrderEntity orderEntity = sessionFactory
                .getCurrentSession()
                .get(OrderEntity.class, id);
        LOGGER.info("Getting the order with id - {}", orderEntity.getId());
        return orderEntity;
    }

    @Override
    public List<OrderEntity> getAllOrders() {
        List<OrderEntity> allOrders = sessionFactory
                .getCurrentSession()
                .createNamedQuery("getAllOrders", OrderEntity.class)
                .getResultList();
        LOGGER.info("Getting all orders");
        return allOrders;
    }

    @Override
    public OrderEntity updateOrder(OrderEntity orderEntity) {
        sessionFactory
                .getCurrentSession()
                .update(orderEntity);
        LOGGER.info("Updating the order with id - {}", orderEntity.getId());
        return orderEntity;
    }

    @Override
    public void deleteOrder(OrderEntity orderEntity) {
        sessionFactory
                .getCurrentSession()
                .delete(orderEntity);
        LOGGER.info("Deleting the order with id - {}", orderEntity.getId());
    }
}

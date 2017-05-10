package com.yegor.dal.daoImpl;

import com.yegor.dal.UserDao;
import com.yegor.model.UserEntity;
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
public class UserDaoImpl implements UserDao {

    public static final Logger LOGGER = LoggerFactory.getLogger(UserDaoImpl.class);

    private SessionFactory sessionFactory;

    @Resource(name = "sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public UserEntity addUser(UserEntity userEntity) {
        Serializable id = sessionFactory
                .getCurrentSession()
                .save(userEntity);
        LOGGER.info("Adding the user with id - {}", id);
        return userEntity;
    }

    @Override
    public UserEntity getUser(long id) {
        UserEntity userEntity = sessionFactory
                .getCurrentSession()
                .get(UserEntity.class, id);
        LOGGER.info("Getting the user with id - {}", userEntity.getId());
        return userEntity;
    }

    @Override
    public UserEntity getUserByLogin(String login) {
        UserEntity userEntity = sessionFactory
                .getCurrentSession()
                .createNamedQuery("getUserByLogin", UserEntity.class)
                .setParameter("login", login)
                .uniqueResult();
        return userEntity;
    }

    @Override
    public List<UserEntity> getAllUsers() {
        List<UserEntity> allUsers = sessionFactory
                .getCurrentSession()
                .createNamedQuery("getAllUsers", UserEntity.class)
                .getResultList();
        LOGGER.info("Getting all users");
        return allUsers;
    }

    @Override
    public UserEntity updateUser(UserEntity userEntity) {
        sessionFactory
                .getCurrentSession()
                .update(userEntity);
        LOGGER.info("Updating the user with id - {}", userEntity.getId());
        return userEntity;
    }

    @Override
    public void deleteUser(UserEntity userEntity) {
        sessionFactory
                .getCurrentSession()
                .delete(userEntity);
        LOGGER.info("Deleting the user with id - {}", userEntity.getId());
    }
}

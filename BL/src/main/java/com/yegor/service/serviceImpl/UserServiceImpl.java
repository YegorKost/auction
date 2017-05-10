package com.yegor.service.serviceImpl;

import com.yegor.dal.UserDao;
import com.yegor.model.UserEntity;
import com.yegor.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by YegorKost on 10.05.2017.
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public UserEntity addUser(UserEntity user) {
        return userDao.addUser(user);
    }

    @Override
    public UserEntity getUser(long id) {
        return userDao.getUser(id);
    }

    @Override
    public UserEntity getUserByLogin(String login) {
        return userDao.getUserByLogin(login);
    }

    @Override
    public List<UserEntity> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public UserEntity updateUser(UserEntity user) {
        return userDao.updateUser(user);
    }

    @Override
    public void deleteUser(UserEntity user) {
        userDao.deleteUser(user);
    }
}

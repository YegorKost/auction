package com.yegor.service;

import com.yegor.model.UserEntity;

import java.util.List;

/**
 * Created by YegorKost on 10.05.2017.
 */
public interface UserService {
    UserEntity addUser(UserEntity user);
    UserEntity getUser(long id);
    UserEntity getUserByLogin(String login);
    List<UserEntity> getAllUsers();
    UserEntity updateUser(UserEntity user);
    void deleteUser(UserEntity user);
}

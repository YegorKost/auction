package com.yegor.dal;

import com.yegor.model.UserEntity;

import java.util.List;

/**
 * Created by YegorKost on 26.04.2017.
 */
public interface UserDao {
    UserEntity addUser(UserEntity user);
    UserEntity getUser(long id);
    UserEntity getUserByLogin(String login);
    List<UserEntity> getAllUsers();
    UserEntity updateUser(UserEntity user);
    void deleteUser(UserEntity user);
}

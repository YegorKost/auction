package com.yegor.dal.daoImpl;

import com.yegor.model.UserEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by YegorKost on 02.05.2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class UserDaoImplTest extends DalTest{
    @Test
    public void addUserTest() throws Exception {
        UserEntity user = new UserEntity();
        user.setEmail("eNew@mail.com");
        user.setFirstName("firstNew");
        user.setLastName("lastNew");
        user.setLogin("loginNew");
        user.setPassword("passwordNew");
        user.setPhoneNumber("7777777777");
        user.setRole(role1);
        userDao.addUser(user);
        assertEquals(user, userDao.getUser(user.getId()));
    }

    @Test
    public void getUserTest() throws Exception {
        assertEquals(user1, userDao.getUser(user1.getId()));
        assertEquals(user2, userDao.getUser(user2.getId()));
    }

    @Test
    public void getUserByLoginTest() throws Exception {
        assertEquals(user1, userDao.getUserByLogin(user1.getLogin()));
        assertEquals(user2, userDao.getUserByLogin(user2.getLogin()));
    }

    @Test
    public void getAllUsersTest() throws Exception {
        List<UserEntity> allUsers = userDao.getAllUsers();
        assertEquals(2, allUsers.size());
        assertTrue(allUsers.contains(user1));
        assertTrue(allUsers.contains(user2));
    }

    @Test
    public void updateUserTest() throws Exception {
        UserEntity user = userDao.getUser(user2.getId());
        user.setRole(role1);
        userDao.updateUser(user);
        assertEquals(role1, userDao.getUser(user2.getId()).getRole());
    }

    @Test
    public void deleteUserTest() throws Exception {
        List<UserEntity> allUsers = userDao.getAllUsers();
        assertEquals(2, allUsers.size());
        assertTrue(allUsers.contains(user1));
        userDao.deleteUser(user1);
        allUsers = userDao.getAllUsers();
        assertEquals(1, allUsers.size());
        assertFalse(allUsers.contains(user1));
    }

    @Test(expected = Exception.class)
    public void deleteUserTest1() throws Exception {
        userDao.deleteUser(user2);
    }

}
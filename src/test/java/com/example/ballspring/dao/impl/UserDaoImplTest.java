package com.example.ballspring.dao.impl;

import com.example.ballspring.dao.UserDao;
import com.example.ballspring.dao.UserLoginRequest;
import com.example.ballspring.dao.UserRegisterRequest;
import com.example.ballspring.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserDaoImplTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void getByMname(){
        UserRegisterRequest userRegisterRequest= new UserRegisterRequest();
        userRegisterRequest.setUsername("108442099");
        User user = userDao.getByMname(userRegisterRequest);
        assertNotNull(user);
        assertEquals("cvb@gmail.com", user.getEmail());
    }
    @Test
    @Transactional
    public void register(){
        UserRegisterRequest userRegisterRequest = new UserRegisterRequest();
        userRegisterRequest.setUsername("10994013");
        userRegisterRequest.setPassword("123");
        userRegisterRequest.setEmail("ggi@gmail.com");
        userDao.register(userRegisterRequest);
        User user = new User();
        user = userDao.getByMname(userRegisterRequest);
        assertNotNull(user);
        assertEquals("10994013", user.getUsername());
        assertEquals("ggi@gmail.com", user.getEmail());
    }

    @Test
    @Transactional
    public void login(){
        UserRegisterRequest userRegisterRequest = new UserRegisterRequest();
        userRegisterRequest.setUsername("10994013");
        userRegisterRequest.setPassword("123");
        userRegisterRequest.setEmail("ggi@gmail.com");
        userDao.register(userRegisterRequest);
        UserLoginRequest userLoginRequest = new UserLoginRequest();
        userLoginRequest.setUsername("10994013");
        userLoginRequest.setPassword("123");
        User user = new User();
        user = userDao.login(userLoginRequest);
        assertNotNull(user);
        assertEquals("10994013", user.getUsername());
        assertEquals("ggi@gmail.com", user.getEmail());
    }

}
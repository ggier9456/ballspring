package com.example.ballspring.service.impl;

import com.example.ballspring.dao.UserDao;
import com.example.ballspring.dao.UserLoginRequest;
import com.example.ballspring.dao.UserRegisterRequest;
import com.example.ballspring.model.User;
import com.example.ballspring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public String getByMname(UserRegisterRequest userRegisterRequest) {
        User user = new User();
        user = userDao.getByMname(userRegisterRequest);
        if(user != null){
            return "帳號已有人註冊！";
        }else{
            return "ok";
        }
    }

    @Override
    public String register(UserRegisterRequest userRegisterRequest) {
        if(userRegisterRequest.getPassword().equals(userRegisterRequest.getrPassword())){
            return userDao.register(userRegisterRequest);
        }else{
            return "輸入密碼與確認密碼不一致！";
        }
    }

    @Override
    public User login(UserLoginRequest userLoginRequest) {
        User user = userDao.login(userLoginRequest);
        if(user == null){
            return null;
        }else{
            return user;
        }
    }

    @Override
    public User getMember(UserRegisterRequest userRegisterRequest) {
        User user = new User();
        user = userDao.getByMname(userRegisterRequest);
        return user;
    }
}

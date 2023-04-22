package com.example.ballspring.dao;

import com.example.ballspring.model.User;

public interface UserDao {
    User getByMname(UserRegisterRequest userRegisterRequest);
    String register(UserRegisterRequest userRegisterRequest);

    User login(UserLoginRequest userLoginRequest);
}

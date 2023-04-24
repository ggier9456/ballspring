package com.example.ballspring.dao;

import com.example.ballspring.model.User;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface UserDao {
    User getByMname(UserRegisterRequest userRegisterRequest);
    String register(UserRegisterRequest userRegisterRequest);

    User login(UserLoginRequest userLoginRequest);
}

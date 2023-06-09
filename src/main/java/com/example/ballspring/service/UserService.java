package com.example.ballspring.service;

import com.example.ballspring.dao.UserLoginRequest;
import com.example.ballspring.dao.UserRegisterRequest;
import com.example.ballspring.model.User;
import org.springframework.transaction.annotation.Transactional;


@Transactional
public interface UserService {
    String getByMname(UserRegisterRequest userRegisterRequest);
    String register(UserRegisterRequest userRegisterRequest);

    User login(UserLoginRequest userLoginRequest);
    User getMember(UserRegisterRequest userRegisterRequest);
}

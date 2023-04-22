package com.example.ballspring.dao.impl;


import com.example.ballspring.dao.UserDao;
import com.example.ballspring.dao.UserLoginRequest;
import com.example.ballspring.dao.UserRegisterRequest;
import com.example.ballspring.mapper.UserRowMapper;
import com.example.ballspring.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class UserDaoImpl implements UserDao {

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public User getByMname(UserRegisterRequest userRegisterRequest) {
        String sql ="CALL get_user(:username)";
        Map<String, Object> map = new HashMap<>();
        map.put("username", userRegisterRequest.getUsername());
        List<User> list = namedParameterJdbcTemplate.query(sql, map, new UserRowMapper());
        if(list.size()>0){
            return list.get(0);
        }else{
            return null;
        }
    }
    @Override
    public String register(UserRegisterRequest userRegisterRequest) {
        String sql="CALL register(:username, :email, :password)";
        Map<String, Object> map = new HashMap<>();
        map.put("username", userRegisterRequest.getUsername());
        map.put("email", userRegisterRequest.getEmail());
        map.put("password", userRegisterRequest.getPassword());
        namedParameterJdbcTemplate.update(sql, map);
        return "ok";
    }

    @Override
    public User login(UserLoginRequest userLoginRequest) {
        String sql = "CALL login_user(:username, :password)";
        Map<String, Object> map = new HashMap<>();
        map.put("username", userLoginRequest.getUsername());
        map.put("password", userLoginRequest.getPassword());
        List<User> list=namedParameterJdbcTemplate.query(sql, map, new UserRowMapper());
        if(list.size()>0){
            return list.get(0);
        }else{
            return null;
        }
    }
}

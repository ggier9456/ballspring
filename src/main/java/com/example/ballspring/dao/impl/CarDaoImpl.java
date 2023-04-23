package com.example.ballspring.dao.impl;

import com.example.ballspring.dao.AddToCarRequest;
import com.example.ballspring.dao.CarDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class CarDaoImpl implements CarDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    @Override
    public String addToCar(AddToCarRequest addToCarRequest) {
        String sql = "CALL add_to_car(:username, :amount, :pId)";
        Map<String, Object> map = new HashMap<>();
        map.put("username", addToCarRequest.getUsername());
        map.put("amount", addToCarRequest.getAmount());
        map.put("pId", addToCarRequest.getpId());
        namedParameterJdbcTemplate.update(sql, map);
        return "ok";
    }
}

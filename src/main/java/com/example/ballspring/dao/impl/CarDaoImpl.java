package com.example.ballspring.dao.impl;

import com.example.ballspring.dao.AddToCarRequest;
import com.example.ballspring.dao.CarDao;
import com.example.ballspring.mapper.CarRowMapper;
import com.example.ballspring.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
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

    @Override
    public List<Car> getCar(String username) {
        String sql ="CALL get_car(:username)";
        Map<String, String> map = new HashMap<>();
        map.put("username", username);
        List<Car> list = namedParameterJdbcTemplate.query(sql, map, new CarRowMapper());
        if(list.size()>0){
            return list;
        }else{
            return null;
        }
    }
    @Override
    public String delCar(Integer c_id) {
        String sql="CALL del_car(:cId)";
        Map<String, Integer> map= new HashMap<>();
        map.put("cId", c_id);
        namedParameterJdbcTemplate.update(sql, map);
        return "ok";
    }

    @Override
    public String sendCar(String username){
        String sql = "CALL send_car(:username)";
        Map<String, String> map = new HashMap<>();
        map.put("username", username);
        namedParameterJdbcTemplate.update(sql, map);
        return "ok";
    }
}

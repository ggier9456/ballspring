package com.example.ballspring.mapper;

import com.example.ballspring.model.Car;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CarRowMapper implements RowMapper<Car> {
    @Override
    public Car mapRow(ResultSet rs, int rowNum) throws SQLException {
        Car car = new Car();
        car.setpName(rs.getString("pName"));
        car.setpImg(rs.getString("pImg"));
        car.setAmount(rs.getInt("amount"));
        car.setpPrice(rs.getInt("pPrice"));
        car.setcId(rs.getInt("cId"));
        return car;
    }
}

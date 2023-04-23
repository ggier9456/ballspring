package com.example.ballspring.dao;

import com.example.ballspring.model.Car;

import java.util.List;

public interface CarDao {

    String addToCar(AddToCarRequest addToCarRequest);
    List<Car> getCar(String username);

    String delCar(Integer c_id);
}

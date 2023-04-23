package com.example.ballspring.service;

import com.example.ballspring.dao.AddToCarRequest;
import com.example.ballspring.model.Car;

import java.util.List;

public interface CarService {

    String AddToCar(AddToCarRequest addToCarRequest);
    List<Car> getCar(String username);

    Integer getTotalPrive(List<Car> list);

    String delCar(Integer cId);
}

package com.example.ballspring.dao;

import com.example.ballspring.model.Car;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface CarDao {

    String addToCar(AddToCarRequest addToCarRequest);
    List<Car> getCar(String username);

    String delCar(Integer c_id);
}

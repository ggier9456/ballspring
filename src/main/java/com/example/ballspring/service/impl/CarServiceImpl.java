package com.example.ballspring.service.impl;

import com.example.ballspring.dao.AddToCarRequest;
import com.example.ballspring.dao.CarDao;
import com.example.ballspring.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CarServiceImpl implements CarService {

    @Autowired
    private CarDao carDao;

    @Override
    public String AddToCar(AddToCarRequest addToCarRequest) {
        return carDao.addToCar(addToCarRequest);
    }
}

package com.example.ballspring.service.impl;

import com.example.ballspring.dao.AddToCarRequest;
import com.example.ballspring.dao.CarDao;
import com.example.ballspring.model.Car;
import com.example.ballspring.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CarServiceImpl implements CarService {

    @Autowired
    private CarDao carDao;

    @Override
    public String AddToCar(AddToCarRequest addToCarRequest) {
        return carDao.addToCar(addToCarRequest);
    }

    @Override
    public List<Car> getCar(String username) {
        return carDao.getCar(username);
    }

    @Override
    public Integer getTotalPrive(List<Car> list) {
        int price = 0;
        Car car = new Car();
        if(list.size()>0){
            for(int i=0; i<list.size(); i++){
                car = list.get(i);
                price += car.getpPrice() * car.getAmount();
            }
            return price;
        }else{
            return null;
        }

    }

    @Override
    public String delCar(Integer cId) {
        return carDao.delCar(cId);
    }
}

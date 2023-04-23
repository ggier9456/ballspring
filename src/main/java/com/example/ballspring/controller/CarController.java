package com.example.ballspring.controller;


import com.example.ballspring.dao.AddToCarRequest;
import com.example.ballspring.model.Car;
import com.example.ballspring.model.User;
import com.example.ballspring.service.CarService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CarController {

    @Autowired
    private CarService carService;

    @PostMapping("/addToCar")
    public String addToCar(@RequestParam(name="p_amount") Integer amount,
                           @RequestParam(name="quick_buy", required = false) String quickBuy,
                           @RequestParam(name="id") Integer pId,
                           @SessionAttribute(name="user",  required=false) User user){
        AddToCarRequest addToCarRequest = new AddToCarRequest();
        if(user != null){
            addToCarRequest.setUsername(user.getUsername());
            addToCarRequest.setAmount(amount);
            addToCarRequest.setpId(pId);
            carService.AddToCar(addToCarRequest);
            if(quickBuy!=null){
                return "redirect:/car";
            }else{
                return "/car/addCar_ok";
            }
        }else if(user == null){
            return "/user/signin";
        }else{
            return "/index";
        }
    }

    @GetMapping("/car")
    public String car(@SessionAttribute(name="user", required = false) User user,
                      Model model){
        if(user != null){
            List<Car> list = carService.getCar(user.getUsername());
            if(list !=null){
                int price = carService.getTotalPrive(list);
                model.addAttribute("carList", list);
                model.addAttribute("totalPrice", price);
            }
            return "/car/car";
        }else{
            return "/user/signin";
        }
    }

    @DeleteMapping("/car/{cId}")
    public String delCar(@PathVariable Integer cId,
                         @SessionAttribute(name="user", required = false) User user,
                         Model model){
        carService.delCar(cId);
        List<Car> list = carService.getCar(user.getUsername());
        if(list !=null){
//            int price = carService.getTotalPrive(list);
            model.addAttribute("carList", list);
//            model.addAttribute("totalPrice", price);
        }
        return "/car/car";
    }

}

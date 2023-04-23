package com.example.ballspring.controller;


import com.example.ballspring.dao.UserLoginRequest;
import com.example.ballspring.dao.UserRegisterRequest;
import com.example.ballspring.model.User;
import com.example.ballspring.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/signup")
    public String signupPage(){
        return "/user/signup";
    }

    @GetMapping("/signin")
    public String signinPage(){
        return "/user/signin";
    }

    @PostMapping("/signup_form")
    public String register(@RequestParam(name = "username") String userName,
                           @RequestParam(name = "email") String email,
                           @RequestParam(name = "password") String password,
                           @RequestParam(name = "password2") String rPassword,
                           Model model) {
        UserRegisterRequest userRegisterRequest = new UserRegisterRequest();
        userRegisterRequest.setUsername(userName);
        userRegisterRequest.setEmail(email);
        userRegisterRequest.setPassword(password);
        userRegisterRequest.setrPassword(rPassword);
        String getResult = userService.getByMname(userRegisterRequest);
        if (getResult.equals("ok")) {
            String registerResult =userService.register(userRegisterRequest);
            if(registerResult.equals("ok")){
                return "/user/signup_ok";
            }else{
                model.addAttribute("pwInConsistent", registerResult);
                return "/user/signup";
            }
        }else {
            model.addAttribute("notRegister", getResult);
            return "/user/signup";
        }
    }
    @PostMapping("/signin_form")
    public String login(@RequestParam(name="username") String username,
                        @RequestParam(name="password") String password,
                        Model model,
                        HttpSession session){
        UserLoginRequest userLoginRequest = new UserLoginRequest();
        userLoginRequest.setUsername(username);
        userLoginRequest.setPassword(password);
        User user = userService.login(userLoginRequest);
        if(user == null){
            model.addAttribute("noLogin", "帳號密碼輸入錯誤！");
            return "/user/signin";
        }else{
            session.setAttribute("user", user);
            return "redirect:/";
        }
    }

    @GetMapping("/signout")
    public String logout(HttpSession session){
        if(session.getAttribute("user") != null){
            session.removeAttribute("user");
        }
        return "redirect:/";
    }
    @GetMapping("/member")
    public String member(@SessionAttribute(name="user",  required=false) User user, Model model){
        UserRegisterRequest userRegisterRequest = new UserRegisterRequest();

        if(user != null){
            userRegisterRequest.setUsername(user.getUsername());
            user = userService.getMember(userRegisterRequest);
            model.addAttribute("username", user.getUsername());
            model.addAttribute("email", user.getEmail());
            return "/user/member";
        }else{
            return "/user/signin";
        }
    }
}

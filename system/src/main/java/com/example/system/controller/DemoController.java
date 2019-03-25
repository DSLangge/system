package com.example.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class DemoController {

    @RequestMapping("/user_login")
    public String login(String verify,HttpServletRequest req, HttpServletResponse resp){
        if (req.getSession().getAttribute("vrifyCode").equals(verify)){
            return "index";
        }
        return "login";
    }
}

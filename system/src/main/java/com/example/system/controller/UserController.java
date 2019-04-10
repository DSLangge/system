package com.example.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class UserController {

    @RequestMapping("/user_login")
    public String login(String verify,HttpServletRequest req, HttpServletResponse resp){
        /**
         * 此处根据登录的用户名和密码，查找相应用户，存储再session中，以便验证是否登录成功后操作是否被允许
         */
        if (req.getSession().getAttribute("vrifyCode").equals(verify)){
            return "index";
        }
        return "login";
    }
    @RequestMapping("/user_loginOut")
    public String loginOut(HttpServletRequest req, HttpServletResponse resp){
        /**
         * 此处删除登录信息，移除session中的登录对象
        */
        req.getSession().removeAttribute("vrifyCode");
        return "login";
    }
}

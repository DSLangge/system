package com.example.system.controller;

import com.example.system.dao.LoginMapper;
import com.example.system.dto.LoginDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class UserController {

    @Resource
    LoginMapper loginMapper;

    @RequestMapping("/user_login")
    public String login(LoginDTO loginDTO, HttpServletRequest req, HttpServletResponse resp){
        /**
         * 定义一个登录表单的DTO
         */
        if(req.getSession().getAttribute("vrifyCode").equals(loginDTO.getVerify())){
//            switch (loginDTO.getPower()){
//                case 0:
//                    loginMapper.stuLogin(loginDTO.getUserid(),loginDTO.getPassword());
//                    return "index";
//                case 1:
//                    loginMapper.teachLogin(loginDTO.getUserid(),loginDTO.getPassword());
//                    return "index";
//                case 2:
//                    loginMapper.userLogin(loginDTO.getUserid(),loginDTO.getPassword());
//                    return "index";
//            }
            System.out.println(123);
            return "admin/index/index";
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

package com.example.system.controller;

import com.example.system.dao.UserMapper;
import com.example.system.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class DemoController {

    @Resource
    UserMapper userMapper;
    @GetMapping("/user")
    public List<User> say(){
        return userMapper.findAllUser();
    }
}

package com.example.system.controller;

import com.example.system.dao.UserMapper;
import com.example.system.entity.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class DemoController {

    @Resource
    UserMapper userMapper;
    @GetMapping("/user")
    public Map<String ,Object> say() throws JsonProcessingException {
        Map<String,Object> map=new HashMap<>();
        Map<String,Object> map1=new HashMap<>();
        map1.put("item",userMapper.findAllUser());
        map.put("status",200);
        map.put("rows",map1);
        return map;
    }
}

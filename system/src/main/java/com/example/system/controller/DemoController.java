package com.example.system.controller;

import com.example.system.dao.UserMapper;
import com.example.system.dto.ResultMapDTO;
import com.example.system.entity.User;
import com.example.system.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class DemoController {

    @Resource
    UserService userService;

    @GetMapping("/user")
    public ResultMapDTO say(Integer page,@RequestParam("limit") Integer limit,Integer id) throws JsonProcessingException {
        System.out.println("输入的搜索序号是"+id);
        PageInfo<User> allUser = userService.findAllUser(page, limit);
        return new ResultMapDTO(200,"",allUser.getSize(),allUser.getList());
    }


}

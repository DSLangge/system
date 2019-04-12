package com.example.system.service;

import com.example.system.dao.LoginMapper;
import com.example.system.entity.Student;
import com.example.system.entity.Teacher;
import com.example.system.entity.User;

import javax.annotation.Resource;

public class LoginServiceImpl implements LoginService {
    @Resource
    LoginMapper loginMapper;

    @Override
    public User userLogin(String user_id, String password) {
        return loginMapper.userLogin(user_id, password);
    }

    @Override
    public Teacher teachLogin(String teach_id, String password) {
        return loginMapper.teachLogin(teach_id, password);
    }

    @Override
    public Student stuLogin(String stu_id, String password) {
        return loginMapper.stuLogin(stu_id, password);
    }
}

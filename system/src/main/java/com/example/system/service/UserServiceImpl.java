package com.example.system.service;

import com.example.system.dao.UserMapper;
import com.example.system.entity.User;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    UserMapper userMapper;

    @Override
    public void insert(User user) {
        userMapper.insert(user);
    }

    @Override
    public void delete(String user_id) {
        userMapper.delete(user_id);
    }

    @Override
    public void upDate(User user) {
        userMapper.upDate(user);
    }

    @Override
    public PageInfo<User> findAllUser(Integer page,Integer limit) {
        PageHelper.startPage(page,limit);
        PageInfo<User> userPageInfo = new PageInfo<>(userMapper.findAllUser());
        return userPageInfo;
    }

    @Override
    public User findByID(Integer id) {
        return userMapper.findByID(id);
    }

    @Override
    public User findByUserID(String user_id) {
        return userMapper.findByUserID(user_id);
    }
}

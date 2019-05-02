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
    public int insert(User user) {
        return userMapper.insert(user);
    }

    @Override
    public int delete(String user_id) {
        return userMapper.delete(user_id);
    }

    @Override
    public int upDate(User user) {
        return userMapper.upDate(user);
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

    @Override
    public PageInfo<User> findUserByType(User user, Integer page, Integer limit) {
        PageHelper.startPage(page,limit);
        PageInfo<User> userPageInfo = new PageInfo<>(userMapper.findUserByType(user));
        return userPageInfo;
    }
}

package com.example.system.service;

import com.example.system.entity.User;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Component;

public interface UserService {

    int insert(User user);
    int delete(String user_id);
    int upDate(User user);
    PageInfo<User> findAllUser(Integer page, Integer limit);
    User findByID(Integer id);
    User findByUserID(String user_id);
    PageInfo<User> findUserByType(User user,Integer page, Integer limit);
}

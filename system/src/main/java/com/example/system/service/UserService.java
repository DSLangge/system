package com.example.system.service;

import com.example.system.entity.User;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Component;

public interface UserService {

    void insert(User user);
    void delete(String user_id);
    void upDate(User user);
    PageInfo<User> findAllUser(Integer page, Integer limit);
    User findByID(Integer id);
    User findByUserID(String user_id);
}

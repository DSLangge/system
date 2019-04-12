package com.example.system.service;

import com.example.system.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserService {

    void insert(User user);
    void delete(String user_id);
    void upDate(User user);
    List<User> findAllUser();
    User findByID(Integer id);
    User findByUserID(String user_id);
}

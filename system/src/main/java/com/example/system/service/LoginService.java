package com.example.system.service;

import com.example.system.entity.Student;
import com.example.system.entity.Teacher;
import com.example.system.entity.User;
import org.springframework.stereotype.Component;

@Component
public interface LoginService {
    User userLogin(String user_id, String password);
    Teacher teachLogin(String teach_id, String password);
    Student stuLogin(String stu_id, String password);
}

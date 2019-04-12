package com.example.system.service;

import com.example.system.entity.Student;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface StudentService {
    void insert(Student student);
    void delete(String stu_id);
    void upDate(Student student);
    List<Student> findAllStu();
    Student findByID(Integer id);
    Student findByStuID(String stu_id);
}

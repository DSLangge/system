package com.example.system.service;

import com.example.system.entity.Student;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Component;

import java.util.List;

public interface StudentService {
    int insert(Student student);
    int delete(String stu_id);
    int upDate(Student student);
    PageInfo<Student> findAllStu(Integer page, Integer limit);
    Student findByID(Integer id);
    Student findByStuID(String stu_id);

    PageInfo<Student> findStuByType(Student student,Integer page, Integer limit);
}

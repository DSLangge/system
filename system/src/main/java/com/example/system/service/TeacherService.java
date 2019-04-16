package com.example.system.service;

import com.example.system.entity.Teacher;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Component;


public interface TeacherService {

    void insert(Teacher teacher);
    void delete(String teach_id);
    void upDate(Teacher teacher);
    PageInfo<Teacher> findAllTeacher(Integer page, Integer limit);
    Teacher findByID(Integer id);
    Teacher findByTeachID(String teach_id);
}

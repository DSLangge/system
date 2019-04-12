package com.example.system.service;

import com.example.system.entity.Teacher;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TeacherService {

    void insert(Teacher teacher);
    void delete(String teach_id);
    void upDate(Teacher teacher);
    List<Teacher> findAllTeacher();
    Teacher findByID(Integer id);
    Teacher findByTeachID(String teach_id);
}

package com.example.system.service;

import com.example.system.dao.StudentMapper;
import com.example.system.entity.Student;

import javax.annotation.Resource;
import java.util.List;

public class StudentServiceImpl implements StudentService {

    @Resource
    StudentMapper studentMapper;
    @Override
    public void insert(Student student) {
        studentMapper.insert(student);
    }

    @Override
    public void delete(String stu_id) {
        studentMapper.delete(stu_id);
    }

    @Override
    public void upDate(Student student) {
        studentMapper.upDate(student);
    }

    @Override
    public List<Student> findAllStu() {
        return studentMapper.findAllStu();
    }

    @Override
    public Student findByID(Integer id) {
        return studentMapper.findByID(id);
    }

    @Override
    public Student findByStuID(String stu_id) {
        return studentMapper.findByStuID(stu_id);
    }
}

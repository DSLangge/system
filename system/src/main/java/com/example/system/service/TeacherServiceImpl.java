package com.example.system.service;

import com.example.system.dao.TeacherMapper;
import com.example.system.entity.Teacher;

import javax.annotation.Resource;
import java.util.List;

public class TeacherServiceImpl implements TeacherService {
    @Resource
    TeacherMapper teacherMapper;

    @Override
    public void insert(Teacher teacher) {
        teacherMapper.insert(teacher);
    }

    @Override
    public void delete(String teach_id) {
        teacherMapper.delete(teach_id);
    }

    @Override
    public void upDate(Teacher teacher) {
        teacherMapper.upDate(teacher);
    }

    @Override
    public List<Teacher> findAllTeacher() {
        return teacherMapper.findAllTeacher();
    }

    @Override
    public Teacher findByID(Integer id) {
        return teacherMapper.findByID(id);
    }

    @Override
    public Teacher findByTeachID(String teach_id) {
        return teacherMapper.findByTeachID(teach_id);
    }
}

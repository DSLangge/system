package com.example.system.service;

import com.example.system.dao.TeacherMapper;
import com.example.system.entity.Teacher;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service("teacherService")
public class TeacherServiceImpl implements TeacherService {
    @Resource
    TeacherMapper teacherMapper;

    @Override
    public int insert(Teacher teacher) {
        return teacherMapper.insert(teacher);
    }

    @Override
    public int delete(String teach_id) {
        return teacherMapper.delete(teach_id);
    }

    @Override
    public int upDate(Teacher teacher) {
        return teacherMapper.upDate(teacher);
    }

    @Override
    public PageInfo<Teacher> findAllTeacher(Integer page, Integer limit) {
        PageHelper.startPage(page,limit);
        PageInfo<Teacher> teacherPageInfo = new PageInfo<>(teacherMapper.findAllTeacher());
        return teacherPageInfo;
    }

    @Override
    public Teacher findByID(Integer id) {
        return teacherMapper.findByID(id);
    }

    @Override
    public Teacher findByTeachID(String teach_id) {
        return teacherMapper.findByTeachID(teach_id);
    }

    @Override
    public PageInfo<Teacher> findTeaByType(Teacher teacher, Integer page, Integer limit) {
        PageHelper.startPage(page,limit);
        PageInfo<Teacher> teacherPageInfo = new PageInfo<>(teacherMapper.findTeaByType(teacher));
        return teacherPageInfo;
    }
}

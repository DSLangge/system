package com.example.system.service;

import com.example.system.dao.StudentMapper;
import com.example.system.entity.Student;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("studentService")
public class StudentServiceImpl implements StudentService {

    @Resource
    StudentMapper studentMapper;
    @Override
    public int insert(Student student) {
        return studentMapper.insert(student);
    }

    @Override
    public int delete(String stu_id) {
        return studentMapper.delete(stu_id);
    }

    @Override
    public int upDate(Student student) {
        return studentMapper.upDate(student);
    }

    @Override
    public PageInfo<Student> findAllStu(Integer page, Integer limit) {
        PageHelper.startPage(page,limit);
        PageInfo<Student> studentPageInfo = new PageInfo<>(studentMapper.findAllStu());
        return studentPageInfo;
    }

    @Override
    public Student findByID(Integer id) {
        return studentMapper.findByID(id);
    }

    @Override
    public Student findByStuID(String stu_id) {
        return studentMapper.findByStuID(stu_id);
    }

    @Override
    public PageInfo<Student> findStuByType(Student student, Integer page, Integer limit) {
        PageHelper.startPage(page,limit);
        PageInfo<Student> studentPageInfo = new PageInfo<>(studentMapper.findStuByType(student));
        return studentPageInfo;
    }


}

package com.example.system.controller;

import com.example.system.dao.UserMapper;
import com.example.system.dto.ResultMapDTO;
import com.example.system.entity.Student;
import com.example.system.entity.Teacher;
import com.example.system.entity.User;
import com.example.system.service.StudentService;
import com.example.system.service.TeacherService;
import com.example.system.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
public class PersonController {

    @Resource
    UserService userService;
    @Resource
    TeacherService teacherService;
    @Resource
    StudentService studentService;

    @GetMapping("/user")
    public ResultMapDTO getUser(Integer page,@RequestParam("limit") Integer limit,Integer id) throws JsonProcessingException {
        if(id!=null){
//            需要在此判断查找结果是否为空，盖面回传数据
            List<User> list=new ArrayList<>();
            list.add(userService.findByID(id));
            return new ResultMapDTO(200,"",1,list);
        }
        PageInfo<User> allUser = userService.findAllUser(page, limit);
        return new ResultMapDTO(200,"",allUser.getSize(),allUser.getList());
    }

    @GetMapping("/teacher")
    public ResultMapDTO getTeacher(Integer page,@RequestParam("limit") Integer limit,Integer id) throws JsonProcessingException {
        if(id!=null){
//            需要在此判断查找结果是否为空，盖面回传数据
            List<Teacher> list=new ArrayList<>();
            list.add(teacherService.findByID(id));
            return new ResultMapDTO(200,"",1,list);
        }
        PageInfo<Teacher> allTeacher = teacherService.findAllTeacher(page, limit);
        return new ResultMapDTO(200,"",allTeacher.getSize(),allTeacher.getList());
    }

    @GetMapping("/student")
    public ResultMapDTO getStudent(Integer page,@RequestParam("limit") Integer limit,Integer id) throws JsonProcessingException {
        if(id!=null){
//            需要在此判断查找结果是否为空，盖面回传数据
            List<Student> list=new ArrayList<>();
            list.add(studentService.findByID(id));
            return new ResultMapDTO(200,"",1,list);
        }
        PageInfo<Student> allStu = studentService.findAllStu(page, limit);
        return new ResultMapDTO(200,"",allStu.getSize(),allStu.getList());
    }


}

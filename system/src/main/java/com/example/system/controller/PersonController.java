package com.example.system.controller;

import com.example.system.dao.UserMapper;
import com.example.system.dto.PageDTO;
import com.example.system.dto.ResultMapDTO;
import com.example.system.dto.SearchDTO;
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

    /**
     * 需要判断传入searchDTO内的数据
     * @param pageDTO
     * @param searchDTO
     * @return
     * @throws JsonProcessingException
     */
    @GetMapping("/user")
    public ResultMapDTO getUser(PageDTO pageDTO, SearchDTO searchDTO) throws JsonProcessingException {
//        if(id!=null){
////            需要在此判断查找结果是否为空，修改回传数据状态响应码
//            List<User> list=new ArrayList<>();
//            list.add(userService.findByID(id));
//            return new ResultMapDTO(200,"",1,list);
//        }
        System.out.println("这是user");
        System.out.println(searchDTO);
        System.out.println(pageDTO);
        PageInfo<User> allUser = userService.findAllUser(pageDTO.getPage(), pageDTO.getLimit());
        return new ResultMapDTO(200,"",allUser.getSize(),allUser.getList());
    }

    /**
     * 需要判断传入searchDTO内的数据
     * @param pageDTO
     * @param searchDTO
     * @return
     * @throws JsonProcessingException
     */
    @GetMapping("/teacher")
    public ResultMapDTO getTeacher(PageDTO pageDTO, SearchDTO searchDTO) throws JsonProcessingException {
//        if(id!=null){
////            需要在此判断查找结果是否为空，修改回传数据状态响应码
//            List<Teacher> list=new ArrayList<>();
//            list.add(teacherService.findByID(id));
//            return new ResultMapDTO(200,"",1,list);
//        }
        System.out.println("这是teacher");
        System.out.println(searchDTO);
        System.out.println(pageDTO);
        PageInfo<Teacher> allTeacher = teacherService.findAllTeacher(pageDTO.getPage(), pageDTO.getLimit());
        return new ResultMapDTO(200,"",allTeacher.getSize(),allTeacher.getList());
    }

    /**
     * 需要判断传入searchDTO内的数据
     * @param pageDTO
     * @param searchDTO
     * @return
     * @throws JsonProcessingException
     */
    @GetMapping("/student")
    public ResultMapDTO getStudent(PageDTO pageDTO, SearchDTO searchDTO) throws JsonProcessingException {
        System.out.println("这是student");
        System.out.println(searchDTO);
        System.out.println(pageDTO);
        PageInfo<Student> allStu = studentService.findAllStu(pageDTO.getPage(), pageDTO.getLimit());
        return new ResultMapDTO(200,"",allStu.getSize(),allStu.getList());
    }


}

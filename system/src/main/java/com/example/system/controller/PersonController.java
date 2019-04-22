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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
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

    @PostMapping("/addteacher")
    public String addTeacher(Teacher teacher){
        System.out.println(teacher);
        int i = teacherService.insert(teacher);
        if(i==1){
            return "老师添加成功";
        }
        return "老师添加失败";
    }

    @PostMapping("/editteacher")
    public String editTeacher(Teacher teacher){
        int i = teacherService.upDate(teacher);
        if(i==1){
            return "老师修改成功";
        }
        return "老师修改失败";
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

    @PostMapping("/addstudent")
    public String addStudent(Student student){
        System.out.println(student);
        int i = studentService.insert(student);
        if(i==1){
            return "学生添加成功";
        }
        return "学生添加失败";
    }

    @PostMapping("/editstudent")
    public String editStudent(Student student){
        System.out.println(student);
        int i = studentService.upDate(student);
        if(i==1){
            return "修改成功";
        }
        return "修改失败";
    }

    /**
     * 用户删除操作
     * @param batdel
     * @return
     */
    @PostMapping("/delete")
    public String deleteStudent(String  batdel,String type){
        System.out.println(batdel+type);
        int i=0;
        String[] split = batdel.split("-");
        switch (type){
            case "student":
                for (String s : split) {
                    i+=studentService.delete(s);
                }
                break;
            case "teacher":
                for (String s : split) {
                    i+=teacherService.delete(s);
                }
                break;
            case "user":
                break;
        }
        if(i==split.length){
            return "删除成功";
        }
        return "删除失败";
    }


}

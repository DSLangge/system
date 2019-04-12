package com.example.system;

import com.example.system.dao.LoginMapper;
import com.example.system.dao.StudentMapper;
import com.example.system.dao.TeacherMapper;
import com.example.system.dao.UserMapper;
import com.example.system.entity.Student;
import com.example.system.entity.Teacher;
import com.example.system.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SystemApplicationTests {

    @Resource
    UserMapper userMapper;
    @Resource
    TeacherMapper teacherMapper;
    @Resource
    StudentMapper studentMapper;
    @Resource
    LoginMapper loginMapper;

    @Test
    public void insert() {
        User user = new User();
        user.setUser_id("10004");
        user.setUser_name("李华");
        user.setPassword("123");
        userMapper.insert(user);
    }

    @Test
    public void delete() {
        userMapper.delete("10001");
    }

    @Test
    public void teacher(){
//        System.out.println(teacherMapper.findByTeachID(20001));
        Teacher teacher = new Teacher();
        teacher.setTeach_id("20005");
        teacher.setTeach_name("朱老师");
        teacher.setPassword("456");
        System.out.println(teacherMapper.findByTeachID("20001"));
    }


    @Test
    public void student() throws ParseException {
//        System.out.println(studentMapper.findByStuID("201560140330"));
        Student stu=new Student();
        stu.setStu_id("201560140331");
        stu.setStu_name("朱振源");
        stu.setPassword("78456123");
        stu.setSchool_year(new SimpleDateFormat("yyyy-MM-dd").parse("2015-09-01"));
        stu.setGraduat_year(new SimpleDateFormat("yyyy-MM-dd").parse("2019-07-01"));
        studentMapper.insert(stu);
    }

    @Test
    public void login(){
        System.out.println(loginMapper.userLogin("10001","123"));
        System.out.println(loginMapper.teachLogin("20001","123"));
        System.out.println(loginMapper.stuLogin("201560140330","123"));
    }


}

package com.example.system;

import com.example.system.dao.*;
import com.example.system.dto.IllegalPersonDTO;
import com.example.system.dto.LeaBackDTO;
import com.example.system.dto.UserGroupMsgDTO;
import com.example.system.entity.*;
import com.example.system.service.InformService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
    @Resource
    InformService informService;
    @Resource
    InformMapper informMapper;
    @Resource
    LeaBackMapper leaBackMapper;
    @Resource
    AdviceMapper adviceMapper;
    @Resource
    IllegalPerMapper illegalPerMapper;
    @Resource
    UserGroupMapper userGroupMapper;

    @Test
    public void insert() {
        User user = new User();
        user.setUser_id("10004");
//        user.setUser_name("李华");
//        user.setPassword("123");
//        userMapper.insert(user);
        System.out.println(userMapper.findUserByType(user));
    }

    @Test
    public void delete() {
//        userMapper.delete("10001");
        Inform inform = new Inform();
//        inform.setId(1);
        inform.setInf_title("良哥");
        System.out.println(inform);
        System.out.println(informMapper.findInfoByType(inform));;
    }

    @Test
    public void teacher(){
//        System.out.println(teacherMapper.findByTeachID(20001));
        Teacher teacher = new Teacher();
        teacher.setTeach_id("20005");
//        teacher.setTeach_name("朱老师");
//        teacher.setPassword("456");
        System.out.println(teacherMapper.findTeaByType(teacher));
    }


    @Test
    public void student() throws ParseException {
//        System.out.println(studentMapper.findByStuID("201560140330"));
        Student stu=new Student();
        stu.setStu_nation("汉");
//        stu.setStu_id("201560140331");
//        stu.setStu_name("朱振源");
//        stu.setPassword("78456123");
//        stu.setSchool_year(new SimpleDateFormat("yyyy-MM-dd").parse("2015-09-01"));
//        stu.setGraduat_year(new SimpleDateFormat("yyyy-MM-dd").parse("2019-07-01"));

        System.out.println(studentMapper.findStuByType(stu));;
    }

    @Test
    public void login(){
//        System.out.println(loginMapper.userLogin("10001","123"));
//        System.out.println(loginMapper.teachLogin("20001","123"));
//        System.out.println(loginMapper.stuLogin("201560140330","123"));

//        LeaBackDTO leaBackDTO = new LeaBackDTO();
//        leaBackDTO.setLea_msg("钱");
//        System.out.println(leaBackMapper.findLeaAndBackByType(leaBackDTO));
//        AdviceNote adviceNote = new AdviceNote();
//        adviceNote.setAdv_type("文件");
//        IllegalPersonDTO illegalPersonDTO = new IllegalPersonDTO();
//        illegalPersonDTO.setPer_id("201560140316");
//        System.out.println(illegalPerMapper.insert());
//        System.out.println(illegalPerMapper.findAllIll());
        UserGroupMsgDTO userGroupMsgDTO = new UserGroupMsgDTO();
        userGroupMsgDTO.setGroup_name("第");
        System.out.println(userGroupMapper.findUserGroupByType(userGroupMsgDTO));
    }
}

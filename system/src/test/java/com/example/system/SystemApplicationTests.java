package com.example.system;

import com.example.system.dao.*;
import com.example.system.dto.DataAnalyzDTO;
import com.example.system.entity.*;
import com.example.system.service.InformService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    EvaluMapper evaluMapper;
    @Resource
    UserGroupMapper userGroupMapper;

    @Resource
    DataAnalyzMapper dataAnalyzMapper;

    @Test
    public void insert() {
        User user = new User();
        user.setUser_id("10004");
//        user.setUser_name("李华");
//        user.setPassword("123");
//        userMapper.insert(user);
//        System.out.println("1".equals(1));
//        System.out.println(dataAnalyzMapper.findAdv());
//        System.out.println(dataAnalyzMapper.findInf());
//        System.out.println(dataAnalyzMapper.findLea());
//        List<DataAnalyzDTO> adv = dataAnalyzMapper.findAdv();
        Map<String,Integer> advmap= new HashMap<>();
        List<Map<String,Integer>> mapList=new ArrayList<>();
        mapList.add(advmap);
        mapList.add(advmap);
        mapList.add(advmap);
        System.out.println(mapList);
//        advmap.put("1",0);
//        advmap.put("2",0);
//        advmap.put("3",0);
//        advmap.put("4",0);
//        advmap.put("5",0);
//        advmap.put("6",0);
//        advmap.put("7",0);
//        for (String s : advmap.keySet()) {
//            for (DataAnalyzDTO dataAnalyzDTO : adv) {
//                if(s.equals(dataAnalyzDTO.getDay_week())){
//                    advmap.put(s,dataAnalyzDTO.getNum());
//                }
//            }
//        }
//        System.out.println(advmap);
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
//        UserGroupMsgDTO userGroupMsgDTO = new UserGroupMsgDTO();
//        userGroupMsgDTO.setGroup_name("第");
//        UserGroupPersonSqlDTO userGroupPersonSqlDTO = new UserGroupPersonSqlDTO();
//        userGroupPersonSqlDTO.setUser_group_id(1);
//        System.out.println(userGroupMapper.findAllGrpupPersonByType(new UserGroupPersonSqlDTO()));
//        illegalPerMapper.clean();

//        PersonEvalu personEvalu = new PersonEvalu();
//        personEvalu.setPow_id(1);
//        personEvalu.setTeach_id("20001");
//        System.out.println(evaluMapper.findScoreByPowID(personEvalu));;
        System.out.println(leaBackMapper.getBoolen(2));

    }
}

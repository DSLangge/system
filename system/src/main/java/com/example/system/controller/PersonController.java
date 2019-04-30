package com.example.system.controller;

import com.example.system.dao.UserMapper;
import com.example.system.dto.LeaBackDTO;
import com.example.system.dto.PageDTO;
import com.example.system.dto.ResultMapDTO;
import com.example.system.dto.SearchDTO;
import com.example.system.entity.*;
import com.example.system.service.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class PersonController {

    @Resource
    UserService userService;
    @Resource
    TeacherService teacherService;
    @Resource
    StudentService studentService;
    @Resource
    InformService informService;
    @Resource
    AdviceService adviceService;
    @Resource
    LeaBackService leaBackService;

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
        PageInfo<User> allUser = userService.findAllUser(pageDTO.getPage(), pageDTO.getLimit());
        ResultMapDTO resultMapDTO = new ResultMapDTO(200, "",allUser.getTotal(), allUser.getList());
        return resultMapDTO;
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
        PageInfo<Teacher> allTeacher = teacherService.findAllTeacher(pageDTO.getPage(), pageDTO.getLimit());
        return new ResultMapDTO(200,"",allTeacher.getTotal(),allTeacher.getList());
    }

    @PostMapping("/addteacher")
    public String addTeacher(Teacher teacher){
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
        PageInfo<Student> allStu = studentService.findAllStu(pageDTO.getPage(), pageDTO.getLimit());
        return new ResultMapDTO(200,"",allStu.getTotal(),allStu.getList());
    }

    @PostMapping("/addstudent")
    public String addStudent(Student student){
        int i = studentService.insert(student);
        if(i==1){
            return "学生添加成功";
        }
        return "学生添加失败";
    }

    @PostMapping("/editstudent")
    public String editStudent(Student student){
        int i = studentService.upDate(student);
        if(i==1){
            return "修改成功";
        }
        return "修改失败";
    }















    @GetMapping("/inform")
    public ResultMapDTO getInform(PageDTO pageDTO, SearchDTO searchDTO) throws JsonProcessingException {
        PageInfo<Inform> allInfo = informService.findAllInfo(pageDTO.getPage(), pageDTO.getLimit());
        return new ResultMapDTO(200,"",allInfo.getTotal(),allInfo.getList());
    }

    @PostMapping("/addinform")
    public String addInform(Inform inform){
        int i = informService.insert(inform);
        if(i==1){
            return "200";
        }
        return "0";
    }

    @PostMapping("/editinform")
    public String editInform(Inform inform){
        if(inform.getInf_pub()!=null){
            if(inform.getInf_pub()==1){
                inform.setInf_pubtime(new Date());
            }
        }
        int i = informService.update(inform);
        if(i==1){
            return "200";
        }
        return "0";
    }


    /**
     * 获取通知信息
     * @param pageDTO
     * @param searchDTO
     * @return
     * @throws JsonProcessingException
     */

    @GetMapping("/advice")
    public ResultMapDTO getAdv(PageDTO pageDTO, SearchDTO searchDTO) throws JsonProcessingException {
        PageInfo<AdviceNote> allAdv = adviceService.findAllAdv(pageDTO.getPage(), pageDTO.getLimit());
        return new ResultMapDTO(200,"",allAdv.getTotal(),allAdv.getList());
    }

    @PostMapping("/addadv")
    public String addAdv(MultipartFile file,AdviceNote adviceNote) throws IOException {
        if(null==file){
            adviceService.insert(adviceNote);
            return "0";
        }
        adviceNote.setAdv_msg(file.getOriginalFilename());
        file.transferTo( new File("F:/upload/"+file.getOriginalFilename()));   //根据指定的路径存放上传文件
        adviceService.insert(adviceNote);
        return "0";
    }


    @GetMapping("/leaback")
    public ResultMapDTO getLeaBack(PageDTO pageDTO, SearchDTO searchDTO) throws JsonProcessingException {
        PageInfo<LeaBackDTO> allLeaBack = leaBackService.findAllLeaBack(pageDTO.getPage(), pageDTO.getLimit());
        return new ResultMapDTO(200,"",allLeaBack.getTotal(),allLeaBack.getList());
    }

    @PostMapping("/addleaback")
    public String addLeaBack(FeedBack feedBack) throws IOException {
        int i = leaBackService.insert(feedBack);
        if(i==1){
            return "200";
        }
        return "0";
    }

    @PostMapping("/editleaback")
    public String editLeaBack(FeedBack feedBack) throws IOException {
        int i = leaBackService.update(feedBack);
        if(i==1){
            return "200";
        }
        return "0";
    }








    /**
     * 删除操作
     * @param batdel
     * @return
     */
    @PostMapping("/delete")
    public String delete(String  batdel,String type){
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
            case "inform":
                for (String s : split) {
                    i+=informService.delete(Integer.parseInt(s));
                }
                break;
            case "advice":
                for (String s : split) {
                    i+=adviceService.delete(Integer.parseInt(s));
                }
                break;
            case "leaback":
                for (String s : split) {
                    int n=Integer.parseInt(s);
                    i+=leaBackService.deleteLeaMess(n);
                    FeedBack byBackId = leaBackService.findByBackId(n);
                    leaBackService.delete(byBackId.getId());
                }
                break;
        }
        if(i==split.length){
            return "删除成功";
        }
        return "删除失败";
    }


}

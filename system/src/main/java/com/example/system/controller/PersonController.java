package com.example.system.controller;

import com.example.system.dao.UserMapper;
import com.example.system.dto.*;
import com.example.system.entity.*;
import com.example.system.service.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.Date;

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
    @Resource
    IllegalService illegalService;
    @Resource
    UserGroupService userGroupService;



    /**
     * 需要判断传入searchDTO内的数据
     * @param pageDTO
     * @param searchDTO
     * @return
     * @throws JsonProcessingException
     */
    @GetMapping("/user")
    public ResultMapDTO getUser(PageDTO pageDTO, SearchDTO searchDTO) throws JsonProcessingException {
        if(null!=searchDTO.getSearchcontent()){
            User user = new User();
            switch (searchDTO.getSearchtype()){
                case "user_id":
                    user.setUser_id(searchDTO.getSearchcontent());
                    break;
                case "user_name":
                    user.setUser_name(searchDTO.getSearchcontent());
                    break;
            }
            PageInfo<User> userByType = userService.findUserByType(user, pageDTO.getPage(), pageDTO.getLimit());
            return new ResultMapDTO(200, "",userByType.getTotal(), userByType.getList());
        }
        PageInfo<User> allUser = userService.findAllUser(pageDTO.getPage(), pageDTO.getLimit());
        return new ResultMapDTO(200, "",allUser.getTotal(), allUser.getList());
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
        if(null!=searchDTO.getSearchcontent()){
            Teacher teacher = new Teacher();
            switch (searchDTO.getSearchtype()){
                case "teach_id":
                    teacher.setTeach_id(searchDTO.getSearchcontent());
                    break;
                case "teach_name":
                    teacher.setTeach_name(searchDTO.getSearchcontent());
                    break;
                case "teach_sex":
                    teacher.setTeach_sex(searchDTO.getSearchcontent());
                    break;
            }
            PageInfo<Teacher> teaByType = teacherService.findTeaByType(teacher, pageDTO.getPage(), pageDTO.getLimit());
            return new ResultMapDTO(200,"",teaByType.getTotal(),teaByType.getList());
        }
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
        if(null!=searchDTO.getSearchcontent()){
            Student student = new Student();
            switch (searchDTO.getSearchtype()){
                case "stu_id":
                    student.setStu_id(searchDTO.getSearchcontent());
                    break;
                case "stu_name":
                    student.setStu_name(searchDTO.getSearchcontent());
                    break;
                case "stu_age":
                    student.setStu_age(Integer.parseInt(searchDTO.getSearchcontent()));
                    break;
                case "stu_class":
                    student.setStu_class(searchDTO.getSearchcontent());
                    break;
                case "stu_nation":
                    student.setStu_nation(searchDTO.getSearchcontent());
                    break;
                case "stu_antive":
                    student.setStu_antive(searchDTO.getSearchcontent());
                    break;
                case "stu_high":
                    student.setStu_high(searchDTO.getSearchcontent());
                    break;
            }
            PageInfo<Student> stuByType = studentService.findStuByType(student, pageDTO.getPage(), pageDTO.getLimit());
            return new ResultMapDTO(200,"",stuByType.getTotal(),stuByType.getList());
        }
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
        if(null!=searchDTO.getSearchcontent()){
            Inform inform = new Inform();
            switch (searchDTO.getSearchtype()){
                case "inf_title":
                    inform.setInf_title(searchDTO.getSearchcontent());
                    break;
                case "inf_msg":
                    inform.setInf_msg(searchDTO.getSearchcontent());
                    break;
                case "pre_id":
                    inform.setPre_id(searchDTO.getSearchcontent());
                    break;
            }
            PageInfo<Inform> infoByType = informService.findInfoByType(inform, pageDTO.getPage(), pageDTO.getLimit());
            return new ResultMapDTO(200, "",infoByType.getTotal(), infoByType.getList());
        }
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
        if(null!=searchDTO.getSearchcontent()){
            AdviceNote adviceNote = new AdviceNote();
            switch (searchDTO.getSearchtype()){
                case "adv_title":
                    adviceNote.setAdv_title(searchDTO.getSearchcontent());
                    break;
                case "adv_type":
                    adviceNote.setAdv_type(searchDTO.getSearchcontent());
                    break;
                case "adv_msg":
                    adviceNote.setAdv_msg(searchDTO.getSearchcontent());
                    break;
                case "per_adv_id":
                    adviceNote.setPer_adv_id(searchDTO.getSearchcontent());
                    break;
            }
            PageInfo<AdviceNote> advByType = adviceService.findAdvByType(adviceNote, pageDTO.getPage(), pageDTO.getLimit());
            return new ResultMapDTO(200, "",advByType.getTotal(), advByType.getList());
        }
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
        if(null!=searchDTO.getSearchcontent()){
            LeaBackDTO leaBackDTO = new LeaBackDTO();
            switch (searchDTO.getSearchtype()){
                case "lea_per_id":
                    leaBackDTO.setLea_per_id(searchDTO.getSearchcontent());
                    break;
                case "lea_msg":
                    leaBackDTO.setLea_msg(searchDTO.getSearchcontent());
                    break;
                case "back_per_id":
                    leaBackDTO.setBack_per_id(searchDTO.getSearchcontent());
                    break;
                case "back_msg":
                    leaBackDTO.setBack_msg(searchDTO.getSearchcontent());
                    break;
            }
            PageInfo<LeaBackDTO> leaAndBackByType = leaBackService.findLeaAndBackByType(leaBackDTO, pageDTO.getPage(), pageDTO.getLimit());
            return new ResultMapDTO(200, "",leaAndBackByType.getTotal(), leaAndBackByType.getList());
        }
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





    @GetMapping("/usergroup")
    public ResultMapDTO getUserGroup(PageDTO pageDTO, SearchDTO searchDTO) throws JsonProcessingException {
        if(null!=searchDTO.getSearchcontent()){
            UserGroupMsgDTO userGroupMsgDTO = new UserGroupMsgDTO();
            switch (searchDTO.getSearchtype()){
                case "group_name":
                    userGroupMsgDTO.setGroup_name(searchDTO.getSearchcontent());
                    break;
                case "po_name":
                    userGroupMsgDTO.setPo_name(searchDTO.getSearchcontent());
                    break;
            }
            PageInfo<UserGroupMsgDTO> userGroupByType = userGroupService.findUserGroupByType(userGroupMsgDTO, pageDTO.getPage(), pageDTO.getLimit());
            return new ResultMapDTO(200, "",userGroupByType.getTotal(), userGroupByType.getList());
        }
        PageInfo<UserGroupMsgDTO> allUserGroup = userGroupService.findAllUserGroup(pageDTO.getPage(), pageDTO.getLimit());
        return new ResultMapDTO(200,"",allUserGroup.getTotal(),allUserGroup.getList());
    }
    @PostMapping("/addusergroup")
    public String addUserGroup(UserGroup userGroup) throws IOException {
        int i =userGroupService.insert(userGroup);
        if(i==1){
            return "200";
        }
        return "0";
    }

    @PostMapping("/editusergroup")
    public String editUserGroup(UserGroup userGroup) throws IOException {
        int i =userGroupService.update(userGroup);
        if(i==1){
            return "200";
        }
        return "0";
    }








    /**
     * 违规操作
     * @param pageDTO
     * @param searchDTO
     * @return
     * @throws JsonProcessingException
     */
    @GetMapping("/illegal")
    public ResultMapDTO getIllegal(PageDTO pageDTO, SearchDTO searchDTO) throws JsonProcessingException {
        if(null!=searchDTO.getSearchcontent()){
            IllegalPersonDTO illegalPersonDTO = new IllegalPersonDTO();
            switch (searchDTO.getSearchtype()){
                case "per_id":
                    illegalPersonDTO.setPer_id(searchDTO.getSearchcontent());
                    break;
                case "po_name":
                    illegalPersonDTO.setPo_name(searchDTO.getSearchcontent());
                    break;
                case "illegal_name":
                    illegalPersonDTO.setIllegal_name(searchDTO.getSearchcontent());
                    break;
            }
            PageInfo<IllegalPersonDTO> illegalByType = illegalService.findIllegalByType(illegalPersonDTO, pageDTO.getPage(), pageDTO.getLimit());
            return new ResultMapDTO(200, "",illegalByType.getTotal(), illegalByType.getList());
        }
        illegalService.insert();
        PageInfo<IllegalPersonDTO> allIllegal = illegalService.findAllIllegal(pageDTO.getPage(), pageDTO.getLimit());
        return new ResultMapDTO(200,"",allIllegal.getTotal(),allIllegal.getList());
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
            case "illegal":
                for (String s : split) {
                    int n=Integer.parseInt(s);
                    Illegal illegal = illegalService.findByID(n);
                    studentService.delete(illegal.getPer_id());
                   i+= illegalService.delete(n);
                }
                break;
            case "usergroup":
                for (String s : split) {
                    int n=Integer.parseInt(s);
                    i+=userGroupService.delete(n);
                }
                break;
        }
        if(i==split.length){
            return "删除成功";
        }
        return "删除失败";
    }
}

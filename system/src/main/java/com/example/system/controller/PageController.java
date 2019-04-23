package com.example.system.controller;

import com.example.system.dao.LoginMapper;
import com.example.system.dto.LoginDTO;
import com.example.system.entity.Student;
import com.example.system.entity.Teacher;
import com.example.system.service.StudentService;
import com.example.system.service.TeacherService;
import com.example.system.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class PageController {

    @Resource
    LoginMapper loginMapper;

    @Resource
    UserService userService;

    @Resource
    StudentService studentService;

    @Resource
    TeacherService teacherService;


    /**
     * 登录跳转
     * @param loginDTO
     * @param req
     * @param resp
     * @return
     */
    @RequestMapping("/user_login")
    public String login(LoginDTO loginDTO, HttpServletRequest req, HttpServletResponse resp){
        /**
         * 定义一个登录表单的DTO
         */
        if(req.getSession().getAttribute("vrifyCode")!=null){
            if(req.getSession().getAttribute("vrifyCode").equals(loginDTO.getVerify())){
//            switch (loginDTO.getPower()){
//                case 0:
//                    System.out.println(loginMapper.stuLogin(loginDTO.getUserid(),loginDTO.getPassword()));;
//                    return "admin/index/index";
//                case 1:
//                    System.out.println(loginMapper.teachLogin(loginDTO.getUserid(),loginDTO.getPassword()));;
//                    return "admin/index/index";
//                case 2:
//                    System.out.println(loginMapper.userLogin(loginDTO.getUserid(),loginDTO.getPassword()));;
//                    return "admin/index/index";
//            }
                return "admin/index/index";
            }
        }
        return "login";
    }

    /**
     * 退出跳转
     * @param req
     * @param resp
     * @return
     */
    @RequestMapping("/user_loginOut")
    public String loginOut(HttpServletRequest req, HttpServletResponse resp){
        /**
         * 此处删除登录信息，移除session中的登录对象
        */
        req.getSession().removeAttribute("vrifyCode");
        return "login";
    }


    /**
     * 系统用户跳转
     * @return
     */
    @RequestMapping("/userSystem")
    public String getUserPage(){
        return "admin/index/user-menu";
    }


    /**
     *   教师用户跳转
     * @return
     */
    @RequestMapping("/teacherSystem")
    public String getTeacherPage(){
        return "admin/index/teacher-menu";
    }

    /**
     * 教师用户编辑按钮
     * @param teach_id
     * @param req
     * @return
     */
    @RequestMapping("/teacheredit")
    public String getTeacheredit(String teach_id,HttpServletRequest req){
        Teacher tea = teacherService.findByTeachID(teach_id);
        req.getSession().setAttribute("teacher",tea);
        return "admin/index/tea-edit";
    }

    /**
     * 教师添加用户跳转
     * @param teach_id
     * @param req
     * @return
     */
    @RequestMapping("/teacheradd")
    public String getTeacheradd(String teach_id,HttpServletRequest req){
        Teacher tea = teacherService.findByTeachID(teach_id);
        req.getSession().setAttribute("teacher",tea);
        return "admin/index/tea-add";
    }










    /**
     * 学生用户跳转
     * @return
     */
    @RequestMapping("/studentSystem")
    public String getStudentPage(){
        return "admin/index/student-menu";
    }

    /**
     * 学生用户编辑按钮跳转
     * @param stu_id
     * @return
     */
    @RequestMapping("/studentedit")
    public String getStudentedit(String stu_id,HttpServletRequest req){
        Student stu = studentService.findByStuID(stu_id);
        req.getSession().setAttribute("student",stu);
        return "admin/index/stu-edit";
    }

    /**
     * 学生用户添加按钮跳转
     * @return
     */
    @RequestMapping("/studentadd")
    public String getStudentadd(){
        return "admin/index/stu-add";
    }







    @RequestMapping("/informSystem")
    public String getInformPage(){
        return "admin/index/inform-menu";
    }

}

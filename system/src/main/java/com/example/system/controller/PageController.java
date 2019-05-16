package com.example.system.controller;

import com.example.system.dao.LoginMapper;
import com.example.system.dto.EvaluDetailDTO;
import com.example.system.dto.LoginDTO;
import com.example.system.dto.UserGroupPowerDTO;
import com.example.system.entity.*;
import com.example.system.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
    @Resource
    AdviceService adviceService;
    @Resource
    InformService informService;
    @Resource
    LeaBackService leaBackService;
    @Resource
    UserGroupService userGroupService;
    @Resource
    EvaluService evaluService;

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
        if(null!=req.getSession().getAttribute("vrifyCode")){
            if(req.getSession().getAttribute("vrifyCode").equals(loginDTO.getVerify())){
                switch (loginDTO.getPower()){
                    case 3:
                        Student student = loginMapper.stuLogin(loginDTO.getUserid(), loginDTO.getPassword());
                        if(null!=student){
                            return "admin/index/index";
                        }
                        req.setAttribute("loginmsg","请核对用户名、密码及角色");
                        return "login";
                    case 2:
                        Teacher teacher = loginMapper.teachLogin(loginDTO.getUserid(), loginDTO.getPassword());
                        if(null!=teacher){
                            return "admin/index/index";
                        }
                        req.setAttribute("loginmsg","请核对用户名、密码及角色");
                        return "login";
                    case 1:
                        User user = loginMapper.userLogin(loginDTO.getUserid(), loginDTO.getPassword());
                        if(null!=user){
                            if(!user.equals(req.getSession().getAttribute("userlogin"))){
                                req.getSession().setAttribute("userlogin",user);
                                return "admin/index/index";
                            }
                            req.setAttribute("loginmsg","该用户已登录");
                            return "login";
                        }
                        req.setAttribute("loginmsg","账户名密码不正确");
                        return "login";
                }
            }
            req.setAttribute("loginmsg","验证码不正确");
            return "login";
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
        req.getSession().removeAttribute("userGroupId");
        req.getSession().removeAttribute("userlogin");
        return "login";
    }

    @RequestMapping("/adminSystem")
    public String adminInfo(){
        return "admin/index/user/user-admin";
    }





    /**
     * 系统用户跳转
     * @return
     */
    @RequestMapping("/userSystem")
    public String getUserPage(HttpServletRequest req){
        if(null!=req.getSession().getAttribute("userlogin")){
            return "admin/index/user/user-menu";
        }
        return "login";
    }

    @RequestMapping("/useradd")
    public String userAdd(){
        return "admin/index/user/user-add";
    }










    /**
     *   教师用户跳转
     * @return
     */
    @RequestMapping("/teacherSystem")
    public String getTeacherPage(){
        return "admin/index/teacher/teacher-menu";
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
        return "admin/index/teacher/tea-edit";
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
        return "admin/index/teacher/tea-add";
    }










    /**
     * 学生用户跳转
     * @return
     */
    @RequestMapping("/studentSystem")
    public String getStudentPage(){
        return "admin/index/student/student-menu";
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
        return "admin/index/student/stu-edit";
    }

    /**
     * 学生用户添加按钮跳转
     * @return
     */
    @RequestMapping("/studentadd")
    public String getStudentadd(){
        return "admin/index/student/stu-add";
    }







    /**
     * 信息管理页面
     * @return
     */
    @RequestMapping("/informSystem")
    public String getInformPage(){
        return "admin/index/inform/inform-menu";
    }

    /**
     * 信息编辑
     * @param id
     * @param req
     * @return
     */
    @RequestMapping("/informedit")
    public String getInformedit(Integer id,HttpServletRequest req){
        Inform info = informService.findByID(id);
        req.getSession().setAttribute("inform",info);
        return "admin/index/inform/inform-edit";
    }

    /**
     * 信息添加
     * @return
     */
    @RequestMapping("/informadd")
    public String getInformadd(){
        return "admin/index/inform/inform-add";
    }


    /**
     * 通知主页
     * @return
     */
    @RequestMapping("/adviceSystem")
    public String getAdvicePage(){
        return "admin/index/adv/adv-menu";
    }

    /**
     * 添加通知
     * @return
     */
    @RequestMapping("/advadd")
    public String getupload(){
        return "admin/index/adv/adv-add";
    }

    /**
     * 修改通知
     * @param id
     * @param req
     * @return
     */
    @RequestMapping("/advedit")
    public String getAdvEdit(Integer id,HttpServletRequest req ){
        AdviceNote adviceNote = adviceService.findByID(id);
        req.setAttribute("adviceNote",adviceNote);
        return "admin/index/adv/adv-edit";
    }


    /**
     * 反馈主页
     * @return
     */
    @RequestMapping("/leabackSystem")
    public String getLeaAndBackPage(){
        return "admin/index/leaAndback/lea-back-menu";
    }

    /**
     * 反馈添加
     * @param feedBack
     * @param req
     * @return
     */
    @RequestMapping("/leabackadd")
    public String getLeaBavkAdd(FeedBack feedBack, HttpServletRequest req){
        req.setAttribute("back_id",feedBack.getBack_id());
        return "admin/index/leaAndback/lea-back-add";
    }

    /**
     * 修改反馈
     * @param back_id
     * @param req
     * @return
     */
    @RequestMapping("/leabackedit")
    public String getLeaBavkEdit(Integer back_id, HttpServletRequest req){
        FeedBack byBackId = leaBackService.findByBackId(back_id);
        req.setAttribute("feedBack",byBackId);
        return "admin/index/leaAndback/lea-back-edit";
    }







    @RequestMapping("/evaluSystem")
    public String geetEvalSystem(){
        return "admin/index/evalu/evalu-menu";
    }
    /**
     * 获取评价页面
     * @return
     */
    @RequestMapping("/evaluadd")
    public String geetEvalSheet(String teach_id,HttpServletRequest req){
        req.setAttribute("teach_id",teach_id);
        return "admin/index/evalu/evalu-sheet-add";
    }

    @RequestMapping("/evaludetail")
    public String evaluDetail(PersonEvalu personEvalu,HttpServletRequest req){
        EvaluDetailDTO evaluDetailDTO = new EvaluDetailDTO();
        personEvalu.setPow_id(1);
        evaluDetailDTO.setUser_score(evaluService.findScoreByPowID(personEvalu));
        personEvalu.setPow_id(2);
        evaluDetailDTO.setTeach_score(evaluService.findScoreByPowID(personEvalu));
        personEvalu.setPow_id(3);
        evaluDetailDTO.setStu_score(evaluService.findScoreByPowID(personEvalu));
        PersonEvalu userMsg = evaluService.findUserEvaluMsg(personEvalu.getTeach_id());
        if (null!=userMsg) {
            evaluDetailDTO.setEvalu_msg(userMsg.getEvalu_msg());
        }
        req.setAttribute("evaluDetailDTO",evaluDetailDTO);
        return "admin/index/evalu/evalu-detail";
    }

    @RequestMapping("/evaludetailmenuSystem")
    public String geetEvaluDetailMenuSystem(){
        return "admin/index/evalu/evalu-detail-menu";
    }











    /**
     * 用户组页面
     * @return
     */
    @RequestMapping("/usergroupSystem")
    public String getUserGroup(){
        return "admin/index/usergtoup/usergroup-menu";
    }

    @RequestMapping("/usergroupadd")
    public String getUserGroupAdd(){
        return "admin/index/usergtoup/usergroup-add";
    }

    @RequestMapping("/usergroupedit")
    public String getUserGroupEdit(Integer id, HttpServletRequest req){
        UserGroup byId = userGroupService.findById(id);
        UserGroupPowerDTO groupPower = userGroupService.findGroupPower(id);
        req.setAttribute("usergroup",byId);
        req.setAttribute("grouppower",groupPower);
        return "admin/index/usergtoup/usergroup-edit";
    }

    @RequestMapping("/usergroupselect")
    public String getUserGroupPersont(Integer id, HttpServletRequest req){
        req.getSession().setAttribute("userGroupId",id);
        return "admin/index/usergtoup/usergroup-person-menu";
    }

    @RequestMapping("/usergrouppersonadd")
    public String getUserGroupPersontAdd(Integer id, HttpServletRequest req){
        req.setAttribute("userGroupIdadd",id);
        return "admin/index/usergtoup/usergroup-person-add";
    }










    /**
     * 获取安全管理页面，违规用户管理
     * @return
     */
    @RequestMapping("/illegalSystem")
    public String getIllegal(){
        return "admin/index/illegal/illegal-menu";
    }

    /**
     * 获取系统维护页面
     * @return
     */
    @RequestMapping("/systemSetSystem")
    public String getSystemSet(){
        return "admin/index/setting/system-setting";
    }




}

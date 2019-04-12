package com.example.system.dao;

import com.example.system.entity.Student;
import com.example.system.entity.Teacher;
import com.example.system.entity.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
public interface LoginMapper {
    /**
     *根据工号密码，验证登录
     * @param user_id
     * @param password
     * @return
     */
    @Select("SELECT * FROM `javawork`.`user`  WHERE user_id=#{user_id} AND PASSWORD=#{password}")
    User userLogin(String user_id,String password);

    /**
     *根据教师工号密码，验证登录
     * @param teach_id
     * @param password
     * @return
     */
    @Select("SELECT * FROM `javawork`.`teacher`  WHERE teach_id=#{teach_id} AND PASSWORD=#{password}")
    Teacher teachLogin(String teach_id,String password);

    /**
     *根据学号密码，验证登录
     * @param stu_id
     * @param password
     * @return
     */
    @Select("SELECT * FROM `javawork`.`student`  WHERE stu_id=#{stu_id} AND PASSWORD=#{password}")
    Student stuLogin(String stu_id,String password);
}

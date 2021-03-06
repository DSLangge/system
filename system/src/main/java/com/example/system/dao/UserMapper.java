package com.example.system.dao;

import com.example.system.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserMapper {


//    添加系统用户操作
    @Insert("INSERT INTO `javawork`.`user`(`user_id`,`user_name`,`password`)\n" +
            "VALUES (#{user_id},#{user_name},123456)")
    int insert(User user);

//    删除操作
    @Update("UPDATE `javawork`.`user` SET  `del` = 1  WHERE `user_id` = #{user_id}")
    int delete(String user_id);

//    通过工号更新系统用户名和密码
    @Update("<script>" +
            "       UPDATE `javawork`.`user`" +
            "        <set>" +
            "        <if test=\"user_name!=null and user_name!=''\">" +
            "            `user_name` = #{user_name}," +
            "        </if>" +
            "        <if test=\"password!=null and password!=''\">" +
            "            `password` = #{password}," +
            "        </if>" +
            "        </set>" +
            "        WHERE `user_id` = #{user_id} and del = 0" +
            "</script>")
    int upDate(User user);

//    查找所有存在的用户
    @Select("SELECT * FROM `javawork`.`user` WHERE del=0")
    List<User> findAllUser();

//    根据ID 查找用户
    @Select("SELECT * FROM `javawork`.`user` WHERE id=#{id} AND del=0")
    User findByID(Integer id);

//    根据工号查找用户
    @Select("SELECT * FROM `javawork`.`user` WHERE user_id=#{user_id} AND del=0")
    User findByUserID(String user_id);

    @Select("<script> SELECT * FROM `javawork`.`user` " +
            "<where> " +
            "<if test=\"user_id!=null and user_id!=''\">" +
            "AND user_id like concat('%', #{user_id}, '%')"+
            "</if>"+
            "<if test=\"user_name!=null and user_name!=''\">" +
            "AND user_name like concat('%', #{user_name}, '%')"+
            "</if>"+
            "AND del=0"+
            "</where>" +
            "</script>")
    List<User> findUserByType(User user);

}

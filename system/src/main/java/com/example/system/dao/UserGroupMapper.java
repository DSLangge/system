package com.example.system.dao;

import com.example.system.dto.UserGroupMsgDTO;
import com.example.system.dto.UserGroupPersonDTO;
import com.example.system.dto.UserGroupPersonSqlDTO;
import com.example.system.dto.UserGroupPowerDTO;
import com.example.system.entity.Power;
import com.example.system.entity.UserGroup;
import com.example.system.entity.UserGroupPerson;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserGroupMapper {


    @Insert("INSERT INTO `javawork`.`user_group`(`group_name`) VALUES (#{group_name})")
    int insert(UserGroup userGroup);

    @Update("<script>" +
            "       UPDATE `javawork`.`user_group`" +
            "        <set>" +
            "        <if test=\"group_name!=null and group_name!=''\">" +
            "            `group_name` = #{group_name}," +
            "        </if>" +
            "        </set>" +
            "        WHERE `id` = #{id} and del = 0" +
            "</script>")
    int update(UserGroup userGroup);


    @Update("UPDATE `javawork`.`user_group` SET  `del` = 1  WHERE `id` = #{id}")
    int delete(Integer id);

    @Select("SELECT user_group.`id`,user_group.`group_name`,COUNT(user_and_uergroup.`user_group_id`) `sum`,POWER.`po_name`\n" +
            "FROM user_group LEFT JOIN user_and_uergroup ON user_and_uergroup.`user_group_id`=user_group.`id` AND user_and_uergroup.`del`=0\n" +
            "LEFT JOIN usergroup_and_power ON usergroup_and_power.`user_group_id`=user_group.`id`\n" +
            "LEFT JOIN POWER ON usergroup_and_power.`pow_id`=POWER.`id`\n" +
            "WHERE user_group.`del`=0\n" +
            "GROUP BY user_group.`id`")
    List<UserGroupMsgDTO> findAllUserGroup();


    @Select("<script> SELECT user_group.`id`,user_group.`group_name`,COUNT(user_and_uergroup.`user_group_id`) `sum`,POWER.`po_name`\n" +
            "FROM user_group LEFT JOIN user_and_uergroup ON user_and_uergroup.`user_group_id`=user_group.`id` \n" +
            "LEFT JOIN usergroup_and_power ON usergroup_and_power.`user_group_id`=user_group.`id`\n" +
            "LEFT JOIN POWER ON usergroup_and_power.`pow_id`=POWER.`id`\n" +
            "<where> " +
            "<if test=\"group_name!=null and group_name!=''\">" +
            "AND user_group.`group_name` like concat('%', #{group_name}, '%')"+
            "</if>"+
            "<if test=\"po_name!=null and po_name!=''\">" +
            "AND POWER.`po_name` like concat('%', #{po_name}, '%')"+
            "</if>"+
            "AND user_group.`del`=0"+
            "</where>" +
            "GROUP BY user_group.`id`" +
            "</script>")
    List<UserGroupMsgDTO> findUserGroupByType(UserGroupMsgDTO userGroupMsgDTO);


    /*
    为用户组添加权限方法
     */
    @Insert("INSERT INTO `javawork`.`usergroup_and_power`(`user_group_id`,`pow_id`)\n" +
            "VALUES (#{user_group_id},#{pow_id})")
    int insertGroupPower(UserGroupPowerDTO userGroupPowerDTO);

    @Update("<script>" +
            "       UPDATE `javawork`.`usergroup_and_power`" +
            "        <set>" +
            "        <if test=\"pow_id!=null and pow_id!=''\">" +
            "            `pow_id` = #{pow_id}," +
            "        </if>" +
            "        </set>" +
            "        WHERE `id` = #{id}" +
            "</script>")
    int updateGroupPower(UserGroupPowerDTO userGroupPowerDTO);

    @Select("SELECT * " +
            "FROM `javawork`.`usergroup_and_power`\n" +
            "WHERE user_group_id=#{user_group_id}")
    UserGroupPowerDTO findGroupPower(Integer user_group_id);

    @Select("select * from user_group where id=#{id} AND del = 0")
    UserGroup findById(Integer id);

    @Select("SELECT * FROM POWER WHERE del=0")
    List<Power> findAllPower();


    /*
        为用户组添加成员
     */
    @Insert("INSERT INTO `javawork`.`user_and_uergroup`(`user_group_id`,`per_id`,`per_pow`)\n" +
            "VALUES (#{user_group_id},#{per_id},#{per_pow})")
    int insertGroupPerson(UserGroupPerson userGroupPerson);

    @Update("UPDATE `javawork`.`user_and_uergroup` SET  `del` = 1  WHERE `id` = #{id}")
    int deleteGroupPerson( Integer id);


    @Select("SELECT user_and_uergroup.`id`,user_and_uergroup.`per_id`,POWER.`po_name`\n" +
            "FROM `user_and_uergroup` LEFT JOIN POWER ON user_and_uergroup.`per_pow`=POWER.`id`\n" +
            "WHERE user_and_uergroup.`user_group_id` =  #{user_group_id} AND user_and_uergroup.`del`=0")
    List<UserGroupPersonDTO> findAllGrpupPerson(Integer user_group_id);

    @Select("<script> " +
            "SELECT user_and_uergroup.`id`,user_and_uergroup.`per_id`,POWER.`po_name`\n" +
            "FROM `user_and_uergroup` LEFT JOIN POWER ON user_and_uergroup.`per_pow`=POWER.`id`\n" +
            "<where> " +
            "<if test=\"per_id!=null and per_id!=''\">" +
            "AND user_and_uergroup.`per_id` like concat('%', #{per_id}, '%')"+
            "</if>"+
            "<if test=\"po_name!=null and po_name!=''\">" +
            "AND POWER.`po_name` like concat('%', #{po_name}, '%')"+
            "</if>"+
            "AND user_and_uergroup.`user_group_id` = #{user_group_id} AND user_and_uergroup.`del`=0"+
            "</where>" +
            "</script>")
    List<UserGroupPersonDTO> findAllGrpupPersonByType(UserGroupPersonSqlDTO userGroupPersonSqlDTO);

}

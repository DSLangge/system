package com.example.system.dao;

import com.example.system.dto.UserGroupMsgDTO;
import com.example.system.entity.UserGroup;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
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

    @Select("select * from user_group where id=#{id} AND del = 0")
    UserGroup findById(Integer id);

    @Select("SELECT user_group.`id`,user_group.`group_name`,COUNT(user_and_uergroup.`user_group_id`) `sum`,POWER.`po_name`\n" +
            "FROM user_group LEFT JOIN user_and_uergroup ON user_and_uergroup.`user_group_id`=user_group.`id` \n" +
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
}

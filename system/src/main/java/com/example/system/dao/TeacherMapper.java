package com.example.system.dao;

import com.example.system.entity.Teacher;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TeacherMapper {
    /**
     *添加老师
     * @param teacher
     */
    @Insert("INSERT INTO `javawork`.`teacher`(`teach_id`,`teach_name`,`teach_sex`,`password`,`entry_time`)\n" +
            "VALUES (#{teach_id},#{teach_name},#{teach_sex},123456,#{entry_time})")
    int insert(Teacher teacher);

    /**
     *删除老师
     * @param teach_id
     */
    @Update("UPDATE `javawork`.`teacher` SET  `del` = 1  WHERE `teach_id` = #{teach_id}")
    int delete(String teach_id);

    /**
     *通过工号更新老师信息
     * @param teacher
     */
    @Update("<script>" +
            "       UPDATE `javawork`.`teacher`" +
            "        <set>" +
            "        <if test=\"teach_sex!=null and teach_sex!=''\">" +
            "            `teach_sex` = #{teach_sex}," +
            "        </if>" +
            "        <if test=\"password!=null and password!=''\">" +
            "            `password` = #{password}," +
            "        </if>" +
            "        <if test=\"entry_time!=null\">" +
            "            `entry_time` = #{entry_time}," +
            "        </if>"  +
            "        </set>" +
            "        WHERE `teach_id` = #{teach_id} and del = 0" +
            "</script>")
    int upDate(Teacher teacher);

    /**
     *查找所有老师
     * @return
     */

    @Select("SELECT * FROM `javawork`.`teacher` WHERE del=0")
    List<Teacher> findAllTeacher();

    /**
     *通过ID 查找老师
     * @param id
     * @return
     */
    @Select("SELECT * FROM `javawork`.`teacher` WHERE id=#{id} AND del=0")
    Teacher findByID(Integer id);

    /**
     *通过老师工号查找老师
     * @param teach_id
     * @return
     */
    @Select("SELECT * FROM `javawork`.`teacher` WHERE teach_id=#{teach_id} AND del=0")
    Teacher findByTeachID(String teach_id);


    @Select("<script> SELECT * FROM `javawork`.`teacher` " +
            "<where> " +
            "<if test=\"teach_id!=null and teach_id!=''\">" +
            "AND teach_id like concat('%', #{teach_id}, '%')"+
            "</if>"+
            "<if test=\"teach_name!=null and teach_name!=''\">" +
            "AND teach_name like concat('%', #{teach_name}, '%')"+
            "</if>"+
            "<if test=\"teach_sex!=null and teach_sex!=''\">" +
            "AND teach_sex like concat('%', #{teach_sex}, '%')"+
            "</if>"+
            "AND del=0"+
            "</where>" +
            "</script>")
    List<Teacher> findTeaByType(Teacher teacher);
}

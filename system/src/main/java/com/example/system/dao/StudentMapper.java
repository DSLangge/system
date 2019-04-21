package com.example.system.dao;

import com.example.system.entity.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface StudentMapper {
    /**
     * 添加学生
     * @param student
     * stu.setSchool_year(new SimpleDateFormat("yyyy-MM-dd").parse("2015-09-01"));
     * stu.setGraduat_year(new SimpleDateFormat("yyyy-MM-dd").parse("2019-07-01"));
     * 注意插入时的类型转换
     */
    @Insert("INSERT INTO `javawork`.`student`(`stu_id`,`stu_name`,`stu_sex`,`password`,`stu_age`,`stu_class`,`stu_nation`,`stu_birth`," +
            "`stu_proID`,`stu_phone`,`postcode`,`stu_style`,`stu_email`,`stu_high`,`stu_antive`,`school_year`,`graduat_year`)\n" +
            "VALUES (#{stu_id},#{stu_name},#{stu_sex},123456,#{stu_age},#{stu_class},#{stu_nation},#{stu_birth},#{stu_proID}," +
            "#{stu_phone},#{postcode},#{stu_style},#{stu_email},#{stu_high},#{stu_antive},#{school_year},#{graduat_year})")
    int insert(Student student);

    /**
     * 通过学号删除学生
     * @param stu_id
     */
    @Update("UPDATE `javawork`.`student` SET  `del` = 1  WHERE `stu_id` = #{stu_id}")
    int delete(String stu_id);

    /**
     * 通过学号更新学生
     * mybatis版本BUG，日期类型不能与空字符串比较，否则报：java.lang.IllegalArgumentException: invalid comparison: java.util.Date and java.lang.String
     */
    @Update("<script>" +
            "       UPDATE `javawork`.`student`" +
            "        <set>" +
            "        <if test=\"stu_sex!=null and stu_sex!=''\">" +
            "            `stu_sex` = #{stu_sex}," +
            "        </if>" +
            "        <if test=\"password!=null and password!=''\">" +
            "            `password` = #{password}," +
            "        </if>" +
            "        <if test=\"stu_age!=null and stu_age!=''\">" +
            "            `stu_age` = #{stu_age}," +
            "        </if>"  +
            "        <if test=\"stu_class!=null and stu_class!=''\">" +
            "            `stu_class` = #{stu_class}," +
            "        </if>"  +
            "        <if test=\"stu_nation!=null and stu_nation!=''\">" +
            "            `stu_nation` = #{stu_nation}," +
            "        </if>"  +
            "        <if test=\"stu_birth!=null\">" +
            "            `stu_birth` = #{stu_birth}," +
            "        </if>"  +
            "        <if test=\"stu_proID!=null and stu_proID!=''\">" +
            "            `stu_proID` = #{stu_proID}," +
            "        </if>"  +
            "        <if test=\"stu_phone!=null and stu_phone!=''\">" +
            "            `stu_phone` = #{stu_phone}," +
            "        </if>"  +
            "        <if test=\"postcode!=null and postcode!=''\">" +
            "            `postcode` = #{postcode}," +
            "        </if>"  +
            "        <if test=\"stu_style!=null and stu_style!=''\">" +
            "            `stu_style` = #{stu_style}," +
            "        </if>"  +
            "        <if test=\"stu_email!=null and stu_email!=''\">" +
            "            `stu_email` = #{stu_email}," +
            "        </if>"  +
            "        <if test=\"stu_high!=null and stu_high!=''\">" +
            "            `stu_high` = #{stu_high}," +
            "        </if>"  +
            "        <if test=\"stu_antive!=null and stu_antive!=''\">" +
            "            `stu_antive` = #{stu_antive}," +
            "        </if>"  +
            "        <if test=\"school_year!=null\">" +
            "            `school_year` = #{school_year}," +
            "        </if>"  +
            "        <if test=\"graduat_year!=null\">" +
            "            `graduat_year` = #{graduat_year}," +
            "        </if>"  +
            "        </set>" +
            "        WHERE `stu_id` = #{stu_id} and del = 0" +
            "</script>")
    int upDate(Student student);

    /**
     * 查找所有的学生
     * @return
     */
    @Select("SELECT * FROM `javawork`.`student` WHERE del=0")
    List<Student> findAllStu();

    /**
     * 通过ID 查找学生
     * @return
     */

    @Select("SELECT * FROM `javawork`.`student` WHERE id=#{id} AND del=0")
    Student findByID(Integer id);

    /**
     * 通过学号查找学生
     * @return
     */
    @Select("SELECT * FROM `javawork`.`student` WHERE stu_id=#{stu_id} AND del=0")
    Student findByStuID(String stu_id);
}

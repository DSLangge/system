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
    @Insert("INSERT INTO `javawork`.`student`(`stu_id`,`stu_name`,`stu_sex`,`password`,`stu_age`,`stu_nation`,`stu_birth`," +
            "`stu_proID`,`stu_phone`,`postcode`,`stu_style`,`stu_email`,`stu_high`,`stu_antive`,`school_year`,`graduat_year`)\n" +
            "VALUES (#{stu_id},#{stu_name},#{stu_sex},#{password},#{stu_age},#{stu_nation},#{stu_birth},#{stu_proID}," +
            "#{stu_phone},#{postcode},#{stu_style},#{stu_email},#{stu_high},#{stu_antive},#{school_year},#{graduat_year})")
    int insert(Student student);

    /**
     * 通过学号删除学生
     * @param stu_id
     */
    @Update("UPDATE `javawork`.`student` SET  `del` = 1  WHERE `stu_id` = #{stu_id}")
    int delete(String stu_id);

    /**
     * 通过学号更新学生信息
     */
    @Update("UPDATE `javawork`.`student` SET `stu_name` = #{stu_name}," +
            "   `password` = #{password} WHERE `stu_id` = #{stu_id}")
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

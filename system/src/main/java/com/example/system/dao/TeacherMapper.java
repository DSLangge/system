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
    @Insert("INSERT INTO `javawork`.`teacher`(`teach_id`,`teach_name`,`password`)\n" +
            "VALUES (#{teach_id},#{teach_name},#{password})")
    void insert(Teacher teacher);

    /**
     *删除老师
     * @param teach_id
     */
    @Update("UPDATE `javawork`.`teacher` SET  `del` = 1  WHERE `teach_id` = #{teach_id}")
    void delete(String teach_id);

    /**
     *通过工号更新老师信息
     * @param teacher
     */
    @Update("UPDATE `javawork`.`teacher` SET `teach_name` = #{teach_name}," +
            "   `password` = #{password} WHERE `teach_id` = #{teach_id}")
    void upDate(Teacher teacher);

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

}

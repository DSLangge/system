package com.example.system.dao;

import com.example.system.entity.AdviceNote;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface AdviceMapper {

    @Insert("INSERT INTO `javawork`.`advice_note`(`adv_title`,`adv_msg`,`adv_type`,`per_adv_id`,`creat_time`,`update_time`)\n" +
            "VALUES (#{adv_title},#{adv_msg},#{adv_type},#{per_adv_id},NOW(),NOW());")
    int insert(AdviceNote adviceNote);


    @Update("")
    int update(AdviceNote adviceNote);


    @Update("UPDATE `javawork`.`advice_note` SET  `del` = 1  WHERE `id` = #{id}")
    int delete(Integer id);


    @Select("SELECT * FROM `javawork`.`advice_note` WHERE del=0")
    List<AdviceNote> findAllAdv();


    @Select("SELECT * FROM `javawork`.`advice_note` WHERE id=#{id} AND del=0")
    AdviceNote findByID(Integer id);

}

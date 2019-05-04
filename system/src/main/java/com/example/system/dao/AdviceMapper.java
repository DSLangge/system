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


    @Update("<script>" +
            "       UPDATE `javawork`.`advice_note`" +
            "        <set>" +
            "        <if test=\"id!=null and id!=''\">" +
            "            `id` = #{id}," +
            "        </if>" +
            "        <if test=\"adv_title!=null and adv_title!=''\">" +
            "            `adv_title` = #{adv_title}," +
            "        </if>" +
            "        <if test=\"adv_msg!=null and adv_msg!=''\">" +
            "            `adv_msg` = #{adv_msg}," +
            "        </if>"  +
            "           `update_time`= now() "+
            "        </set>" +
            "        WHERE id = #{id} and del = 0" +
            "</script>")
    int update(AdviceNote adviceNote);


    @Update("UPDATE `javawork`.`advice_note` SET  `del` = 1  WHERE `id` = #{id}")
    int delete(Integer id);


    @Select("SELECT * FROM `javawork`.`advice_note` WHERE del=0")
    List<AdviceNote> findAllAdv();


    @Select("SELECT * FROM `javawork`.`advice_note` WHERE id=#{id} AND del=0")
    AdviceNote findByID(Integer id);

    @Select("<script> SELECT * FROM `javawork`.`advice_note` " +
                "<where> " +
                "<if test=\"adv_title!=null and adv_title!=''\">" +
                    "AND adv_title like concat('%', #{adv_title}, '%')"+
                "</if>"+
                "<if test=\"adv_type!=null and adv_type!=''\">" +
                    "AND adv_type like concat('%', #{adv_type}, '%')"+
                "</if>"+
                "<if test=\"adv_msg!=null and adv_msg!=''\">" +
                    "AND adv_msg like concat('%', #{adv_msg}, '%')"+
                "</if>"+
                "<if test=\"per_adv_id!=null and per_adv_id!=''\">" +
                    "AND per_adv_id like concat('%', #{per_adv_id}, '%')"+
                "</if>"+
                    "AND del=0"+
                "</where>" +
            "</script>")
    List<AdviceNote> findAdvByType(AdviceNote adviceNote);
}

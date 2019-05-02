package com.example.system.dao;

import com.example.system.dto.LeaBackDTO;
import com.example.system.entity.FeedBack;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface LeaBackMapper {

    @Select("SELECT lea_message.`id`,lea_message.`lea_per_id`,lea_message.`lea_msg`,lea_message.`lea_creat`,feedback.`back_per_id`,feedback.`back_msg`,feedback.`back_time`\n" +
            "FROM feedback RIGHT JOIN lea_message ON feedback.`back_id`=lea_message.`id` AND feedback.`del`=0 \n" +
            "WHERE lea_message.`del`=0 ORDER BY id")
    List<LeaBackDTO> findAllLeaAndBack();



    @Insert("INSERT INTO `javawork`.`feedback`(`back_per_id`,`back_msg`,`back_time`,`back_id`)\n" +
            "VALUES (#{back_per_id},#{back_msg},now(),#{back_id})")
    int insert(FeedBack feedBack);

    @Update("<script>" +
            "       UPDATE `javawork`.`feedback`" +
            "        <set>" +
            "        <if test=\"back_per_id!=null and back_per_id!=''\">" +
            "            `back_per_id` = #{back_per_id}," +
            "        </if>" +
            "        <if test=\"back_msg!=null and back_msg!=''\">" +
            "            `back_msg` = #{back_msg}," +
            "        </if>" +
            "        <if test=\"back_id!=null\">" +
            "            `back_id` = #{back_id}," +
            "        </if>"  +
            "           `back_time`= now() "+
            "        </set>" +
            "        WHERE id = #{id} and del = 0" +
            "</script>")
    int update(FeedBack feedBack);

    @Update("UPDATE `javawork`.`feedback` SET  `del` = 1  WHERE `id` = #{id}")
    int delete(Integer id);

    @Select("SELECT * FROM `javawork`.`feedback` WHERE back_id=#{back_id} AND del=0")
    FeedBack findByBackId(Integer back_id);


//删除留言
    @Update("UPDATE `javawork`.`lea_message` SET  `del` = 1  WHERE `id` = #{id}")
    int deleteLeaMess(Integer id);


    @Select("<script>" +
            "SELECT lea_message.`id`,lea_message.`lea_per_id`,lea_message.`lea_msg`,lea_message.`lea_creat`,feedback.`back_per_id`,feedback.`back_msg`,feedback.`back_time`\n" +
            "FROM feedback RIGHT JOIN lea_message ON feedback.`back_id`=lea_message.`id` AND feedback.`del`=0 \n" +
                "<where> " +
                "<if test=\"lea_per_id!=null and lea_per_id!=''\">" +
                    "AND lea_message.`lea_per_id` like concat('%', #{lea_per_id}, '%')"+
                "</if>"+
                "<if test=\"lea_msg!=null and lea_msg!=''\">" +
                    "AND lea_message.`lea_msg` like concat('%', #{lea_msg}, '%')"+
                "</if>"+
                "<if test=\"back_per_id!=null and back_per_id!=''\">" +
                    "AND feedback.`back_per_id` like concat('%', #{back_per_id}, '%')"+
                "</if>"+
                "<if test=\"back_msg!=null and back_msg!=''\">" +
                    "AND feedback.`back_msg` like concat('%', #{back_msg}, '%')"+
                "</if>"+
                    "AND lea_message.`del`=0 "+
                "</where>" +
            "ORDER BY id"+
            "</script>")
    List<LeaBackDTO> findLeaAndBackByType(LeaBackDTO leaBackDTO);

}

package com.example.system.dao;

import com.example.system.dto.EvaluDetailDTO;
import com.example.system.dto.EvaluTotalDTO;
import com.example.system.entity.PersonEvalu;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface EvaluMapper {

    /**
     * 清除总分表
    */
    @Select("TRUNCATE TABLE `evalu_total`")
    void clean();
    /**
     * 插入总分表
     * @param teach_id
     * @return
     */
    @Insert("INSERT INTO `javawork`.`evalu_total`(`teach_id`)\n" +
            "VALUES (#{teach_id})")
    int insertEvaTotalTeach(String teach_id);

    @Update("UPDATE `javawork`.`evalu_total` SET  `del` = 1  WHERE `teach_id` = #{teach_id}")
    int deleteEvaTotalTeach(String teach_id);

    /**
     * 插入评分表
     * @param personEvalu
     * @return
     */
    @Insert("INSERT INTO `javawork`.`per_evalu`(`score`,`teach_id`,`user_id`,`pow_id`,`evalu_msg`)\n" +
            "VALUES (#{score},#{teach_id},#{user_id},#{pow_id},#{evalu_msg});")
    int insertPersonEva(PersonEvalu personEvalu);

    /**
     * 根据教师ID，查询对应角色的评分
     * @param personEvalu
     * @return
     */
    @Select("SELECT ROUND(AVG(score),2) FROM per_evalu  WHERE teach_id=#{teach_id} AND pow_id=#{pow_id} GROUP BY pow_id")
    Double findScoreByPowID(PersonEvalu personEvalu);


    @Select("SELECT * FROM `javawork`.`per_evalu`\n" +
            "WHERE teach_id=#{teach_id} AND user_id=#{user_id}")
    PersonEvalu findByTeachIdUsersonId(String teach_id,String user_id);

    @Select("SELECT * FROM `javawork`.`per_evalu`\n" +
            "WHERE teach_id=#{teach_id} AND pow_id=#{pow_id}")
    PersonEvalu findByTeachIdPowId(String teach_id,Integer pow_id);


    @Select("SELECT * FROM `javawork`.`per_evalu`\n" +
            "WHERE teach_id=#{teach_id} AND pow_id=1")
    PersonEvalu findUserEvaluMsg(String teach_id);

    @Select("SELECT evalu_total.`id`,evalu_total.`teach_id`,teacher.`teach_name`,COUNT(per_evalu.`pow_id`=1 OR NULL) user_count\n" +
            ",COUNT(per_evalu.`pow_id`=2 OR NULL) teach_count,COUNT(per_evalu.`pow_id`=3 OR NULL) stu_count ,evalu_total.`del`\n" +
            "FROM `javawork`.`evalu_total` \n" +
            "LEFT JOIN `javawork`.`teacher` ON evalu_total.`teach_id`=teacher.`teach_id` \n" +
            "LEFT JOIN `per_evalu` ON per_evalu.`teach_id`=evalu_total.`teach_id`\n" +
            "WHERE evalu_total.`del`=0 \n" +
            "GROUP BY evalu_total.`teach_id`")
    List<EvaluTotalDTO> findAllEvaTotal();

    @Select("<script>  " +
            "SELECT evalu_total.`id`,evalu_total.`teach_id`,teacher.`teach_name`,COUNT(per_evalu.`pow_id`=1 OR NULL) user_count\n" +
            ",COUNT(per_evalu.`pow_id`=2 OR NULL) teach_count,COUNT(per_evalu.`pow_id`=3 OR NULL) stu_count ,evalu_total.`del`\n" +
            "FROM `javawork`.`evalu_total` \n" +
            "LEFT JOIN `javawork`.`teacher` ON evalu_total.`teach_id`=teacher.`teach_id` \n" +
            "LEFT JOIN `per_evalu` ON per_evalu.`teach_id`=evalu_total.`teach_id`\n" +
            "<where> " +
            "<if test=\"teach_id!=null and teach_id!=''\">" +
            "AND evalu_total.`teach_id` like concat('%', #{teach_id}, '%')"+
            "</if>"+
            "<if test=\"teach_name!=null and teach_name!=''\">" +
            "AND teacher.`teach_name` like concat('%', #{teach_name}, '%')"+
            "</if>"+
            "AND evalu_total.`del`=0"+
            "</where>" +
            "GROUP BY evalu_total.`teach_id`" +
            "</script>")
    List<EvaluTotalDTO> findAllEvaTotalByType(EvaluTotalDTO evaluTotalDTO);

    @Select("SELECT *\n" +
            "FROM `javawork`.`evalu_total`\n" +
            "WHERE del=0")
    List<EvaluDetailDTO> getDetail();


    @Update("<script>" +
            "       UPDATE `javawork`.`evalu_total`" +
            "        <set>" +
            "        <if test=\"user_score!=null and user_score!=''\">" +
            "            `user_score` = #{user_score}," +
            "        </if>" +
            "        <if test=\"teach_score!=null and teach_score!=''\">" +
            "            `teach_score` = #{teach_score}," +
            "        </if>" +
            "        <if test=\"stu_score!=null and stu_score!=''\">" +
            "            `stu_score` = #{stu_score}," +
            "        </if>"  +
            "        </set>" +
            "        WHERE teach_id = #{teach_id} and del = 0" +
            "</script>")
    int updateEvaluTotal(EvaluDetailDTO evaluDetailDTO);

    @Select("SELECT evalu_total.`teach_id`,teacher.`teach_name`,evalu_total.`user_score`,evalu_total.`teach_score`,evalu_total.`stu_score`,\n" +
            "ROUND(AVG((evalu_total.`user_score`)*0.6+(evalu_total.`teach_score`)*0.3+(evalu_total.`stu_score`)*0.1),2) score,per_evalu.`evalu_msg`\n" +
            "FROM evalu_total LEFT JOIN teacher ON evalu_total.`teach_id`= teacher.`teach_id`\n" +
            "LEFT JOIN per_evalu ON per_evalu.`teach_id` = evalu_total.`teach_id` AND per_evalu.`pow_id`=1")
    List<EvaluDetailDTO> getDetailList();




}

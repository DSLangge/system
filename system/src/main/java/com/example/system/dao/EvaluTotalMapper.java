package com.example.system.dao;

import com.example.system.entity.EvaluTotal;
import com.example.system.entity.PersonEvalu;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
public interface EvaluTotalMapper {

    /**
     * 清除总分表
    */
    @Select("TRUNCATE TABLE `evalu_total`")
    void clean();
    /**
     * 插入总分表
     * @param evaluTotal
     * @return
     */
    @Insert("INSERT INTO `javawork`.`evalu_total`(`teach_id`,`user_score`,`teach_score`,`stu_score`)\n" +
            "VALUES (#{teach_id},#{user_score},#{teach_score},#{stu_score}")
    int insertEvaTotal(EvaluTotal evaluTotal);

    /**
     * 插入评分表
     * @param personEvalu
     * @return
     */
    @Insert("INSERT INTO `javawork`.`per_evalu`(`score`,`teach_id`,`pow_id`)\n" +
            "VALUES (#{score},#{teach_id},#{pow_id});")
    int insertPersonEva(PersonEvalu personEvalu);

    @Select("SELECT ROUND(AVG(score),2) FROM per_evalu  WHERE teach_id=#{teach_id} AND pow_id=#{pow_id} GROUP BY pow_id")
    Double findScoreByPowID(PersonEvalu personEvalu);




}

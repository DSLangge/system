package com.example.system.dao;

import com.example.system.entity.Inform;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface InformMapper {
    /**
     *插入一条事务
     * @param inform
     * @return
     */
    @Insert("INSERT INTO `javawork`.`inform`(`inf_title`,`inf_msg`,`pre_id`,`inf_creatime`,`inf_updatime`)\n" +
            "VALUES (#{inf_title},#{inf_msg},#{pre_id},NOW(),NOW())")
    int insert(Inform inform);

    /**
     *根据ID 更新事务
     * @param inform
     * @return
     */
    @Update("<script>" +
            "       UPDATE `javawork`.`inform`" +
            "        <set>" +
            "        <if test=\"inf_title!=null and inf_title!=''\">" +
            "            `inf_title` = #{inf_title}," +
            "        </if>" +
            "        <if test=\"inf_msg!=null and inf_msg!=''\">" +
            "            `inf_msg` = #{inf_msg}," +
            "        </if>" +
            "        <if test=\"inf_updatime!=null\">" +
            "            `inf_updatime` = #{inf_updatime}," +
            "        </if>"  +
            "        <if test=\"inf_pubtime!=null\">" +
            "            `inf_pubtime` = #{inf_pubtime}," +
            "        </if>"  +
            "        <if test=\"inf_pub!=null\">" +
            "            `inf_pub` = #{inf_pub}," +
            "        </if>"  +
            "           `inf_updatime`= now() "+
            "        </set>" +
            "        WHERE id = #{id} and del = 0" +
            "</script>")
    int update(Inform inform);

    /**
     *根据ID 删除事务
     * @param id
     * @return
     */
    @Update("UPDATE `javawork`.`inform` SET  `del` = 1  WHERE `id` = #{id}")
    int delete(Integer id);

    /**
     *查找所有通知事务
     * @return
     */
    @Select("SELECT * FROM `javawork`.`inform` WHERE del=0")
    List<Inform> findAllInfo();

    /**
     * 通过ID查找通知事务
     * @param id
     * @return
     */
    @Select("SELECT * FROM `javawork`.`inform` WHERE id=#{id} AND del=0")
    Inform findByID(Integer id);

    @Select("<script> SELECT * FROM `javawork`.`inform` " +
            "<where> " +
            "<if test=\"inf_title!=null and inf_title!=''\">" +
            "AND inf_title like concat('%', #{inf_title}, '%')"+
            "</if>"+
            "<if test=\"inf_msg!=null and inf_msg!=''\">" +
            "AND inf_msg like concat('%', #{inf_msg}, '%')"+
            "</if>"+
            "<if test=\"pre_id!=null and pre_id!=''\">" +
            "AND pre_id like concat('%', #{pre_id}, '%')"+
            "</if>"+
            "AND del=0"+
            "</where>" +
            "</script>")
    List<Inform> findInfoByType(Inform inform);
}

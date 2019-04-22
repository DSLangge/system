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
    @Insert("")
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
            "        <if test=\"inf_pub!=null and inf_pub!=''\">" +
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
}

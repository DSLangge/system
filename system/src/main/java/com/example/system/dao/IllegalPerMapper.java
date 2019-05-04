package com.example.system.dao;

import com.example.system.dto.IllegalPersonDTO;
import com.example.system.entity.Illegal;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface IllegalPerMapper {

    @Select("SELECT illegal.`id`,illegal.`per_id`,POWER.`po_name`,illegaltype.`illegal_name`\n" +
            "FROM illegal,POWER,illegaltype\n" +
            "WHERE illegal.`pow_id`=POWER.`id`AND illegal.`type`=illegaltype.`id` AND illegal.`del`=0")
    List<IllegalPersonDTO> findAllIll();


    @Select("<script> SELECT illegal.`id`,illegal.`per_id`,POWER.`po_name`,illegaltype.`illegal_name`\n" +
            "FROM illegal,POWER,illegaltype\n" +
            "<where> " +
            "<if test=\"per_id!=null and per_id!=''\">" +
            "AND per_id like concat('%', #{per_id}, '%')"+
            "</if>"+
            "<if test=\"po_name!=null and po_name!=''\">" +
            "AND po_name like concat('%', #{po_name}, '%')"+
            "</if>"+
            "<if test=\"illegal_name!=null and illegal_name!=''\">" +
            "AND illegal_name like concat('%', #{illegal_name}, '%')"+
            "</if>"+
            "AND illegal.`pow_id`=POWER.`id`AND illegal.`type`=illegaltype.`id` AND illegal.`del`=0"+
            "</where>" +
            "</script>")
    List<IllegalPersonDTO> findIllegalByType(IllegalPersonDTO illegalPersonDTO);


    @Insert("REPLACE INTO `javawork`.`illegal`(`per_id`,`pow_id`,`type`)\n" +
            "SELECT stu_id per_id,pow_id,1 FROM student\n" +
            "WHERE NOW()>graduat_year AND student.`del`=0")
    int insert();

    @Select("TRUNCATE TABLE `illegal`")
    void clean();

    @Select("SELECT * FROM illegal WHERE id=#{id} AND del=0")
    Illegal findByID(Integer id);

    @Update("UPDATE `javawork`.`illegal` SET  `del` = 1  WHERE `id` = #{id}")
    int delete(Integer id);
}
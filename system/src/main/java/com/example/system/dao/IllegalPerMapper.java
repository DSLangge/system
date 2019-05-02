package com.example.system.dao;

import com.example.system.dto.IllegalPersonDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface IllegalPerMapper {

    @Select("SELECT illegal.`id`,illegal.`per_id`,POWER.`po_name`,illegaltype.`illegal_name`\n" +
            "FROM illegal,POWER,illegaltype\n" +
            "WHERE illegal.`pow_id`=POWER.`id`AND illegal.`type`=illegaltype.`id` AND illegal.`del`=0")
    List<IllegalPersonDTO> findAllIll();

    @Insert("REPLACE INTO `javawork`.`illegal`(`per_id`,`pow_id`,`type`) " +
            "SELECT stu_id per_id,pow_id,1 FROM student " +
            "WHERE NOW()> graduat_year")
    int insert();
}

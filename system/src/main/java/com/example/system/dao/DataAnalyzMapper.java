package com.example.system.dao;

import com.example.system.dto.DataAnalyzDTO;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface DataAnalyzMapper {

    @Select("SELECT DAYNAME(lea_creat) day_week,COUNT(DAYOFWEEK(lea_creat)) num FROM`lea_message` GROUP BY DAYOFWEEK(lea_creat)")
    List<DataAnalyzDTO> findLea();
    @Select("SELECT DAYNAME(inf_creatime) day_week,COUNT(DAYOFWEEK(inf_creatime)) num FROM`inform` GROUP BY DAYOFWEEK(inf_creatime)")
    List<DataAnalyzDTO> findInf();
    @Select("SELECT DAYNAME(creat_time) day_week,COUNT(DAYOFWEEK(creat_time)) num FROM`advice_note` GROUP BY DAYOFWEEK(creat_time)")
    List<DataAnalyzDTO> findAdv();

}

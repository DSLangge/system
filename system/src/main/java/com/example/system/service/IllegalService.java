package com.example.system.service;

import com.example.system.dto.IllegalPersonDTO;
import com.example.system.entity.Illegal;
import com.github.pagehelper.PageInfo;

public interface IllegalService {
    /**
     * 自动插入，不能手动插入
     * @return
     */
    int insert();
    int delete(Integer id);
    Illegal findByID(Integer id);
    PageInfo<IllegalPersonDTO> findAllIllegal(Integer page, Integer limit);
    PageInfo<IllegalPersonDTO> findIllegalByType(IllegalPersonDTO illegalPersonDTO,Integer page, Integer limit);
}

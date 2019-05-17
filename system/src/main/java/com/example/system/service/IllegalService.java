package com.example.system.service;

import com.example.system.dto.IllegalPersonDTO;
import com.example.system.entity.Illegal;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface IllegalService {
    /**
     * 自动插入，不能手动插入
     * @return
     */
    int insertTimeOut();

    /**
     * 插入违规用户
     * @return
     */
    int insertIllegal();

    /**
     * 非法操作用户插入
     * @param per_id
     * @param pow_id
     * @return
     */
    int insertIllegaOper(String per_id,Integer pow_id);

    List<Illegal> findAll();

    void clean();
    int delete(Integer id);
    Illegal findByID(Integer id);
    PageInfo<IllegalPersonDTO> findAllIll(Integer page, Integer limit);
    PageInfo<IllegalPersonDTO> findIllegalByType(IllegalPersonDTO illegalPersonDTO,Integer page, Integer limit);
}

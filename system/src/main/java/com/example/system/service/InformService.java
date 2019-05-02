package com.example.system.service;

import com.example.system.entity.Inform;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface InformService {
    int insert(Inform inform);
    int delete(Integer id);
    int update(Inform inform);
    PageInfo<Inform> findAllInfo(Integer page, Integer limit);
    Inform findByID(Integer id);
    PageInfo<Inform> findInfoByType(Inform inform,Integer page, Integer limit);
}

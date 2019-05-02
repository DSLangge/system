package com.example.system.service;

import com.example.system.entity.AdviceNote;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface AdviceService {
    int insert(AdviceNote adviceNote);
    int update(AdviceNote adviceNote);
    int delete(Integer id);
    PageInfo<AdviceNote> findAllAdv(Integer page, Integer limit);
    AdviceNote findByID(Integer id);
    PageInfo<AdviceNote> findAdvByType(AdviceNote adviceNote,Integer page, Integer limit);
}

package com.example.system.service;

import com.example.system.dto.LeaBackDTO;
import com.example.system.entity.FeedBack;
import com.github.pagehelper.PageInfo;

public interface LeaBackService {

    int insert(FeedBack feedBack);
    int update(FeedBack feedBack);
    int delete(Integer id);

    int deleteLeaMess(Integer id);
    FeedBack findByBackId(Integer back_id);
    PageInfo<LeaBackDTO> findAllLeaBack(Integer page, Integer limit);
}

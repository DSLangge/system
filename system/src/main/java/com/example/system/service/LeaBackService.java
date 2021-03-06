package com.example.system.service;

import com.example.system.dto.LeaBackDTO;
import com.example.system.entity.FeedBack;
import com.github.pagehelper.PageInfo;

public interface LeaBackService {

    int insert(FeedBack feedBack);
    int update(FeedBack feedBack);
    int delete(Integer id);

    int deleteLeaMess(Integer id);
    LeaBackDTO getBoolen(Integer back_id);
    FeedBack findByBackId(Integer back_id);
    PageInfo<LeaBackDTO> findAllLeaBack(Integer page, Integer limit);
    PageInfo<LeaBackDTO> findLeaAndBackByType(LeaBackDTO leaBackDTO,Integer page, Integer limit);
}

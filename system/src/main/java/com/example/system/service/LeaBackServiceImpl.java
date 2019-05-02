package com.example.system.service;

import com.example.system.dao.LeaBackMapper;
import com.example.system.dto.LeaBackDTO;
import com.example.system.entity.FeedBack;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("leaBackService")
public class LeaBackServiceImpl implements LeaBackService {


    @Resource
    LeaBackMapper leaBackMapper;

    @Override
    public int insert(FeedBack feedBack) {
        return leaBackMapper.insert(feedBack);
    }

    @Override
    public int update(FeedBack feedBack) {
        return leaBackMapper.update(feedBack);
    }

    @Override
    public int delete(Integer id) {
        return leaBackMapper.delete(id);
    }

    @Override
    public int deleteLeaMess(Integer id) {
        return leaBackMapper.deleteLeaMess(id);
    }

    @Override
    public FeedBack findByBackId(Integer back_id) {
        return leaBackMapper.findByBackId(back_id);
    }

    @Override
    public PageInfo<LeaBackDTO> findAllLeaBack(Integer page, Integer limit) {
        PageHelper.startPage(page,limit);
        PageInfo<LeaBackDTO> leaBackDTOPageInfo = new PageInfo<>(leaBackMapper.findAllLeaAndBack());
        return leaBackDTOPageInfo;
    }

    @Override
    public PageInfo<LeaBackDTO> findLeaAndBackByType(LeaBackDTO leaBackDTO, Integer page, Integer limit) {
        PageHelper.startPage(page,limit);
        PageInfo<LeaBackDTO> leaBackDTOPageInfo = new PageInfo<>(leaBackMapper.findLeaAndBackByType(leaBackDTO));
        return leaBackDTOPageInfo;
    }


}

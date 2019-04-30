package com.example.system.service;

import com.example.system.dao.AdviceMapper;
import com.example.system.entity.AdviceNote;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("adviceService")
public class AdviceServiceImpl implements AdviceService {


    @Resource
    AdviceMapper adviceMapper;


    @Override
    public int insert(AdviceNote adviceNote) {
        return adviceMapper.insert(adviceNote);
    }

    @Override
    public int update(AdviceNote adviceNote) {
        return adviceMapper.update(adviceNote);
    }

    @Override
    public int delete(Integer id) {
        return adviceMapper.delete(id);
    }

    @Override
    public PageInfo<AdviceNote> findAllAdv(Integer page, Integer limit) {
        PageHelper.startPage(page,limit);
        PageInfo<AdviceNote> adviceNotePageInfo = new PageInfo<>(adviceMapper.findAllAdv());

        return adviceNotePageInfo;
    }

    @Override
    public AdviceNote findByID(Integer id) {
        return adviceMapper.findByID(id);
    }
}

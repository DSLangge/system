package com.example.system.service;

import com.example.system.dao.InformMapper;
import com.example.system.entity.Inform;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service("informService")
public class InformServiceImpl implements InformService {
    @Resource
    InformMapper informMapper;

    @Override
    public int insert(Inform inform) {
        return informMapper.insert(inform);
    }

    @Override
    public int delete(Integer id) {
        return informMapper.delete(id);
    }

    @Override
    public int update(Inform inform) {
        return informMapper.update(inform);
    }

    @Override
    public PageInfo<Inform> findAllInfo(Integer page, Integer limit) {
        PageHelper.startPage(page,limit);
        PageInfo<Inform> informPageInfo = new PageInfo<>(informMapper.findAllInfo());
        return informPageInfo;
    }

    @Override
    public Inform findByID(Integer id) {
        return informMapper.findByID(id);
    }

    @Override
    public PageInfo<Inform> findInfoByType(Inform inform, Integer page, Integer limit) {
        PageHelper.startPage(page,limit);
        PageInfo<Inform> informPageInfo = new PageInfo<>(informMapper.findInfoByType(inform));
        return informPageInfo;
    }
}

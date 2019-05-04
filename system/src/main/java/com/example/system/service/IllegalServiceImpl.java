package com.example.system.service;

import com.example.system.dao.IllegalPerMapper;
import com.example.system.dto.IllegalPersonDTO;
import com.example.system.entity.Illegal;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("illegalService")
public class IllegalServiceImpl implements IllegalService {

    @Resource
    IllegalPerMapper illegalPerMapper;

    @Override
    public int insert() {
        return illegalPerMapper.insert();
    }

    @Override
    public void clean() {
        illegalPerMapper.clean();
    }

    @Override
    public int delete(Integer id) {
        return illegalPerMapper.delete(id);
    }

    @Override
    public Illegal findByID(Integer id) {
        return illegalPerMapper.findByID(id);
    }

    @Override
    public PageInfo<IllegalPersonDTO> findAllIllegal(Integer page, Integer limit) {
        PageHelper.startPage(page,limit);
        PageInfo<IllegalPersonDTO> illegalPersonDTOPageInfo = new PageInfo<>(illegalPerMapper.findAllIll());
        return illegalPersonDTOPageInfo;
    }

    @Override
    public PageInfo<IllegalPersonDTO> findIllegalByType(IllegalPersonDTO illegalPersonDTO, Integer page, Integer limit) {
        PageHelper.startPage(page,limit);
        PageInfo<IllegalPersonDTO> illegalPersonDTOPageInfo = new PageInfo<>(illegalPerMapper.findIllegalByType(illegalPersonDTO));
        return illegalPersonDTOPageInfo;
    }
}

package com.example.system.service;

import com.example.system.dao.IllegalPerMapper;
import com.example.system.dto.IllegalPersonDTO;
import com.example.system.entity.Illegal;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("illegalService")
public class IllegalServiceImpl implements IllegalService {

    @Resource
    IllegalPerMapper illegalPerMapper;

    @Override
    public int insertTimeOut() {
        return illegalPerMapper.insertTimeOut();
    }

    @Override
    public int insertIllegal() {
        return illegalPerMapper.insertIllegal();
    }

    @Override
    public int insertIllegaOper(String per_id, Integer pow_id) {
        return illegalPerMapper.insertIllegaOper(per_id,pow_id);
    }

    @Override
    public List<Illegal> findAll() {
        return illegalPerMapper.findAll();
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
    public PageInfo<IllegalPersonDTO> findAllIll(Integer page, Integer limit) {
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

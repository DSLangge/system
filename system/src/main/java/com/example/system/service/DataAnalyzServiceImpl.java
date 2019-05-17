package com.example.system.service;

import com.example.system.dao.DataAnalyzMapper;
import com.example.system.dto.DataAnalyzDTO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service("dataAnalyzService")
public class DataAnalyzServiceImpl implements DataAnalyzService {

    @Resource
    DataAnalyzMapper dataAnalyzMapper;

    @Override
    public List<DataAnalyzDTO> findLea() {
        return dataAnalyzMapper.findLea();
    }

    @Override
    public List<DataAnalyzDTO> findInf() {
        return dataAnalyzMapper.findInf();
    }

    @Override
    public List<DataAnalyzDTO> findAdv() {
        return dataAnalyzMapper.findAdv();
    }
}

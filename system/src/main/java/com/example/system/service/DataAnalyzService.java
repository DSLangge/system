package com.example.system.service;

import com.example.system.dto.DataAnalyzDTO;

import java.util.List;

public interface DataAnalyzService {

    List<DataAnalyzDTO> findLea();
    List<DataAnalyzDTO> findInf();
    List<DataAnalyzDTO> findAdv();
}

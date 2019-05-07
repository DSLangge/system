package com.example.system.service;

import com.example.system.dao.EvaluMapper;
import com.example.system.dto.EvaluDetailDTO;
import com.example.system.dto.EvaluTotalDTO;
import com.example.system.entity.PersonEvalu;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("evaluService")
public class EvaluServiceImpl implements EvaluService {

    @Resource
    EvaluMapper evaluMapper;

    @Override
    public void clean() {
        evaluMapper.clean();
    }

    @Override
    public int insertEvaTotalTeach(String teach_id) {
        return evaluMapper.insertEvaTotalTeach(teach_id);
    }

    @Override
    public int deleteEvaTotalTeach(String teach_id) {
        return evaluMapper.deleteEvaTotalTeach(teach_id);
    }

    @Override
    public int insertPersonEva(PersonEvalu personEvalu) {
        return evaluMapper.insertPersonEva(personEvalu);
    }

    @Override
    public Double findScoreByPowID(PersonEvalu personEvalu) {
        return evaluMapper.findScoreByPowID(personEvalu);
    }

    @Override
    public int updateEvaluTotal(EvaluDetailDTO evaluDetailDTO) {
        return evaluMapper.updateEvaluTotal(evaluDetailDTO);
    }

    @Override
    public PersonEvalu findUserEvaluMsg(String teach_id) {
        return evaluMapper.findUserEvaluMsg(teach_id);
    }

    @Override
    public PersonEvalu findByTeachIdUsersonId(String teach_id, String user_id) {
        return evaluMapper.findByTeachIdUsersonId(teach_id,user_id);
    }

    @Override
    public List<EvaluDetailDTO> getDetail() {
        return evaluMapper.getDetail();
    }

    @Override
    public PageInfo<EvaluTotalDTO> findAllEvaTotal(Integer page, Integer limit) {
        PageHelper.startPage(page,limit);
        PageInfo<EvaluTotalDTO> evaluTotalDTOPageInfo = new PageInfo<>(evaluMapper.findAllEvaTotal());
        return evaluTotalDTOPageInfo;
    }

    @Override
    public PageInfo<EvaluTotalDTO> findAllEvaTotalByType(EvaluTotalDTO evaluTotalDTO, Integer page, Integer limit) {
        PageHelper.startPage(page,limit);
        PageInfo<EvaluTotalDTO> evaluTotalDTOPageInfo = new PageInfo<>(evaluMapper.findAllEvaTotalByType(evaluTotalDTO));
        return evaluTotalDTOPageInfo;
    }

    @Override
    public PageInfo<EvaluDetailDTO> getDetailList(Integer page, Integer limit) {
        PageHelper.startPage(page,limit);
        PageInfo<EvaluDetailDTO> evaluDetailDTOPageInfo = new PageInfo<>(evaluMapper.getDetailList());
        return evaluDetailDTOPageInfo;
    }
}

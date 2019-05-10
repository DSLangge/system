package com.example.system.service;

import com.example.system.dto.EvaluDetailDTO;
import com.example.system.dto.EvaluTotalDTO;
import com.example.system.entity.PersonEvalu;
import com.github.pagehelper.PageInfo;

import java.util.List;


public interface EvaluService {
    void clean();
    /**
     * 插入总分表
     * @param teach_id 教师ID
     * @return
     */
    int insertEvaTotalTeach(String teach_id);
    int deleteEvaTotalTeach(String teach_id);
    /**
     * 插入评分表
     * @param personEvalu 用户评价类
     * @return
     */
    int insertPersonEva(PersonEvalu personEvalu);
    /**
     * 根据教师ID，查询对应角色的评分
     * @param personEvalu 用户评价类
     * @return
     */
    Double findScoreByPowID(PersonEvalu personEvalu);


    /**
     * 更新总表中的评分信息
     * @param evaluDetailDTO
     * @return
     */
    int updateEvaluTotal(EvaluDetailDTO evaluDetailDTO);


    /**
     * 查询辅导员被系统管理员评价记录
     * @param teach_id
     * @return
     */
    PersonEvalu findUserEvaluMsg(String teach_id);

    /**
     * 查询系统管理员 和已知工号老师是否存在
     * @param teach_id
     * @param user_id
     * @return
     */
    PersonEvalu findByTeachIdUsersonId(String teach_id,String user_id);


    PersonEvalu findByTeachIdPowId(String teach_id,Integer pow_id);

    List<EvaluDetailDTO> getDetail();


    PageInfo<EvaluTotalDTO> findAllEvaTotal(Integer page, Integer limit);

    PageInfo<EvaluTotalDTO> findAllEvaTotalByType(EvaluTotalDTO evaluTotalDTO,Integer page, Integer limit);


    /**
     * 生成总表
     */
    PageInfo<EvaluDetailDTO> getDetailList(Integer page, Integer limit);

}

package com.example.system.service;

import com.example.system.dao.UserGroupMapper;
import com.example.system.dto.UserGroupMsgDTO;
import com.example.system.dto.UserGroupPersonDTO;
import com.example.system.dto.UserGroupPersonSqlDTO;
import com.example.system.dto.UserGroupPowerDTO;
import com.example.system.entity.Power;
import com.example.system.entity.UserGroup;
import com.example.system.entity.UserGroupPerson;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("userGroupService")
public class UserGroupServiceImpl implements UserGroupService {

    @Resource
    UserGroupMapper userGroupMapper;


    @Override
    public int insert(UserGroup userGroup) {
        return userGroupMapper.insert(userGroup);
    }

    @Override
    public int update(UserGroup userGroup) {
        return userGroupMapper.update(userGroup);
    }

    @Override
    public int delete(Integer id) {
        return userGroupMapper.delete(id);
    }

    @Override
    public UserGroup findById(Integer id) {
        return userGroupMapper.findById(id);
    }

    @Override
    public int insertGroupPower(UserGroupPowerDTO userGroupPowerDTO) {
        return userGroupMapper.insertGroupPower(userGroupPowerDTO);
    }

    @Override
    public int updateGroupPower(UserGroupPowerDTO userGroupPowerDTO) {
        return userGroupMapper.updateGroupPower(userGroupPowerDTO);
    }

    @Override
    public UserGroupPowerDTO findGroupPower(Integer user_group_id) {
        return userGroupMapper.findGroupPower(user_group_id);
    }

    @Override
    public List<Power> findAllPower() {
        return userGroupMapper.findAllPower();
    }

    @Override
    public int insertGroupPerson(UserGroupPerson userGroupPerson) {
        return userGroupMapper.insertGroupPerson(userGroupPerson);
    }

    @Override
    public int deleteGroupPerson(Integer id) {
        return userGroupMapper.deleteGroupPerson(id);
    }

    @Override
    public PageInfo<UserGroupPersonDTO> findAllGrpupPerson(Integer page, Integer limit,Integer user_group_id) {
        PageHelper.startPage(page,limit);
        PageInfo<UserGroupPersonDTO> userGroupPersonDTOPageInfo = new PageInfo<>(userGroupMapper.findAllGrpupPerson(user_group_id));
        return userGroupPersonDTOPageInfo;
    }

    @Override
    public PageInfo<UserGroupPersonDTO> findAllGrpupPersonByType(UserGroupPersonSqlDTO userGroupPersonSqlDTO, Integer page, Integer limit) {
        PageHelper.startPage(page,limit);
        PageInfo<UserGroupPersonDTO> userGroupPersonDTOPageInfo = new PageInfo<>(userGroupMapper.findAllGrpupPersonByType(userGroupPersonSqlDTO));
        return userGroupPersonDTOPageInfo;
    }


    @Override
    public PageInfo<UserGroupMsgDTO> findAllUserGroup(Integer page, Integer limit) {
        PageHelper.startPage(page,limit);
        PageInfo<UserGroupMsgDTO> userGroupMsgDTOPageInfo = new PageInfo<>(userGroupMapper.findAllUserGroup());
        return userGroupMsgDTOPageInfo;
    }

    @Override
    public PageInfo<UserGroupMsgDTO> findUserGroupByType(UserGroupMsgDTO userGroupMsgDTO, Integer page, Integer limit) {
        PageHelper.startPage(page,limit);
        PageInfo<UserGroupMsgDTO> userGroupMsgDTOPageInfo = new PageInfo<>(userGroupMapper.findUserGroupByType(userGroupMsgDTO));
        return userGroupMsgDTOPageInfo;
    }


}

package com.example.system.service;

import com.example.system.dao.UserGroupMapper;
import com.example.system.dto.UserGroupMsgDTO;
import com.example.system.entity.UserGroup;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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

package com.example.system.service;

import com.example.system.dto.UserGroupMsgDTO;
import com.example.system.entity.UserGroup;
import com.github.pagehelper.PageInfo;

public interface UserGroupService {

    int insert(UserGroup userGroup);
    int update(UserGroup userGroup);
    int delete(Integer id);
    UserGroup findById(Integer id);

    PageInfo<UserGroupMsgDTO> findAllUserGroup(Integer page, Integer limit);
    PageInfo<UserGroupMsgDTO> findUserGroupByType(UserGroupMsgDTO userGroupMsgDTO,Integer page, Integer limit);
}

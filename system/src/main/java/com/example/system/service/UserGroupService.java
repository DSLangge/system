package com.example.system.service;

import com.example.system.dto.UserGroupMsgDTO;
import com.example.system.dto.UserGroupPersonDTO;
import com.example.system.dto.UserGroupPersonSqlDTO;
import com.example.system.dto.UserGroupPowerDTO;
import com.example.system.entity.Power;
import com.example.system.entity.UserGroup;
import com.example.system.entity.UserGroupPerson;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface UserGroupService {

    int insert(UserGroup userGroup);
    int update(UserGroup userGroup);
    int delete(Integer id);
    UserGroup findById(Integer id);
    PageInfo<UserGroupMsgDTO> findAllUserGroup(Integer page, Integer limit);
    PageInfo<UserGroupMsgDTO> findUserGroupByType(UserGroupMsgDTO userGroupMsgDTO,Integer page, Integer limit);



    int insertGroupPower(UserGroupPowerDTO userGroupPowerDTO);
    int updateGroupPower(UserGroupPowerDTO userGroupPowerDTO);
    UserGroupPowerDTO findGroupPower(Integer user_group_id);
    List<Power> findAllPower();


    int insertGroupPerson(UserGroupPerson userGroupPerson);
    int deleteGroupPerson( Integer id);
    PageInfo<UserGroupPersonDTO> findAllGrpupPerson(Integer page, Integer limit,Integer user_group_id);
    PageInfo<UserGroupPersonDTO> findAllGrpupPersonByType(UserGroupPersonSqlDTO userGroupPersonSqlDTO, Integer page, Integer limit);

}

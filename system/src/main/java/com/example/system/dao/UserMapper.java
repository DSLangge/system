package com.example.system.dao;

import com.example.system.entity.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserMapper {

    void insert(User user);
    void delete(Integer user_id);
    void upDate(User user);

    @Select("SELECT * FROM `javawork`.`user` WHERE del=0")
    List<User> findAllUser();



//  根据ID 查找用户
    @Select("SELECT * FROM `javawork`.`user` WHERE id=#{id} AND del=0")
    User findByID(Integer id);


//  根据工号查找用户
    User findByUserID(Integer user_id);
}

package com.example.system.dto;

import lombok.Data;

@Data
public class LoginDTO {
//    登录工号
    private String userid;
//    登陆密码
    private String password;
//    登录角色选择
    private Integer power;
//    登录验证码
    private String verify;
}

package com.example.system.entity;

import lombok.Data;

@Data
public class User {
    private Integer id;
    private String username;
    private String password;
    private Integer power_id;
    private Integer is_del;
}

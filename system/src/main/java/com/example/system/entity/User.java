package com.example.system.entity;

import lombok.Data;

@Data
public class User {
    private Integer id;
    private String user_id;
    private String user_name;
    private String password;
    private Integer del;
}

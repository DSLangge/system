package com.example.system.entity;

import lombok.Data;

@Data
public class Teacher {
    private Integer id;
    private String teach_id;
    private String teach_name;
    private String password;
    private Integer del;
}

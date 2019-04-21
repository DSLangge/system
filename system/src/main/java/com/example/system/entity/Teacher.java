package com.example.system.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Teacher {
    private Integer id;
    private String teach_id;
    private String teach_name;
    private String teach_sex;
    private String password;
    private Date entry_time;
    private Integer pow_ID;
    private Integer del;
}

package com.example.system.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Student {
    private Integer id;
    private Integer stu_id;
    private String stu_name;
    private String password;
    private Date school_year;
    private Date graduat_year;
    private Integer del;
}

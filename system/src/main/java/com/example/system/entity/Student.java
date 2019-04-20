package com.example.system.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Student {
    private Integer id;
    private String stu_id;
    private String stu_name;
    private String stu_sex;
    private String password;
    private Integer stu_age;
    private String stu_class;
    private Integer stu_edu;
    private String stu_nation;
    private Date stu_birth;
    private String stu_proID;
    private String stu_phone;
    private String postcode;
    private String stu_style;
    private String stu_email;
    private String stu_high;
    private String stu_antive;
    private Date school_year;
    private Date graduat_year;
    private Integer pow_ID;
    private Integer del;
}

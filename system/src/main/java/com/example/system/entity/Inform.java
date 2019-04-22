package com.example.system.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Inform {
    private Integer id;
    private String inf_title;
    private String inf_msg;
//    发布人ID
    private String pre_id;
//    发布按钮
    private Date inf_creatime;
    private Date inf_updatime;
    private Date inf_pubtime;
    private Integer inf_pub;
    private Integer del;
}

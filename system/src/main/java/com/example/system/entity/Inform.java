package com.example.system.entity;

import lombok.Data;

@Data
public class Inform {
    private Integer id;
    private String inf_title;
    private String inf_msg;
    private String pre_id;
//    发布按钮
    private Integer inf_pub;
    private Integer del;
}

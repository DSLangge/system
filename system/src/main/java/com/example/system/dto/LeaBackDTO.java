package com.example.system.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class LeaBackDTO {
//    留言ID
    private Integer id;
//    留言人工号
    private String lea_per_id;
//    留言内容
    private String lea_msg;
//    留言创建时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lea_creat;
//    反馈人工号
    private String back_per_id;
//    反馈内容
    private String back_msg;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    private Date back_time;
}

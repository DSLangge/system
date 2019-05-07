package com.example.system.dto;

import lombok.Data;

@Data
public class EvaluTotalDTO {
    private Integer id;
    private String teach_id;
    private String teach_name;
    private Integer user_count;
    private Integer teach_count;
    private Integer stu_count;
    private Integer del;

}

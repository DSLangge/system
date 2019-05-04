package com.example.system.entity;

import lombok.Data;

@Data
public class EvaluTotal {
    private Integer id;
    private String teach_id;
    private Double user_score;
    private Double teach_score;
    private Double stu_score;
    private Integer del;

}

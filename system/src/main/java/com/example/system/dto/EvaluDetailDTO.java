package com.example.system.dto;

import lombok.Data;

@Data
public class EvaluDetailDTO {
    private String teach_id;
    private String teach_name;
    private Double user_score;
    private Double teach_score;
    private Double stu_score;
    private Double score;
    private String evalu_msg;
}

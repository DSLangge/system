package com.example.system.entity;

import lombok.Data;

@Data
public class PersonEvalu {
    private Integer id;
    private Double score;
    private String teach_id;
    private String user_id;
    private Integer pow_id;
    private String evalu_msg;

    public PersonEvalu() {
    }

    public PersonEvalu(String teach_id, Integer pow_id) {
        this.teach_id = teach_id;
        this.pow_id = pow_id;
    }
}

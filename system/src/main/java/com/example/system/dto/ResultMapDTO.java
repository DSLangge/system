package com.example.system.dto;


import lombok.Data;

@Data
public class ResultMapDTO {

    private Integer code;
    private String msg;
    private Integer count;
    private Object data;

    public ResultMapDTO() {
    }

    public ResultMapDTO(Integer code, String msg, Integer count, Object data) {
        this.code = code;
        this.msg = msg;
        this.count = count;
        this.data = data;
    }
}

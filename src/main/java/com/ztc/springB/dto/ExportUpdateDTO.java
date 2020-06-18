package com.ztc.springB.dto;

import lombok.Data;

@Data
public class ExportUpdateDTO {
    private String type;
    private Long num;

    public ExportUpdateDTO(String type, Long num) {
        this.type = type;
        this.num = num;
    }
}

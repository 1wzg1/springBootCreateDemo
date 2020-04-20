package com.ztc.springB.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExcelToObjectDTO {
    private Boolean flag;
    private AwardInfoExportDTO info;
}

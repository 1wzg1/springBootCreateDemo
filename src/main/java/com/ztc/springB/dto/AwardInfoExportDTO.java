package com.ztc.springB.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AwardInfoExportDTO {
    private static final long serialVersionUID = 3620956683721149182L;

    @ApiModelProperty(value = "奖品名称")
    private String awardName;
    @ApiModelProperty(value = "奖品类型")
    private String activityType;
    @ApiModelProperty(value = "奖品面值")
    private String faceValue;
    @ApiModelProperty(value = "卡号")
    private String awardNo;
    @ApiModelProperty(value = "奖品类型")
    private String awardType;
    @ApiModelProperty(value = "卡密")
    private String awardWord;
    @ApiModelProperty(value = "卡有效开始时间", example = "2020-04-30 12:00:00")
    private String cardStartTime;
    @ApiModelProperty(value = "卡有效结束时间", example = "2020-04-30 12:00:00")
    private String cardEndTime;
    @ApiModelProperty(value = "一级分类")
    private String oneCategory;
    @ApiModelProperty(value = "二级分类")
    private String twoCategory;
    @ApiModelProperty(value = "三级分类")
    private String threeCategory;
}

package com.zeroone.star.project.j5.query.schedulecalendar;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @description:
 * @program: mes-java
 * @ClassName ScheduleQueryUser
 * @author: nangua
 * @create: 2024-05-22 21:50
 * @Version 1.0
 **/

@Data
@ApiModel("获取指定人员排班计划")
public class ScheduleQueryUser {
    @NotBlank(message = "人员id不能为空")
    @ApiModelProperty(value = "人员id", example = "341")
    private String userId;

    @ApiModelProperty(value = "日期", example = "2024-05-22")
    private String date;

}
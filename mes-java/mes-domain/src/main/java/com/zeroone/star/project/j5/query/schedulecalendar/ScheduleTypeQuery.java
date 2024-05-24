package com.zeroone.star.project.j5.query.schedulecalendar;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

/**
 * @description: 根据班组类型获取指定班组排班计划
 * @program: mes-java
 * @ClassName ScheduleQueryType
 * @author: nangua
 * @create: 2024-05-22 21:49
 * @Version 1.0
 **/
@Data
@ApiModel("获取指定班组排班计划")
public class ScheduleTypeQuery {
    @NotBlank(message = "班组类型不能为空")
    @ApiModelProperty(value = "班组类型", example = "201")
    private String teamId;

    @ApiModelProperty(value = "日期", example = "2024-05-22")
    private LocalDate date;

}
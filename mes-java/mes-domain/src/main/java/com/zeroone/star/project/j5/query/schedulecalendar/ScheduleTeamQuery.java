package com.zeroone.star.project.j5.query.schedulecalendar;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

/**
 * @description: 根据分类类型获取指定班组排班计划
 * @program: mes-java
 * @ClassName ScheduleQueryTeam
 * @author: nangua
 * @create: 2024-05-22 21:49
 * @Version 1.0
 **/

@Data
@ApiModel("获取指定班组类型排班计划")
public class ScheduleTeamQuery {
    @NotBlank(message = "查询类型不能为空")
    @ApiModelProperty(value = "分类类型", example = "CNC")
    private String calendarType;

    @ApiModelProperty(value = "日期", example = "2024-05-22")
    private LocalDate date;

}
package com.zeroone.star.project.j5.query.scheduleplan;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

//by-qwert
@Data
@ApiModel("排班计划查询")
public class SchPlanQuery {
    /**
     * 班组类型
     */
    @ApiModelProperty(value = "班组类型", example = "机加工")
    private String calendarType;

    /**
     * 计划编号
     */
    @ApiModelProperty(value = "计划编号", example = "PLAN2024008")
    private String planCode;

    /**
     * 计划名称
     */
    @ApiModelProperty(value = "计划名称", example = "机加工11月两班倒")
    private String planName;

    /**
     * 开始时间
     */
    @ApiModelProperty(value = "开始时间", example = "2024-05-18")
    private LocalDateTime startDate;

    /**
     * 开始时间
     */
    @ApiModelProperty(value = "结束时间", example = "2024-05-18")
    private LocalDateTime endDate;

    /**
     * 分页大小
     */
    @ApiModelProperty(value = "分页大小", example = "10")
    private Integer pageSize;

    /**
     * 分页页号
     */
    @ApiModelProperty(value = "分页页号", example = "1")
    private Integer pageNum;

}

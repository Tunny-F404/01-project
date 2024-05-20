package com.zeroone.star.project.j5.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@ApiModel("新增排班计划")
public class SchPlanAddVO {
    /**
     * 计划类型
     */
    @ApiModelProperty(value = "计划类型", example = "CNC")
    private String calenderType;

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
     * 计划备注
     */
    @ApiModelProperty(value = "备注", example = "这是一段备注")
    private String remark;

    /**
     * 排班类型
     */
    @ApiModelProperty(value = "排班类型", example = "SHIFT_TWO")
    private String shiftType;

    /**
     * 排班方式
     */
    @ApiModelProperty(value = "排班方式", example = "WEEK")
    private String shiftMethod;

    /**
     * 排班次数
     */
    @ApiModelProperty(value = "排班次数", example = "1")
    private Integer shiftCount;

    /**
     * 开始时间
     */
    @ApiModelProperty(value = "开始时间", example = "2024-05-18")
    private LocalDateTime startDate;

    /**
     * 结束时间
     */
    @ApiModelProperty(value = "结束时间", example = "2024-05-18")
    private LocalDateTime endDate;

    /**
     * 状态
     */
    @ApiModelProperty(value = "状态", example = "PREPARE")
    private String status;
}

package com.zeroone.star.project.j5.dto.shiftplan;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@ApiModel("班次计划查询结果")
public class ShiftPlanDto {
    /**
     *  班次id
     */
    @ApiModelProperty(value = "班次id", example = "1")
    private Integer shiftId;

    /**
     *  班次序号
     */
    @ApiModelProperty(value = "班次序号", example = "2")
    private Integer orderNum;

    /**
     *  班次名称
     */
    @ApiModelProperty(value = "班次名称", example = "白班")
    private String shiftName;

    /**
     *  班次开始时间
     */
    @ApiModelProperty(value = "开始时间", example = "10:00")
    private LocalDateTime startTime;

    /**
     *  班次结束时间
     */
    @ApiModelProperty(value = "结束时间", example = "16:00")
    private LocalDateTime endTime;

    /**
     *  备注
     */
    @ApiModelProperty(value = "备注", example = "这是一条备注")
    private String remark;
}

package com.zeroone.star.project.j5.vo.shiftplan;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@ApiModel("添加班次计划")
public class ShiftPlanAddVo {
    /**
     * 班次序号
     */
    @ApiModelProperty(value="班次序号", example="2")
    private Long orderNum;

    /**
     * 班次名称
     */
    @ApiModelProperty(value="班次名称", example="白班")
    private String shiftName;

    /**
     * 开始时间
     */
    @ApiModelProperty(value="开始时间", example="8:00")
    private LocalDateTime startTime;

    /**
     * 结束时间
     */
    @ApiModelProperty(value="结束时间", example="16:00")
    private LocalDateTime endTime;
}

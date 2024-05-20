package com.zeroone.star.project.j5.vo.shiftplan;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ShiftPlanUpdateVo {
    /**
     * 班次id
     */
    @ApiModelProperty(value="班次id", example="2")
    private Integer shiftId;
    /**
     * 班次序号
     */
    @ApiModelProperty(value="班次序号", example="2")
    private Integer orderNum;

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

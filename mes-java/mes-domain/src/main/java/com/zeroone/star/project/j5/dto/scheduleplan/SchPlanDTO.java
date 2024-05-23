package com.zeroone.star.project.j5.dto.scheduleplan;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDate;

@Data
@ApiModel("排班计划数据传输对象")
public class SchPlanDTO {
    @ApiModelProperty(value = "计划id")
    private int planId;
    @ApiModelProperty(value = "计划编号")
    private int planCode;
    @ApiModelProperty(value = "计划名称")
    private String planName;
    @ApiModelProperty(value = "班组类型")
    private String calendarType;
    @ApiModelProperty(value = "开始日期")
    private LocalDate startDate;
    @ApiModelProperty(value = "结束日期")
    private LocalDate endDate;
    @ApiModelProperty(value = "轮班方式")
    private String shiftType;
    @ApiModelProperty(value = "倒班方式")
    private String shiftMethod;
    @ApiModelProperty(value = "数")
    private int shiftCount;
    @ApiModelProperty(value = "计划状态")
    private String status;
    @ApiModelProperty(value = "注释")
    private String remark;

}

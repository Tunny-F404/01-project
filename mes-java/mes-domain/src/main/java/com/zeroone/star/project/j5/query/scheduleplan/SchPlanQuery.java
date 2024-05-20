package com.zeroone.star.project.j5.query.scheduleplan;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.sql.Timestamp;

@Data
@ApiModel("排班计划数据查询对象")
public class SchPlanQuery {
    @ApiModelProperty(value = "计划编号")
    private int planCode;
    @ApiModelProperty(value = "计划名称")
    private String planName;
    @ApiModelProperty(value = "班组类型")
    private String calendarType;
    @ApiModelProperty(value = "开始日期")
    private Timestamp startDate;
    @ApiModelProperty(value = "结束日期")
    private Timestamp endDate;
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

package com.zeroone.star.project.j5.dto.scheduleplan;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

//by-qwert
@Data
@ApiModel("排版计划查询结果")
public class SchPlanDto {
    //cal_plan表属性加params，searchValue

    @ApiModelProperty(value = "", example = "")
    private Integer param;

    @ApiModelProperty(value = "", example = "")
    private Integer searchValue;

    //以下内容全部是CalPlan对象属性

    @ApiModelProperty(value = "计划ID", example = "1")
    private Integer planId;

    @ApiModelProperty(value = "计划编号", example = "PLAN2024008")
    private String planCode;

    @ApiModelProperty(value = "计划名称", example = "机加工11月两班倒")
    private String planName;

    @ApiModelProperty(value = "计划类型", example = "CNC")
    private String calenderType;

    @ApiModelProperty(value = "开始时间", example = "2024-05-18")
    private LocalDateTime startDate;

    @ApiModelProperty(value = "结束时间", example = "2024-05-18")
    private LocalDateTime endDate;

    @ApiModelProperty(value = "", example = "")
    private String shiftType;

    @ApiModelProperty(value = "", example = "")
    private String shiftMethod;

    @ApiModelProperty(value = "", example = "")
    private Integer shiftCount;

    @ApiModelProperty(value = "", example = "")
    private String status;

    @ApiModelProperty(value = "", example = "")
    private String remark;

    @ApiModelProperty(value = "", example = "")
    private String attr1;

    @ApiModelProperty(value = "", example = "")
    private String attr2;

    @ApiModelProperty(value = "", example = "")
    private Integer attr3;

    @ApiModelProperty(value = "", example = "")
    private Integer attr4;

    @ApiModelProperty(value = "", example = "")
    private String createBy;

    @ApiModelProperty(value = "", example = "")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "", example = "")
    private String updateBy;

    @ApiModelProperty(value = "", example = "")
    private LocalDateTime updateTime;

    //attr1: null
    //attr2:null
    //attr3:0
    //attr4: 0
    //calendarType: "CNC"
    //createBy: ""
    //createTime: "2024-05-17 19:10:28"
    //endDate: "2024-05-18"

    //params: {}

    //planCode: "PLAN2024008"
    //planId: 35
    //planName: "123"
    //remark: "无"

    //searchValue: null

    //shiftCount: 1
    //shiftMethod: "WEEK"
    //shiftType: "SHIFT_THREE"
    //startDate: "2024-05-18"
    //status: "PREPARE"
    //updateBy: ""
    //updateTime: null
}

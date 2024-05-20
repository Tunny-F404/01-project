package com.zeroone.star.project.j5.vo.schedualplan;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDate;

/**
 * <p>
 * 描述：排班计划列表显示数据
 * </p>
 * <p>版权：&copy;01星球</p>
 * <p>地址：01星球总部</p>
 * @author brickbreaker
 * @version 1.0.0
 */
@Data
@ApiModel("查询返回排班计划列表数据对象")
public class PlanVO {

    @ApiModelProperty(value = "计划ID", example = "1")
    private Long planId;

    @ApiModelProperty(value = "计划编号", example = "PL12345")
    private String planCode;     // 计划编号

    @ApiModelProperty(value = "计划名称", example = "年度计划")
    private String planName;       // 计划名称

    @ApiModelProperty(value = "班组类型", example = "机加工")
    private String teamType;       // 班组类型（如机加工、仓库、组装）

    @ApiModelProperty(value = "开始日期", example = "2023-01-01")
    private LocalDate startDate;   // 开始日期

    @ApiModelProperty(value = "结束日期", example = "2023-12-31")
    private LocalDate endDate;     // 结束日期

    @ApiModelProperty(value = "轮班方式", example = "白班")
    private String shiftType;      // 轮班方式（如白班、两班倒）

    @ApiModelProperty(value = "倒班方式", example = "按月")
    private String shiftMethod;   // 倒班方式（如按月、按天）

    @ApiModelProperty(value = "数", example = "1")
    private Integer shiftCount;

    @ApiModelProperty(value = "单据状态", example = "已确认")
    private String status;         // 单据状态（已确认、草稿）

    @ApiModelProperty(value = "创建者", example = "已确认")
    private String createBy;

    @ApiModelProperty(value = "创建时间", example = "已确认")
    private LocalDate createTime;

    @ApiModelProperty(value = "更新者", example = "已确认")
    private String updateBy;

    @ApiModelProperty(value = "更新时间", example = "已确认")
    private LocalDate updateTime;

    @ApiModelProperty(value = "预留字段1", example = "null")
    private String attr1;

    @ApiModelProperty(value = "预留字段2", example = "null")
    private String attr2;

    @ApiModelProperty(value = "预留字段3", example = "0")
    private Integer attr3;

    @ApiModelProperty(value = "预留字段4", example = "0")
    private Integer attr4;

    @ApiModelProperty(value = "备注", example = "备注")
    private String remark;

    @ApiModelProperty(value = "班组类型", example = "CNC")
    private String calendarType;
//    "searchValue": null,
//    "params": {},


}

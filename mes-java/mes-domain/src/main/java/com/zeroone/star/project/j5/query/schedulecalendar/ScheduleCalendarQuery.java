package com.zeroone.star.project.j5.query.schedulecalendar;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @projectName: mes-java
 * @package: com.zeroone.star.project.j5.query.schedulecalendar
 * @className: ScheduleCalendarQuery
 * @author: junhan Zhao
 * @description: 排班日历的查询对象
 * @date: 2024/5/20 0:55
 * @version: 1.0
 */
@Data
@ApiModel("排班日历（获取指定班组类型排班计划，获取指定班组排班计划，获取指定人员排班计划） 查询对象")
public class ScheduleCalendarQuery {
    @NotBlank(message = "查询类型不能为空")
    @ApiModelProperty(value = "查询类型", example = "TYPE:(分类)班组类型,TEAM:班组,USER:人员")
    private String queryType;
    @ApiModelProperty(value = "分类类型", example = "CNC:机加工,ZZ:组装,CK:仓库")
    private String calendarType;
    @ApiModelProperty(value = "班组类型", example = "201:电芯2组,207:高管")
    private String teamId;
    @ApiModelProperty(value = "人员类型", example = "341:小李,402:小何")
    private String userId;
}

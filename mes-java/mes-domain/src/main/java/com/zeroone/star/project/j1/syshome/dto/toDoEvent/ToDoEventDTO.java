package com.zeroone.star.project.j1.syshome.dto.toDoEvent;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 描述：我的待办数据模型
 * @author 李兴昊
 * @version 1.0.0
 */
@Data
@ApiModel("我的待办数据模型")
public class ToDoEventDTO {
    @ApiModelProperty(value = "待办事件",example = "维修工单")
    private String event;
    @ApiModelProperty(value = "待办事件详情",example = "机器1变压器损坏待维修")
    private Integer eventDetails;
    @ApiModelProperty(value = "待办事件单号",example = "123")
    private String eventId;
    @ApiModelProperty(value = "待办事件开始日期时间",example = "2021.09.03 11:44:15")
    private LocalDateTime eventDatatime;
}

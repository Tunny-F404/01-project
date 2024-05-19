package com.zeroone.star.project.j3.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel(value = "消息分页查询对象")
public class NewsPageQuery extends PageQuery implements Serializable  {

    @ApiModelProperty(value = "消息类型",example = "WARNING")
    private String MessageType;

    @ApiModelProperty(value = "消息级别",example = "A")
    private String MessageLevel;

    @ApiModelProperty(value = "发送人昵称",example = "若依")
    private String SenderNick;

    @ApiModelProperty(value = "接收人昵称",example = "若依")
    private String ReceiverNick;

    @ApiModelProperty(value = "状态",example = "UNREAD")
    private String status;


}



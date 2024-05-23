package com.zeroone.star.project.j3.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * 添加消息的DTO
 */
@Data
@ApiModel
public class SysAddMessageDTO {

    private static final long serialVersionUID = 1L;

    /** 消息类型 */
    @ApiModelProperty(value = "消息类型",example = "公告")
    private String messageType;

    /** 消息级别 */
    @ApiModelProperty(value = "消息级别",example = "普通")
    private String messageLevel;

    /** 接收人名称 */
    @ApiModelProperty(value = "接收人名称",example = "李四")
    private String recipientName;

    /** 标题 */
    @ApiModelProperty(value = "标题",example = "这是一个标题")
    private String messageTitle;

    /** 内容 */
    @ApiModelProperty(value = "内容",example = "这是一些内容")
    private String messageContent;

    /** 回调地址 */
    @ApiModelProperty(value = "回调地址",example = "随意写")
    private String callBack;


}

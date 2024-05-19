package com.zeroone.star.project.j3.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class MessageDTO {

    @ApiModelProperty(value = "消息ID")
    private Long messageId;

    @ApiModelProperty(value = "消息类型")
    private String messageType;

    @ApiModelProperty(value = "消息级别")
    private String messageLevel;

    @ApiModelProperty(value = "标题")
    private String messageTitle;

    @ApiModelProperty(value = "内容")
    private String messageContent;

    @ApiModelProperty(value = "发送人ID")
    private Long senderId;

    @ApiModelProperty(value = "发送人名称")
    private String senderName;

    @ApiModelProperty(value = "发送人昵称")
    private String senderNick;

    @ApiModelProperty(value = "接收人ID")
    private Long recipientId;

    @ApiModelProperty(value = "接收人名称")
    private String recipientName;

    @ApiModelProperty(value = "接收人昵称")
    private String recipientNick;

    @ApiModelProperty(value = "处理时间")
    private Date processTime;

    @ApiModelProperty(value = "回调地址")
    private String callBack;

    @ApiModelProperty(value = "状态")
    private String status;

    @ApiModelProperty(value = "是否删除")
    private String deletedFlag;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "创建者")
    private String createBy;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "更新者")
    private String UpdateBy;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

}

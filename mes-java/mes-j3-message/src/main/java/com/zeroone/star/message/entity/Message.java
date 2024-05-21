package com.zeroone.star.message.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

/**
 * 为了将文件夹推送到远程仓库而创建的类，用于占位，无其他用途
 */
@Data
@ApiModel
public class Message {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "附件id")
    /** 附件ID */
    private Long messageId;

    /** 消息类型 */
    @ApiModelProperty(value = "消息类型",example = "公告、提示、告警、聊天信息")
    private String messageType;

    /** 消息级别 */
    @ApiModelProperty(value = "消息级别",example = "普通、警告、紧急")
    private String messageLevel;

    /** 标题 */
    @ApiModelProperty(value = "标题",example = "这是一个标题")
    private String messageTitle;

    /** 内容 */
    @ApiModelProperty(value = "内容",example = "这是一些内容")
    private String messageContent;

    /** 发送人ID */
    @ApiModelProperty(value = "发送人ID",example = "12345678")
    private Long senderId;

    /** 发送人名称 */
    @ApiModelProperty(value = "发送人名称",example = "张三")
    private String senderName;

    /** 发送人昵称 */
    @ApiModelProperty(value = "发送人昵称",example = "不法少年张三")
    private String senderNick;

    /** 接收人ID */
    @ApiModelProperty(value = "接收人ID",example = "87654321")
    private Long recipientId;

    /** 接收人名称 */
    @ApiModelProperty(value = "接收人名称",example = "李四")
    private String recipientName;

    /** 接收人昵称 */
    @ApiModelProperty(value = "接收人昵称",example = "妇女之友李四")
    private String recipientNick;

    /** 处理时间 */
    @ApiModelProperty(value = "处理时间",dataType = "yyyy-MM-dd",example = "2002-12-30")
    private LocalDate processTime;

    /** 回调地址 */
    @ApiModelProperty(value = "回调地址",example = "随意写")
    private String callBack;

    /** 状态 */
    @ApiModelProperty(value = "状态",example = "未读")
    private String status;

    /** 是否删除 */
    @ApiModelProperty(value = "是否删除",example = "N")
    private String deletedFlag;
    /* 备注 */
    @ApiModelProperty(value = "备注")
    private String remark;


    /** 预留字段1 */
    @ApiModelProperty(value = "预留字段1",example = "")
    private String attr1;

    /** 预留字段2 */
    @ApiModelProperty(value = "预留字段2",example = "")
    private String attr2;

    /** 预留字段3 */
    @ApiModelProperty(value = "预留字段3",example = "")
    private Long attr3;

    /** 预留字段4 */
    @ApiModelProperty(value = "预留字段4",example = "")
    private Long attr4;



}

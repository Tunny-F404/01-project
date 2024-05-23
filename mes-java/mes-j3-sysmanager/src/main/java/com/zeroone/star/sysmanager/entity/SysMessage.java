package com.zeroone.star.sysmanager.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDate;

/**
 * 为了将文件夹推送到远程仓库而创建的类，用于占位，无其他用途
 */
@Data
@ApiModel
public class SysMessage extends BaseEntity{

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "附件id")
    /** 附件ID */
    @ExcelProperty(value = "附件id",index = 0)
    private Long messageId;

    /** 消息类型 */
    @ApiModelProperty(value = "消息类型",example = "公告、提示、告警、聊天信息")
    @ExcelProperty(value = "消息类型",index = 1)
    private String messageType;

    /** 消息级别 */
    @ApiModelProperty(value = "消息级别",example = "普通、警告、紧急")
    @ExcelProperty(value = "消息级别",index = 2)
    private String messageLevel;

    /** 标题 */
    @ApiModelProperty(value = "标题",example = "这是一个标题")
    @ExcelProperty(value = "标题",index = 3)
    private String messageTitle;

    /** 内容 */
    @ApiModelProperty(value = "内容",example = "这是一些内容")
    @ExcelProperty(value = "内容",index = 4)
    private String messageContent;

    /** 发送人ID */
    @ApiModelProperty(value = "发送人ID",example = "12345678")
    @ExcelProperty(value = "发送人ID",index = 5)
    private Long senderId;

    /** 发送人名称 */
    @ApiModelProperty(value = "发送人名称",example = "张三")
    @ExcelProperty(value = "发送人名称",index = 6)
    private String senderName;

    /** 发送人昵称 */
    @ApiModelProperty(value = "发送人昵称",example = "不法少年张三")
    @ExcelProperty(value = "发送人昵称",index = 7)
    private String senderNick;

    /** 接收人ID */
    @ApiModelProperty(value = "接收人ID",example = "87654321")
    @ExcelProperty(value = "接收人ID",index = 8)
    private Long recipientId;

    /** 接收人名称 */
    @ApiModelProperty(value = "接收人名称",example = "李四")
    @ExcelProperty(value = "接收人名称",index = 9)
    private String recipientName;

    /** 接收人昵称 */
    @ApiModelProperty(value = "接收人昵称",example = "妇女之友李四")
    @ExcelProperty(value = "接收人昵称",index = 10)
    private String recipientNick;

    /** 处理时间 */
    @ApiModelProperty(value = "处理时间",dataType = "yyyy-MM-dd",example = "2002-12-30")
    @ExcelProperty(value = "处理时间",index = 11)
    private LocalDate processTime;

    /** 回调地址 */
    @ApiModelProperty(value = "回调地址",example = "随意写")
    @ExcelProperty(value = "回调地址",index = 12)
    private String callBack;

    /** 状态 */
    @ApiModelProperty(value = "状态",example = "未读")
    @ExcelProperty(value = "状态",index = 13)
    private String status;

    /** 是否删除 */
    @ApiModelProperty(value = "是否删除",example = "N")
    @ExcelProperty(value = "是否删除",index = 14)
    private String deletedFlag;
    /* 备注 */
    @ApiModelProperty(value = "备注")
    @ExcelProperty(value = "备注",index = 15)
    private String remark;


    /** 预留字段1 */
    @ApiModelProperty(value = "预留字段1",example = "")
    @ExcelProperty(value = "预留字段1",index = 16)
    private String attr1;

    /** 预留字段2 */
    @ApiModelProperty(value = "预留字段2",example = "")
    @ExcelProperty(value = "预留字段2",index = 17)
    private String attr2;

    /** 预留字段3 */
    @ApiModelProperty(value = "预留字段3",example = "")
    @ExcelProperty(value = "预留字段3",index = 18)
    private Long attr3;

    /** 预留字段4 */
    @ApiModelProperty(value = "预留字段4",example = "")
    @ExcelProperty(value = "预留字段4",index = 19)
    private Long attr4;



}

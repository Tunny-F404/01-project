package com.zeroone.star.project.j3.dto;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 获取消息详情
 *
 * 页面展示消息对象
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "sys_message")
public class NewsDto implements Serializable {

    @TableId(value = "message_id")
    @ApiModelProperty(value = "附件ID")
    private Integer MessageId;

    @ApiModelProperty(value = "消息类型")
    private String MessageType;

    @ApiModelProperty(value = "消息级别")
    private String MessageLevel;

    @ApiModelProperty(value = "接收人")
    private String Receiver;

    @ApiModelProperty(value = "标题")
    private String MessageTitle;

    @ApiModelProperty(value = "内容")
    private String MessageContent;

    @ApiModelProperty(value = "回调地址")
    private String CallBack;

    @ApiModelProperty(value = "发送人ID")
    private Integer SenderTId;

    @ApiModelProperty(value = "发送人名称",example = "admin")
    private String SenderName;

    @ApiModelProperty(value = "发送人昵称",example = "若依")
    private String SenderNick;

    @ApiModelProperty(value = "接收人ID")
    private Integer ReceiverTId;

    @ApiModelProperty(value = "接收人名称",example = "admin")
    private String ReceiverName;

    @ApiModelProperty(value = "接收人昵称",example = "若依")
    private String ReceiverNick;

    @ApiModelProperty(value = "处理时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime ProcessTime;

    @ApiModelProperty(value = "状态")
    private String status;

    @ApiModelProperty(value = "是否删除")
    private String DeletedFlag;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "创建者",example = "admin")
    private String CreateBy;

    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime CreateTime;

    @ApiModelProperty(value = "更新者",example = "admin")
    private String UpdateBy;

    @ApiModelProperty(value = "更新时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime UpdateTime;

}

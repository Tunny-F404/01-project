package com.zeroone.star.project.j3.dto;

import com.alibaba.excel.annotation.ExcelProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * 更改消息的DTO 经过id校验 然后更改数据
 *
 */
@Data
@ApiModel
public class SysUpdateMessageDTO {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "附件id")
    /** 附件ID */
    private Long messageId;

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

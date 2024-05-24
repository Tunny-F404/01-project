package com.zeroone.star.project.j3.dto;

import com.alibaba.excel.annotation.ExcelProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * ClassName:ExportConditionMessageDTO
 * Package:com.zeroone.star.project.j3.dto
 * Description:
 *
 * @Author Chi池
 * @Create 2024/5/23  17:52
 * @Version 1.0
 */

@Data
public class ExportConditionMessageDTO {

    /** 消息类型 */
    @ApiModelProperty(value = "消息类型",example = "公告")
    private String messageType;

    /** 消息级别 */
    @ApiModelProperty(value = "消息级别",example = "普通")
    private String messageLevel;

    /** 发送人昵称 */
    @ApiModelProperty(value = "发送人昵称",example = "不法少年张三")
    private String senderNick;

    /** 接收人昵称 */
    @ApiModelProperty(value = "接收人昵称",example = "妇女之友李四")
    private String recipientNick;

    /** 状态 */
    @ApiModelProperty(value = "状态",example = "未读")
    private String status;


}

package com.zeroone.star.project.j3.vo;

import io.swagger.annotations.ApiModel;
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
 * 页面回显数据
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("消息列表")
public class NewsPageVo implements Serializable {


    @ApiModelProperty(value = "消息类型")
    private String MessageType;

    @ApiModelProperty(value = "消息级别")
    private String MessageLevel;

    @ApiModelProperty(value = "发送人",example = "若依")
    private String SenderNick;

    @ApiModelProperty(value = "接收人",example = "若依")
    private String RecipientNick;

    @ApiModelProperty(value = "标题")
    private String MessageTitle;

    @ApiModelProperty(value = "内容")
    private String MessageContent;

    @ApiModelProperty(value = "处理时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime ProcessTime;

    @ApiModelProperty(value = "回调地址")
    private String CallBack;









}

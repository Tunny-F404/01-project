package com.zeroone.star.project.j3.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.NotBlank;
import java.util.Date;

/**
 * @author ZhunJunHua
 * #Description 1.0
 * #Date: 2023.11.25
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ApiModel("通知类型对象")
public class NoticeDto {
    @ApiModelProperty(value = "序号",example = "0")
    private int noticeId;
    @ApiModelProperty(value = "公告标题",example = "测试公告内容")
    @NotBlank(message = "新增公告时, 公告标题不能为空")
    private String noticeTitle;
    @ApiModelProperty(value = "公告类型",example = "公告")
    private char noticeType;
    @NotBlank(message = "新增公告时, 公告内容不能为空")
    @ApiModelProperty(value = "公告内容",example = "测试公告内容")
    private byte[] noticeContent;
    @ApiModelProperty(value = "状态（0正常 1关闭）",example = "0")
    @NotBlank(message = "新增公告时, 状态不能为空")
    private char status;
    @ApiModelProperty(value = "创建者",example = "admin")
    @NotBlank(message = "新增公告时, 创建者不能为空")
    private String createBy;
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
    @ApiModelProperty(value = "更新者")
    private String updateBy;
    @ApiModelProperty(value = "更新时间时间")
    private Date updateTime;
    @ApiModelProperty(value = "操作")
    private String remark;
}



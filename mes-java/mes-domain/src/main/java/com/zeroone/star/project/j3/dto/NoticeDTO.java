package com.zeroone.star.project.j3.dto;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "sys_notice")
public class NoticeDTO implements Serializable {

    @TableId(value = "notice_id")
    @ApiModelProperty(value = "公告ID")
    private Integer id;

    @ApiModelProperty(value = "公告标题")
    private String noticeTitle;

    @ApiModelProperty(value = "公告内容")
    private String noticeContent;

    @ApiModelProperty(value = "公告类型")
    private String noticeType;

    @ApiModelProperty(value = "公告状态")
    private String noticeStatus;

    @ApiModelProperty(value = "创建人")
    private String createBy;

    @ApiModelProperty(value = "创建时间")
    private String createTime;

    @ApiModelProperty(value = "修改人")
    private String updateBy;

    @ApiModelProperty(value = "修改时间")
    private String updateTime;

    @ApiModelProperty(value = "备注")
    private String remark;
}

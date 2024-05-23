package com.zeroone.star.project.j6.customer.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("下载模板数据模型")
public class DownloadTemplateDTO {
    @ApiModelProperty(value = "下载（0 失败，1 成功）", example = "1")
    private int status;
    @ApiModelProperty(value = "下载失败原因(如果成功返回null)", example = "null")
    private String reason;
}

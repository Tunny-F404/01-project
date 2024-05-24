package com.zeroone.star.project.j3.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("用户退出数据")
public class LogoutDTO {
    /**
     * 用户会话Token
     */
    @ApiModelProperty(value = "用户会话Token", example = "XXDSADSAAFASD", required = true)
    private String token;
}

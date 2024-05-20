package com.zeroone.star.project.j2.sysmanagent.query.param;


import com.zeroone.star.project.query.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;


@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel("参数查询对象")
public class ParameterQuery extends PageQuery {

    @NotBlank(message = "参数名称不能为空")
    @ApiModelProperty(value = "参数名称", example = "账号")
    private String name;
}

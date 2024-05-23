package com.zeroone.star.project.j2.sysmanagement.query.param;


import com.zeroone.star.project.query.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

/**
 * @author 40斤、kino
 * @version 1.0.0
 * @Description:
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel("参数查询对象")
public class ParameterQuery extends PageQuery {

    @NotBlank(message = "参数名称不能为空")
    @ApiModelProperty(value = "参数名称", example = "账号")
    private String name;

    @ApiModelProperty(value = "参数键名", example = "sys.index.skinName")
    private String configKey;

    @ApiModelProperty(value = "系统内置（Y是 N否）", example = "Y")
    private String configType;

    @ApiModelProperty(value = "创建时间", example = "2022-04-07 00:29:32")
    private LocalDateTime createTime;
}

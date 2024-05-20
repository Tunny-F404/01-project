package com.zeroone.star.project.j5.dto.planteam;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 描述：关联班组模型
 * </p>
 *
 * @author linglan
 * @version 1.0.0
 */
@Data
@ApiModel("添加关联班组模型")
public class AddPlanTeamDTO {
    @ApiModelProperty(value = "编号", example = "1")
    private Integer id;
    @ApiModelProperty(value = "姓名", example = "张三")
    private String name;
    @ApiModelProperty(value = "性别", example = "男")
    private String sex;
    @ApiModelProperty(value = "年龄", example = "18")
    private Integer age;
}
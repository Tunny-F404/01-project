package com.zeroone.star.project.j1.query.dept;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 描述：部门列表查询数据模型
 * </p>
 * <p>版权：&copy;01星球</p>
 * <p>地址：01星球总部</p>
 * @author 阿伟学长
 * @version 1.0.0
 */
@Data
@ApiModel("部门列表查询对象")
public class DeptQuery {
    @ApiModelProperty(value = "部门名称", example = "张三")
    private String deptName;
    @ApiModelProperty(value = "部门状态（0 正常 1 关闭）", example = "0")
    private Integer status;
}

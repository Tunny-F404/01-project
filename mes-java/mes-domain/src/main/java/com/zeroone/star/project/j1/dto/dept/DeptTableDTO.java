package com.zeroone.star.project.j1.dto.dept;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 描述：部门列表数据模型
 * </p>
 * <p>版权：&copy;01星球</p>
 * <p>地址：01星球总部</p>
 * @author 阿伟学长
 * @version 1.0.0
 */
@Data
@ApiModel("部门列表数据模型")
public class DeptTableDTO {
    @ApiModelProperty(value = "部门ID", example = "1")
    private Long deptId;
    @ApiModelProperty(value = "部门名称", example = "张三")
    private String deptName;
    @ApiModelProperty(value = "部门状态（0 正常 1 关闭）", example = "0")
    private Integer status;
    @ApiModelProperty(value = "创建时间", example = "2024-05-17 09:00:00")
    private String createTime;
}

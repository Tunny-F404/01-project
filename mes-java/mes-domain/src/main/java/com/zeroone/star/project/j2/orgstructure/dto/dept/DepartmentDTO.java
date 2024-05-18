package com.zeroone.star.project.j2.orgstructure.dto.dept;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author 宵夜
 * @version 1.0.0
 * @Description:部门传输数据对象
 */
@Data
@ApiOperation("角色传输数据对象")
public class DepartmentDTO {

    //查询Id
    @ApiModelProperty(value = "查询Id",example = "1")
    private String id;

    //创建人
    @ApiModelProperty(value = "创建人",example = "宵夜")
    private String CreateBy;

    //创建时间
    @ApiModelProperty(value = "创建时间",example = "2024-05-17")
    private LocalDateTime CreateTime;

    //更新时间
    @ApiModelProperty(value = "更新时间",example = "2024-05-17")
    private LocalDateTime UpdateTime;

    //部门名称
    @ApiModelProperty(value = "部门名称",example = "1")
    private String Title;



}

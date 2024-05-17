package com.zeroone.star.project.j2.orgstructure.query;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author 宵夜
 * @version 1.0.0
 * @Description: TODO
 */
@Data
@ApiOperation(value = "部门查询对象")
public class DepartmentQuery {

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
    @ApiModelProperty(value = "更新时间",example = "2024-01-15")
    private LocalDateTime UpdateTime;

    //部门名称
    @ApiModelProperty(value = "部门名称",example = "1")
    private String Title;
}

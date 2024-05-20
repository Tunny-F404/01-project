package com.zeroone.star.project.j1.orgstructure.query;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Min;

/**
 * 分页查询父对象
 */
public class PageQuery {
    @Min(value=1,message = "页码最小值为1")
    @ApiModelProperty(value = "查询页码",example = "1")
    private long pageIndex;
    @Min(value=1,message = "条数最小值为1")
    @ApiModelProperty(value = "条数页码",example = "1")
    private long pageSize;
}

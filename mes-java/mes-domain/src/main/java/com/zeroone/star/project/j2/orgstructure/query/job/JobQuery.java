package com.zeroone.star.project.j2.orgstructure.query.job;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Data;

/**
 * @author feng
 * @version 1.0.0
 * @Description: 岗位查询参数
 */
@Data
public class JobQuery {

    @ApiModelProperty(value = "岗位名称", example = "CEO")
    private String postName;

    @ApiModelProperty(value = "岗位编码", example = "1")
    private String postCode;

    @ApiModelProperty(value = "状态", example = "1")
    private String status;

    @ApiModelProperty(value = "当前页", example = "1")
    private Integer page;

    @ApiModelProperty(value = "每页数量", example = "10")
    private Integer size;
}
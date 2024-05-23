package com.zeroone.star.project.j2.orgstructure.dto.dept;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author 宵夜 夕秋z
 * @version 1.0.0
 * @Description:
 */
@Data
@ApiOperation("部门传输数据对象")
public class DepartmentDTO {

    //部门Id
    @ApiModelProperty(value = "部门Id",example = "1")
    private String id;

    //父部门id
    @ApiModelProperty(value = "父部门id",example = "2",required = true)
    private String parentId;

    //部门名称
    @ApiModelProperty(value = "部门名称",example = "部门1",required = true)
    private String name;

    //部门状态 0正常 1停用
    @ApiModelProperty(value = "部门状态",example = "0")
    private int status;

    @ApiModelProperty(value = "排序",example = "1",required = true)
    private int orderNum;

    @ApiModelProperty(value = "部门电话",example = "123456")
    private String phone;

    @ApiModelProperty(value = "部门邮箱",example = "123@qq.com")
    private String email;

    //创建时间
    @ApiModelProperty(value = "创建时间",example = "2024-05-17")
    private LocalDateTime createTime;

    //更新时间
    @ApiModelProperty(value = "更新时间",example = "2024-05-17")
    private LocalDateTime updateTime;






}

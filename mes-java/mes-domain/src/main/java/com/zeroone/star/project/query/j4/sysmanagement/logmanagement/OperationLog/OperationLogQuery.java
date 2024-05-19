package com.zeroone.star.project.query.j4.sysmanagement.logmanagement.OperationLog;

import com.zeroone.star.project.query.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import lombok.EqualsAndHashCode;


import java.time.LocalDateTime;
import java.util.Date;

/**
 * <p>
 * 描述：操作日志查询对象
 * </p>
 * <p>版权：&copy;01星球</p>
 * <p>地址：01星球总部</p>
 * @author
 * @version 1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel("操作日志查询对象")
public class OperationLogQuery extends PageQuery {

    @ApiModelProperty(value = "模块标题", example = "用户管理")
    private String title;

    @ApiModelProperty(value = "业务类型（0其它 1新增 2修改 3删除）", example = "1")
    private Integer businessType;

    @ApiModelProperty(value = "操作人员", example = "张三")
    private String operName;


    @ApiModelProperty(value = "操作状态（0正常 1异常）", example = "0")
    private Integer status;

    @ApiModelProperty(value = "操作时间", example = "2023-05-19T14:35:04")
    private Date operTime;

    @ApiModelProperty(value = "开始时间", example = "2023-05-19T14:35:04")
    private Date starttime;

    @ApiModelProperty(value = "结束时间", example = "2023-05-19T14:35:04")
    private Date endtime;
}

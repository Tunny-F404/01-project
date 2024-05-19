package com.zeroone.star.project.dto.schedualplan;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

/**
 * <p>
 * 描述：分页+条件查询排班计划数据对象
 * </p>
 * <p>版权：&copy;01星球</p>
 * <p>地址：01星球总部</p>
 * @author brickbreaker
 * @version 1.0.0
 */
@Data
@ApiModel("查询排班计划数据对象")
public class PlanQueryDTO {

    @ApiModelProperty(value = "页码",example = "1")
    private Long page = 1L;

    @ApiModelProperty(value = "页码",example = "10")
    private Integer size = 10;

    @ApiModelProperty(value = "班组类型",example = "机加工")
    private String teamType;

    @ApiModelProperty(value = "计划编号")
    private String planNumber;

    @ApiModelProperty(value = "计划名称")
    private String planName;

    @ApiModelProperty(value = "开始日期")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    @ApiModelProperty(value = "结束日期")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private  LocalDate endDate;

}



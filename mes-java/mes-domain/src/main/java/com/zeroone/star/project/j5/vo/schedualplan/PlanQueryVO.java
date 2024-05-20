package com.zeroone.star.project.j5.vo.schedualplan;

import com.zeroone.star.project.vo.login.MenuTreeVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

/**
 * <p>
 * 描述：排班计划列表显示数据
 * </p>
 * <p>版权：&copy;01星球</p>
 * <p>地址：01星球总部</p>
 * @author brickbreaker
 * @version 1.0.0
 */
@Data
@ApiModel("查询返回排班计划列表数据对象")
public class PlanQueryVO {
    @ApiModelProperty(value = "计划编号", example = "PL12345")
    private String planNumber;     // 计划编号

    @ApiModelProperty(value = "计划名称", example = "年度计划")
    private String planName;       // 计划名称

    @ApiModelProperty(value = "班组类型", example = "机加工")
    private String teamType;       // 班组类型（如机加工、仓库、组装）

    @ApiModelProperty(value = "开始日期", example = "2023-01-01")
    private LocalDate startDate;   // 开始日期

    @ApiModelProperty(value = "结束日期", example = "2023-12-31")
    private LocalDate endDate;     // 结束日期

    @ApiModelProperty(value = "轮班方式", example = "白班")
    private String shiftType;      // 轮班方式（如白班、两班倒）

    @ApiModelProperty(value = "倒班方式", example = "按月")
    private String rotationType;   // 倒班方式（如按月、按天）

    @ApiModelProperty(value = "单据状态", example = "已确认")
    private String status;         // 单据状态（已确认、草稿）

}

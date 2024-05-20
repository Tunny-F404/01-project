package com.zeroone.star.project.j5.dto.shiftplan;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;
/**
 * <p>
 * 描述：班次计划更新Dto
 * </p>
 * <p>版权：&copy;01星球</p>
 * <p>地址：01星球总部</p>
 * @author qwert
 * @version 1.0.0
 */
@Data
public class ShiftPlanUpdateDto {
    /**
     * 班次id
     */
    @ApiModelProperty(value="班次id", example="2")
    private Long shiftId;
    /**
     * 班次序号
     */
    @ApiModelProperty(value="班次序号", example="2")
    private Long orderNum;

    /**
     * 班次名称
     */
    @ApiModelProperty(value="班次名称", example="白班")
    private String shiftName;

    /**
     * 开始时间
     */
    @ApiModelProperty(value="开始时间", example="8:00")
    private LocalDateTime startTime;

    /**
     * 结束时间
     */
    @ApiModelProperty(value="结束时间", example="16:00")
    private LocalDateTime endTime;
}

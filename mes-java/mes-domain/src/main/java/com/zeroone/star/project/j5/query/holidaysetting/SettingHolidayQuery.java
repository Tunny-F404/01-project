package com.zeroone.star.project.j5.query.holidaysetting;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @projectName: mes-java
 * @package: com.zeroone.star.project.j5.query.holidaysetting
 * @className: CalHolidayQuery
 * @author: junhan Zhao
 * @description: TODO
 * @date: 2024/5/19 23:39
 * @version: 1.0
 */
@Data
@ApiModel("设置节假日配置 查询对象")
public class SettingHolidayQuery {
    @NotBlank(message = "更新时间不能为空")
    @ApiModelProperty(value = "更新时间（时间戳/毫秒）", example = "1716218590183")
    private String updateTime;

    @NotBlank(message = "修改后的日期类型不能为空")
    @ApiModelProperty(value = "日期类型", example = "HOLIDAY:节假日,WORKDAY:工作日")
    private String HolidayType;
    @NotBlank(message = "被修改的日期不能为空")
    @ApiModelProperty(value = "被修改的日期", example = "2023-05-01")
    private String theDay;

}

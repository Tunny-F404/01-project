package com.zeroone.star.project.j1.syshome.dto.workstation;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 描述：车间列表数据模型
 * @author 李兴昊
 * @version 1.0.0
 */
@Data
@ApiModel("工作站列表数据模型")
public class WorkstationDTO {
    @ApiModelProperty(value = "工作站名称",example = "一汽")
    private String workstationName;
    @ApiModelProperty(value = "工作站总人数",example = "100")
    private Integer workstationHeadcount;
}

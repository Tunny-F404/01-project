package com.zeroone.star.project.dto.j4.basicdata;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

public class UnitDTO {

    @ApiModelProperty(value = "单位ID", example = "1")
    private Long measureId;

    @NotNull(message = "单位编码不能为空")
    @Size(min = 1, max = 64, message = "单位编码长度必须在1到64个字符之间")
    @ApiModelProperty(value = "单位编码", example = "METER")
    private String measureCode;

    @NotNull(message = "单位名称不能为空")
    @Size(min = 1, max = 255, message = "单位名称长度必须在1到255个字符之间")
    @ApiModelProperty(value = "单位名称", example = "米")
    private String measureName;

    @ApiModelProperty(value = "是否是主单位", example = "Y")
    private String primaryFlag;

    @ApiModelProperty(value = "主单位ID", example = "1")
    private Long primaryId;

    @ApiModelProperty(value = "与主单位换算比例", example = "1.0")
    private Double changeRate;

    @ApiModelProperty(value = "是否启用", example = "Y")
    private String enableFlag;

    @Size(max = 500, message = "备注长度不能超过500个字符")
    @ApiModelProperty(value = "备注", example = "这是主单位")
    private String remark;

    @Size(max = 64, message = "预留字段1长度不能超过64个字符")
    @ApiModelProperty(value = "预留字段1", example = "自定义值1")
    private String attr1;

    @Size(max = 255, message = "预留字段2长度不能超过255个字符")
    @ApiModelProperty(value = "预留字段2", example = "自定义值2")
    private String attr2;

    @ApiModelProperty(value = "预留字段3", example = "100")
    private Integer attr3;

    @ApiModelProperty(value = "预留字段4", example = "200")
    private Integer attr4;

    @Size(max = 64, message = "创建者长度不能超过64个字符")
    @ApiModelProperty(value = "创建者", example = "user123")
    private String createBy;

    @ApiModelProperty(value = "创建时间", example = "2024-05-20T08:30:00")
    private LocalDateTime createTime;

    @Size(max = 64, message = "更新者长度不能超过64个字符")
    @ApiModelProperty(value = "更新者", example = "user456")
    private String updateBy;

    @ApiModelProperty(value = "更新时间", example = "2024-05-21T08:30:00")
    private LocalDateTime updateTime;

}

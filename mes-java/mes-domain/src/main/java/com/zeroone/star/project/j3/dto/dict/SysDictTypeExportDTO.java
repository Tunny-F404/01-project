package com.zeroone.star.project.j3.dto.dict;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @Author：xiong
 * @Date：2024/5/23 19:52
 */
@Data
@ApiModel("字典类型导出传输类")
public class SysDictTypeExportDTO {
    @ApiModelProperty(value = "字典名称", example = "用户性别")
    private String dictName;

    @ApiModelProperty(value = "字典类型", example = "sys_user_sex")
    private String dictType;

    @ApiModelProperty(value = "状态(0正常 1停用)", example = "0")
    private String status;


    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "开始时间", example = "2022-04-07 00:29:32")
    private Date startTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "结束时间", example = "2022-04-07 10:29:32")
    private Date endTime;
}

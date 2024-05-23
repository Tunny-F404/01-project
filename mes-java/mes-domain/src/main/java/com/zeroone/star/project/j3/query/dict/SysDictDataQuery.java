package com.zeroone.star.project.j3.query.dict;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zeroone.star.project.query.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 字典数据查询类
 *
 * @Author：xiong
 * @Date：2024/5/19 14:32
 */

@Data
@ApiModel("字典数据查询类")
public class SysDictDataQuery extends PageQuery implements Serializable {

    @ApiModelProperty(value = "字典标签", example = "男")
    private String dictLabel;

    @ApiModelProperty(value = "字典名称", example = "sys_user_sex")
    private String dictType;

    @ApiModelProperty(value = "状态（0正常 1停用）", example = "0")
    private String status;
}

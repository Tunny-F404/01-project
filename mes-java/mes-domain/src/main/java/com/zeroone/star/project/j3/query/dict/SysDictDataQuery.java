package com.zeroone.star.project.j3.query.dict;

import com.fasterxml.jackson.annotation.JsonFormat;
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
public class SysDictDataQuery implements Serializable {

    @ApiModelProperty(value = "字典编号", example = "1")
    private Long dictCode;

    @ApiModelProperty(value = "字典排序", example = "1")
    private Integer dictSort;

    @ApiModelProperty(value = "字典标签", example = "男")
    private String dictLabel;

    @ApiModelProperty(value = "字典键值", example = "0")
    private String dictValue;

    @ApiModelProperty(value = "字典类型", example = "sys_user_sex")
    private String dictType;

    @ApiModelProperty(value = "样式属性（其他样式扩展）", example = "")
    private String cssClass;

    @ApiModelProperty(value = "表格回显样式", example = "info")
    private String listClass;

    @ApiModelProperty(value = "是否默认（Y是 N否）", example = "Y")
    private String isDefault;

    @ApiModelProperty(value = "状态（0正常 1停用）", example = "0")
    private String status;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建时间", example = "2022-04-07 00:29:32")
    private Date createTime;

    @ApiModelProperty(value = "更新者", example = "admin")
    private String updateBy;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新时间", example = "2022-04-07 00:29:32")
    private Date updateTime;

    @ApiModelProperty(value = "备注", example = "用户性别列表")
    private String remark;
}

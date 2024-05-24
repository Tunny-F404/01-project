package com.zeroone.star.project.j2.sysmanagement.dto.param;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * @author 40斤、kino
 * @version 1.0.0
 * @Description: 参数操作传输数据对象
 */
@Data
@ApiOperation("参数操作传输数据对象")
public class ParameterDTO {
    // 参数主键
    @ExcelProperty(value = "参数主键",index = 0)
    @ApiModelProperty(value = "参数主键",example = "1")
    private Integer configId;

    // 参数名称
    @ExcelProperty(value = "参数名称",index = 1)
    @ApiModelProperty(value = "参数名称",example = "主框架页-默认皮肤样式名称")
    @NotBlank(message = "参数名称不能为空")
    @Size(min = 0, max = 100, message = "参数名称不能超过100个字符")
    private String configName;

    // 参数键名
    @ExcelProperty(value = "参数键名",index = 2)
    @ApiModelProperty(value = "参数键名",example = "sys.index.skinName")
    @NotBlank(message = "参数键名长度不能为空")
    @Size(min = 0, max = 100, message = "参数键名长度不能超过100个字符")
    private String configKey;

    // 参数键值
    @ExcelProperty(value = "参数键值",index = 3)
    @ApiModelProperty(value = "参数键值",example = "skin-red")
    @NotBlank(message = "参数键值不能为空")
    @Size(min = 0, max = 500, message = "参数键值长度不能超过500个字符")
    private String configValue;

    // 系统内置（Y是 N否）
    @ExcelProperty(value = "系统内置 Y是 N否",index = 4)
    @ApiModelProperty(value = "系统内置 Y是 N否",example = "Y")
    private String configType;

    // 创建者
    @ExcelProperty(value = "创建者",index = 5)
    @ApiModelProperty(value = "创建者",example = "admin")
    private String createBy;

    // 创建时间
    @ExcelProperty(value = "创建时间",index = 6)
    @ApiModelProperty(value = "创建时间",example = "2022-04-07 00:29:32")
    @DateTimeFormat("yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    // 更新者
    @ExcelProperty(value = "更新者",index = 7)
    @ApiModelProperty(value = "更新者",example = "admin")
    private String updateBy;

    // 更新时间
    @ExcelProperty(value = "更新时间",index = 8)
    @ApiModelProperty(value = "更新时间",example = "2022-08-23 08:41:41")
    @DateTimeFormat( "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    // 备注
    @ExcelProperty(value = "备注",index = 9)
    @ApiModelProperty(value = "备注",example = "深色主题theme-dark，浅色主题theme-light")
    private String remark;


}

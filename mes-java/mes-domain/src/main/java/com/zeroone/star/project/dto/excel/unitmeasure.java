package com.zeroone.star.project.dto.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * <p>
 * 描述：导出单位数据
 * </p>
 * <p>版权：&copy;01星球</p>
 * <p>地址：01星球总部</p>
 * @author 本鼠
 * @version 1.0.0
 */

@Data
public class unitmeasure {
    @ExcelProperty(value = "单位编码",index = 0)
    private String measureCode;
    @ExcelProperty(value = "单位名称",index = 1)
    private String measureName;
    @ExcelProperty(value = "是否是主单位",index = 2)
    private Character primaryFlag;
    @ExcelProperty(value = "主单位ID",index = 3)
    private Integer primaryId;
    @ExcelProperty(value = "与主单位换算比例",index = 4)
    private Double changeRate;
    @ExcelProperty(value = "是否启用",index = 5)
    private Character enableFlag;
    @ExcelProperty(value = "预留字段1",index = 6)
    private String attr1;
    @ExcelProperty(value = "预留字段2",index = 7)
    private String arr2;
    @ExcelProperty(value = "预留字段3",index = 8)
    private String arr3;
    @ExcelProperty(value = "预留字段4",index = 9)
    private String arr4;
}


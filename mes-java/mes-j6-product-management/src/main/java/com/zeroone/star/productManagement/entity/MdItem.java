package com.zeroone.star.productManagement.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 物料产品表
 * </p>
 *
 * @author xiaotian
 * @since 2024-05-20
 */
@Getter
@Setter
@TableName("md_item")
public class MdItem implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "item_id", type = IdType.AUTO)
    @ExcelProperty("产品物料ID")
    private Long itemId;

    @ExcelProperty("产品物料编码")
    private String itemCode;

    @ExcelProperty("产品物料名称")
    private String itemName;

    @ExcelProperty("规格型号")
    private String specification;

    @ExcelProperty("单位")
    private String unitOfMeasure;

    @ExcelProperty("产品物料标识")
    private String itemOrProduct;

    @ExcelProperty("物料类型ID")
    private Long itemTypeId;

    @ExcelProperty("物料类型编码")
    private String itemTypeCode;

    @ExcelProperty("物料类型名称")
    private String itemTypeName;

    @ExcelProperty("是否启用")
    private String enableFlag;

    @ExcelProperty("是否设置安全库存")
    private String safeStockFlag;

    @ExcelProperty("最低库存量")
    private Double minStock;

    @ExcelProperty("最大库存量")
    private Double maxStock;

    @ExcelProperty("备注")
    private String remark;

    private String attr1;

    private String attr2;

    private Integer attr3;

    private Integer attr4;

    private String createBy;

    @TableField(fill = FieldFill.INSERT)
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

    @ExcelProperty("更新者")
    private String updateBy;

    @ExcelProperty("更新时间")
    private LocalDateTime updateTime;


}

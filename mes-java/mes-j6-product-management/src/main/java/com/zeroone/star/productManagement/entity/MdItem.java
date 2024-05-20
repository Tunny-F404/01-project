package com.zeroone.star.productManagement.entity;

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

    /**
     * 产品物料ID
     */
    @TableId(value = "item_id", type = IdType.AUTO)
    private Long itemId;

    /**
     * 产品物料编码
     */
    private String itemCode;

    /**
     * 产品物料名称
     */
    private String itemName;

    /**
     * 规格型号
     */
    private String specification;

    /**
     * 单位
     */
    private String unitOfMeasure;

    /**
     * 产品物料标识
     */
    private String itemOrProduct;

    /**
     * 物料类型ID
     */
    private Long itemTypeId;

    /**
     * 物料类型编码
     */
    private String itemTypeCode;

    /**
     * 物料类型名称
     */
    private String itemTypeName;

    /**
     * 是否启用
     */
    private String enableFlag;

    /**
     * 是否设置安全库存
     */
    private String safeStockFlag;

    /**
     * 最低库存量
     */
    private Double minStock;

    /**
     * 最大库存量
     */
    private Double maxStock;

    /**
     * 备注
     */
    private String remark;

    /**
     * 预留字段1
     */
    private String attr1;

    /**
     * 预留字段2
     */
    private String attr2;

    /**
     * 预留字段3
     */
    private Integer attr3;

    /**
     * 预留字段4
     */
    private Integer attr4;

    /**
     * 创建者
     */
    private String createBy;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 更新者
     */
    private String updateBy;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;


}

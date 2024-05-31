package com.zeroone.star.syshome.entity;

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
 * 来料检验单表
 * </p>
 *
 * @author lxh
 * @since 2024-05-29
 */
@Getter
@Setter
@TableName("qc_iqc")
public class QcIqc implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 来料检验单ID
     */
    @TableId(value = "iqc_id", type = IdType.AUTO)
    private Long iqcId;

    /**
     * 来料检验单编号
     */
    private String iqcCode;

    /**
     * 来料检验单名称
     */
    private String iqcName;

    /**
     * 检验模板ID
     */
    private Long templateId;

    /**
     * 来源单据ID
     */
    private Long sourceDocId;

    /**
     * 来源单据类型
     */
    private String sourceDocType;

    /**
     * 来源单据编号
     */
    private String sourceDocCode;

    /**
     * 来源单据行ID
     */
    private Long sourceLineId;

    /**
     * 供应商ID
     */
    private Long vendorId;

    /**
     * 供应商编码
     */
    private String vendorCode;

    /**
     * 供应商名称
     */
    private String vendorName;

    /**
     * 供应商简称
     */
    private String vendorNick;

    /**
     * 供应商批次号
     */
    private String vendorBatch;

    /**
     * 产品物料ID
     */
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
     * 最低检测数
     */
    private Integer quantityMinCheck;

    /**
     * 最大不合格数
     */
    private Integer quantityMaxUnqualified;

    /**
     * 本次接收数量
     */
    private Double quantityRecived;

    /**
     * 本次检测数量
     */
    private Integer quantityCheck;

    /**
     * 不合格数
     */
    private Integer quantityUnqualified;

    /**
     * 致命缺陷率
     */
    private Double crRate;

    /**
     * 严重缺陷率
     */
    private Double majRate;

    /**
     * 轻微缺陷率
     */
    private Double minRate;

    /**
     * 致命缺陷数量
     */
    private Integer crQuantity;

    /**
     * 严重缺陷数量
     */
    private Integer majQuantity;

    /**
     * 轻微缺陷数量
     */
    private Integer minQuantity;

    /**
     * 检测结果
     */
    private String checkResult;

    /**
     * 来料日期
     */
    private LocalDateTime reciveDate;

    /**
     * 检测日期
     */
    private LocalDateTime inspectDate;

    /**
     * 检测人员
     */
    private String inspector;

    /**
     * 单据状态
     */
    private String status;

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

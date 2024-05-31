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
 * 过程检验单表
 * </p>
 *
 * @author lxh
 * @since 2024-05-29
 */
@Getter
@Setter
@TableName("qc_ipqc")
public class QcIpqc implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 检验单ID
     */
    @TableId(value = "ipqc_id", type = IdType.AUTO)
    private Long ipqcId;

    /**
     * 检验单编号
     */
    private String ipqcCode;

    /**
     * 检验单名称
     */
    private String ipqcName;

    /**
     * 检验类型
     */
    private String ipqcType;

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
     * 工单ID
     */
    private Long workorderId;

    /**
     * 工单编码
     */
    private String workorderCode;

    /**
     * 工单名称
     */
    private String workorderName;

    /**
     * 任务ID
     */
    private Long taskId;

    /**
     * 任务编号
     */
    private String taskCode;

    /**
     * 任务名称
     */
    private String taskName;

    /**
     * 工作站ID
     */
    private Long workstationId;

    /**
     * 工作站编号
     */
    private String workstationCode;

    /**
     * 工作站名称
     */
    private String workstationName;

    /**
     * 工序ID
     */
    private Long processId;

    /**
     * 工序编码
     */
    private String processCode;

    /**
     * 工序名称
     */
    private String processName;

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
     * 检测数量
     */
    private Double quantityCheck;

    /**
     * 不合格数
     */
    private Double quantityUnqualified;

    /**
     * 合格品数量
     */
    private Double quantityQualified;

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
    private Double crQuantity;

    /**
     * 严重缺陷数量
     */
    private Double majQuantity;

    /**
     * 轻微缺陷数量
     */
    private Double minQuantity;

    /**
     * 检测结果
     */
    private String checkResult;

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

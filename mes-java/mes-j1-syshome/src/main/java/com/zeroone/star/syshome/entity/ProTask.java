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
 * 生产任务表
 * </p>
 *
 * @author lxh
 * @since 2024-05-29
 */
@Getter
@Setter
@TableName("pro_task")
public class ProTask implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 任务ID
     */
    @TableId(value = "task_id", type = IdType.AUTO)
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
     * 生产工单ID
     */
    private Long workorderId;

    /**
     * 生产工单编号
     */
    private String workorderCode;

    /**
     * 工单名称
     */
    private String workorderName;

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
     * 工艺ID
     */
    private Long routeId;

    /**
     * 工艺编号
     */
    private String routeCode;

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
     * 排产数量
     */
    private Double quantity;

    /**
     * 已生产数量
     */
    private Double quantityProduced;

    /**
     * 合格品数量
     */
    private Double quantityQuanlify;

    /**
     * 不良品数量
     */
    private Double quantityUnquanlify;

    /**
     * 调整数量
     */
    private Double quantityChanged;

    /**
     * 客户ID
     */
    private Long clientId;

    /**
     * 客户编码
     */
    private String clientCode;

    /**
     * 客户名称
     */
    private String clientName;

    /**
     * 客户简称
     */
    private String clientNick;

    /**
     * 开始生产时间
     */
    private LocalDateTime startTime;

    /**
     * 生产时长
     */
    private Integer duration;

    /**
     * 完成生产时间
     */
    private LocalDateTime endTime;

    /**
     * 甘特图显示颜色
     */
    private String colorCode;

    /**
     * 需求日期
     */
    private LocalDateTime requestDate;

    /**
     * 生产状态
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

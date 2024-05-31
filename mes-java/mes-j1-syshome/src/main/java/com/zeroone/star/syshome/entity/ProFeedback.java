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
 * 生产报工记录表
 * </p>
 *
 * @author lxh
 * @since 2024-05-29
 */
@Getter
@Setter
@TableName("pro_feedback")
public class ProFeedback implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 记录ID
     */
    @TableId(value = "record_id", type = IdType.AUTO)
    private Long recordId;

    /**
     * 报工类型
     */
    private String feedbackType;

    /**
     * 报工单编号
     */
    private String feedbackCode;

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
     * 生产工单ID
     */
    private Long workorderId;

    /**
     * 生产工单编号
     */
    private String workorderCode;

    /**
     * 生产工单名称
     */
    private String workorderName;

    /**
     * 工艺流程ID
     */
    private Long routeId;

    /**
     * 工艺流程编号
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
     * 生产任务ID
     */
    private Long taskId;

    /**
     * 生产任务编号
     */
    private String taskCode;

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
     * 单位
     */
    private String unitOfMeasure;

    /**
     * 规格型号
     */
    private String specification;

    /**
     * 排产数量
     */
    private Double quantity;

    /**
     * 本次报工数量
     */
    private Double quantityFeedback;

    /**
     * 合格品数量
     */
    private Double quantityQualified;

    /**
     * 不良品数量
     */
    private Double quantityUnquanlified;

    /**
     * 待检测数量
     */
    private Double quantityUncheck;

    /**
     * 报工用户名
     */
    private String userName;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 报工途径
     */
    private String feedbackChannel;

    /**
     * 报工时间
     */
    private LocalDateTime feedbackTime;

    /**
     * 记录人
     */
    private String recordUser;

    /**
     * 记录人名称
     */
    private String recordNick;

    /**
     * 状态
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

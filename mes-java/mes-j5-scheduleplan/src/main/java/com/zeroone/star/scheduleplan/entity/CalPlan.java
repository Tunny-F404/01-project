package com.zeroone.star.scheduleplan.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 排班计划表
 * </p>
 *
 * @author interstellar
 * @since 2024-05-25
 */
@Getter
@Setter
@TableName("cal_plan")
public class CalPlan implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 计划ID
     */
    @TableId(value = "plan_id", type = IdType.AUTO)
    private Long planId;

    /**
     * 计划编号
     */
    private String planCode;

    /**
     * 计划名称
     */
    private String planName;

    /**
     * 班组类型
     */
    private String calendarType;

    /**
     * 开始日期
     */
    private LocalDateTime startDate;

    /**
     * 结束日期
     */
    private LocalDateTime endDate;

    /**
     * 轮班方式
     */
    private String shiftType;

    /**
     * 倒班方式
     */
    private String shiftMethod;

    /**
     * 数
     */
    private Integer shiftCount;

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

package com.zeroone.star.project.dto.j4.basicdata.entity;

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
 * 单位表
 * </p>
 *
 * @author wxz
 * @since 2024-05-21
 */
@Getter
@Setter
@TableName("md_unit_measure")
public class MdUnitMeasure implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 单位ID
     */
    @TableId(value = "measure_id", type = IdType.AUTO)
    private Long measureId;

    /**
     * 单位编码
     */
    private String measureCode;

    /**
     * 单位名称
     */
    private String measureName;

    /**
     * 是否是主单位
     */
    private String primaryFlag;

    /**
     * 主单位ID
     */
    private Long primaryId;

    /**
     * 与主单位换算比例
     */
    private Double changeRate;

    /**
     * 是否启用
     */
    private String enableFlag;

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
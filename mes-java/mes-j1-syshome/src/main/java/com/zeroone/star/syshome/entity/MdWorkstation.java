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
 * 工作站表
 * </p>
 *
 * @author lxh
 * @since 2024-05-29
 */
@Getter
@Setter
@TableName("md_workstation")
public class MdWorkstation implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 工作站ID
     */
    @TableId(value = "workstation_id", type = IdType.AUTO)
    private Long workstationId;

    /**
     * 工作站编码
     */
    private String workstationCode;

    /**
     * 工作站名称
     */
    private String workstationName;

    /**
     * 工作站地点
     */
    private String workstationAddress;

    /**
     * 所在车间ID
     */
    private Long workshopId;

    /**
     * 所在车间编码
     */
    private String workshopCode;

    /**
     * 所在车间名称
     */
    private String workshopName;

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
     * 线边库ID
     */
    private Long warehouseId;

    /**
     * 线边库编码
     */
    private String warehouseCode;

    /**
     * 线边库名称
     */
    private String warehouseName;

    /**
     * 库区ID
     */
    private Long locationId;

    /**
     * 库区编码
     */
    private String locationCode;

    /**
     * 库区名称
     */
    private String locationName;

    /**
     * 库位ID
     */
    private Long areaId;

    /**
     * 库位编码
     */
    private String areaCode;

    /**
     * 库位名称
     */
    private String areaName;

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

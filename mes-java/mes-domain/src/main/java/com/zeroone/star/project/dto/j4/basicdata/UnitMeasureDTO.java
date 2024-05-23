package com.zeroone.star.project.dto.j4.basicdata;


import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * <p>
 * 单位表
 * </p>
 *
 * @author wxz
 * @since 2024-05-21
 */
@Data
@TableName("md_unit_measure")
@ApiModel(value = "查询单位分页列表的对象")
public class UnitMeasureDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 单位编码
     */
    @ApiModelProperty(value = "单位编码", example = "m")
    private String measureCode;

    /**
     * 单位名称
     */
    @ApiModelProperty(value = "单位名称", example = "米")
    private String measureName;

    /**
     * 是否是主单位
     */
    @ApiModelProperty(value = "是否是主单位", example = "Y")
    private String primaryFlag;

    /**
     * 主单位ID
     */
    @ApiModelProperty(value = "主单位ID", example = "1")
    private Long primaryId;

    /**
     * 与主单位换算比例
     */
    @ApiModelProperty(value = "与主单位换算比例", example = "1.0")
    private Double changeRate;

    /**
     * 是否启用
     */
    @ApiModelProperty(value = "是否启用", example = "Y")
    private String enableFlag;


    /**
     * 预留字段1
     */
    @ApiModelProperty(value = "预留字段1", example = "预留值1")
    private String attr1;

    /**
     * 预留字段2
     */
    @ApiModelProperty(value = "预留字段2", example = "200")
    private String attr2;

    /**
     * 预留字段3
     */
    @ApiModelProperty(value = "预留字段3", example = "100")
    private Integer attr3;

    /**
     * 预留字段4
     */
    @ApiModelProperty(value = "预留字段4", example = "200")
    private Integer attr4;

}

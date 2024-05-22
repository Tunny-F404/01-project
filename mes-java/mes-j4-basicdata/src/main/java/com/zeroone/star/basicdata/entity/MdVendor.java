package com.zeroone.star.basicdata.entity;

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
 * 供应商表
 * </p>
 *
 * @author zjx
 * @since 2024-05-20
 */
@Getter
@Setter
@TableName("md_vendor")
public class MdVendor implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 供应商ID
     */
    @TableId(value = "vendor_id", type = IdType.AUTO)
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
     * 供应商英文名称
     */
    private String vendorEn;

    /**
     * 供应商简介
     */
    private String vendorDes;

    /**
     * 供应商LOGO地址
     */
    private String vendorLogo;

    /**
     * 供应商等级
     */
    private String vendorLevel;

    /**
     * 供应商评分
     */
    private Integer vendorScore;

    /**
     * 供应商地址
     */
    private String address;

    /**
     * 供应商官网地址
     */
    private String website;

    /**
     * 供应商邮箱地址
     */
    private String email;

    /**
     * 供应商电话
     */
    private String tel;

    /**
     * 联系人1
     */
    private String contact1;

    /**
     * 联系人1-电话
     */
    private String contact1Tel;

    /**
     * 联系人1-邮箱
     */
    private String contact1Email;

    /**
     * 联系人2
     */
    private String contact2;

    /**
     * 联系人2-电话
     */
    private String contact2Tel;

    /**
     * 联系人2-邮箱
     */
    private String contact2Email;

    /**
     * 统一社会信用代码
     */
    private String creditCode;

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

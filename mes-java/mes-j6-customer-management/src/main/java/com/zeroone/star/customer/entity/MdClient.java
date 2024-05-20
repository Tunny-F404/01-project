package com.zeroone.star.customer.entity;

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
 * 客户表
 * </p>
 *
 * @author 小鱼
 * @since 2024-05-20
 */
@Getter
@Setter
@TableName("md_client")
public class MdClient implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 客户ID
     */
    @TableId(value = "client_id", type = IdType.AUTO)
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
     * 客户英文名称
     */
    private String clientEn;

    /**
     * 客户简介
     */
    private String clientDes;

    /**
     * 客户LOGO地址
     */
    private String clientLogo;

    /**
     * 客户类型
     */
    private String clientType;

    /**
     * 客户地址
     */
    private String address;

    /**
     * 客户官网地址
     */
    private String website;

    /**
     * 客户邮箱地址
     */
    private String email;

    /**
     * 客户电话
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

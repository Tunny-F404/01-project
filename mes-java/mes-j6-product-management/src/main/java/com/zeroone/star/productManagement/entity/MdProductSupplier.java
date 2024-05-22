package com.zeroone.star.productManagement.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author smile
 * @since 2024-05-22
 */
@Getter
@Setter
@TableName("md_product_supplier")
public class MdProductSupplier implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 物料id
     */
    private Long productId;

    /**
     * 供应商id
     */
    private Long supplierId;
}

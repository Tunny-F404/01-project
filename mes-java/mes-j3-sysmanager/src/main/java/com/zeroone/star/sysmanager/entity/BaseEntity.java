package com.zeroone.star.sysmanager.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Entity基类
 * 
 * @author ruoyi
 */

@Data
public class BaseEntity implements Serializable
{
    private static final long serialVersionUID = 1L;


    /** 创建者 */
    private String createBy;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDate createTime;

    /** 更新者 */
    private String updateBy;

    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDate updateTime;

    public void setCreateTime() {
        this.createTime = LocalDate.now();
    }

    public void setUpdateTime() {
        this.updateTime = LocalDate.now();
    }
}

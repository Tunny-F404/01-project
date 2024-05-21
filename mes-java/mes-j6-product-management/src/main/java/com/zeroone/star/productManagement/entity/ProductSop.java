package com.zeroone.star.productManagement.entity;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@TableName("md_product_sop")
public class ProductSop {
    private Long sopId;  // SOP的唯一标识符
    private Long itemId; // 产品项目的唯一标识符
    private Integer orderNum; // SOP的顺序号
    private Long processId; // 流程的唯一标识符
    private String processCode; // 流程的代码
    private String processName; // 流程的名称
    private String sopTitle; // SOP的标题
    private String sopDescription; // SOP的描述
    private String sopUrl; // SOP的链接地址
}

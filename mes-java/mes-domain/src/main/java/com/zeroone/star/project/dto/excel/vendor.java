package com.zeroone.star.project.dto.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * <p>
 * 描述：导出供应商数据
 * </p>
 * <p>版权：&copy;01星球</p>
 * <p>地址：01星球总部</p>
 * @author 本鼠
 * @version 1.0.0
 */

@Data
public class vendor {
    @ExcelProperty(value = "供应商编码",index = 0)
    private String vendorCode;
    @ExcelProperty(value = "供应商名称",index = 1)
    private String vendorName;
    @ExcelProperty(value = "供应商简称",index = 2)
    private String vendorNick;
    @ExcelProperty(value = "供应商英文名称",index = 3)
    private String vendorEn;
    @ExcelProperty(value = "供应商简介",index = 4)
    private String vendorDes;
    @ExcelProperty(value = "供应商LOGO地址",index = 5)
    private String vendorLogo;
    @ExcelProperty(value = "供应商等级",index = 6)
    private Character vendorLevel;
    @ExcelProperty(value = "供应商评分",index = 7)
    private Integer vendorScore;
    @ExcelProperty(value = "供应商地址",index = 8)
    private String address;
    @ExcelProperty(value = "供应商官网地址",index = 9)
    private String website;
    @ExcelProperty(value = "供应商邮箱地址",index = 10)
    private String email;
    @ExcelProperty(value = "供应商电话",index = 11)
    private String tel;
    @ExcelProperty(value = "联系人1",index = 12)
    private String contact1;
    @ExcelProperty(value = "联系人1-电话",index = 13)
    private String contact1Tel;
    @ExcelProperty(value = "联系人1-邮箱",index = 14)
    private String contact1Email;
    @ExcelProperty(value = "联系人2",index = 15)
    private String contact2;
    @ExcelProperty(value = "联系人2-电话",index = 16)
    private String contact2Tel;
    @ExcelProperty(value = "联系人2-邮箱",index = 17)
    private String contact2Email;
    @ExcelProperty(value = "统一社会信用代码",index = 18)
    private String creditCode;
    @ExcelProperty(value = "是否启用",index = 19)
    private Character enableFlag;
}

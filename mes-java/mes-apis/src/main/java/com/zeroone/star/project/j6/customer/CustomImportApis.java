package com.zeroone.star.project.j6.customer;

import com.zeroone.star.project.components.easyexcel.EasyExcelComponent;
import com.zeroone.star.project.j6.customer.dto.CustomerImportDTO;
import com.zeroone.star.project.vo.JsonVO;

import java.util.List;

/**
 * <p>
 * 描述：客户数据导入接口定义
 * </p>
 * <p>版权：&copy;01星球</p>
 * <p>地址：01星球总部</p>
 * @author 快乐小新
 * @version 1.0.0
 */
public interface CustomImportApis {
    /**
     *
     * @param excel 转换excel为list的对象
     * @return List集合
     */
    List<Object> parseExcel(EasyExcelComponent excel);

    /**
     *
     * @param customer 数据集
     * @return 导入结果
     */
    JsonVO<CustomerImportDTO> addList(List customer);
}

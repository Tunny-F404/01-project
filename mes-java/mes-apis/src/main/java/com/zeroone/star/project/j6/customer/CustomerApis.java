package com.zeroone.star.project.j6.customer;

import com.zeroone.star.project.components.easyexcel.EasyExcelComponent;
import com.zeroone.star.project.j6.customer.dto.ResultDTO;
import com.zeroone.star.project.j6.customer.query.CustomExportQuery;
import com.zeroone.star.project.vo.JsonVO;

import java.util.List;

/**
 * <p>
 * 描述：导入导出客户接口定义
 * </p>
 * <p>版权：&copy;01星球</p>
 * <p>地址：01星球总部</p>
 * @author 快乐小新
 * @version 1.0.0
 */
public interface CustomerApis {
    /**
     *
     * @param customExport 导出条件
     * @return 导出结果
     */
    JsonVO<ResultDTO> queryCustomExport(CustomExportQuery customExport);
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
    JsonVO<ResultDTO> addList(List customer);

    /**
     *
     * @return 返回下载模板情况
     */
    JsonVO<ResultDTO> DownloadResult();
}

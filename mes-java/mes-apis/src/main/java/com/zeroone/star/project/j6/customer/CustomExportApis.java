package com.zeroone.star.project.j6.customer;
import com.zeroone.star.project.j6.customer.dto.CustomExportDTO;
import com.zeroone.star.project.j6.customer.query.CustomExportQuery;
import com.zeroone.star.project.vo.JsonVO;

/**
 * <p>
 * 描述：导出客户接口定义
 * </p>
 * <p>版权：&copy;01星球</p>
 * <p>地址：01星球总部</p>
 * @author 快乐小新
 * @version 1.0.0
 */
public interface CustomExportApis {
    /**
     *
     * @param customExport 导出条件
     * @return 导出结果
     */
    JsonVO<CustomExportDTO> queryCustomExport(CustomExportQuery customExport);
}

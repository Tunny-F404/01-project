package com.zeroone.star.project.j4.basicdata;

import com.zeroone.star.project.dto.j4.basicdata.UnitExcelSelectDTO;
import com.zeroone.star.project.vo.JsonVO;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * 计算单位接口API定义
 * @author ：酌
 * @version 1.0
 */
public interface AccountUnitApis {
    /**
     * 删除计算单位
     * @author ：本鼠
     * @param measureIds 计算单位ID
     * @return 删除是否成功
     */
    JsonVO<String> deleteUnitMeasure(List<Long> measureIds);

    /**
     * 导出计算单位
     * @author ：本鼠
     * @param unitExcelSelectDTO 导出单位excel报表查询条件参数
     * @return
     */
    ResponseEntity<byte[]> exportUnitMeasure(UnitExcelSelectDTO unitExcelSelectDTO);
}

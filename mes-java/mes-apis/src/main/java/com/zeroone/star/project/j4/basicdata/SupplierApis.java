package com.zeroone.star.project.j4.basicdata;

import com.zeroone.star.project.dto.j4.basicdata.VendorExcelSelectDTO;
import org.springframework.http.ResponseEntity;

/**
 * 供应商接口API定义
 * @author ：酌
 * @version 1.0
 */
public interface SupplierApis {
    /**
     * 导出供应商
     * @author :本鼠
     * @param vendorExcelSelectDTO 导出供应商excel报表查询条件参数
     * @return
     */
    ResponseEntity<byte[]> exportVendor(VendorExcelSelectDTO vendorExcelSelectDTO);
}

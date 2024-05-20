package com.zeroone.star.project.j6.product_management;

import com.zeroone.star.project.j6.product_management.query.MdItemQuery;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface MdItemApis {
    //导出物料产品列表
    ResponseEntity<byte[]> exportToExcel(MdItemQuery mdItemQuery);
    //下载导入模板
    ResponseEntity<byte[]> importTemplate();
    //导入物料产品数据
    ResponseEntity<String> importFromExcel(MultipartFile file, boolean updateSupport);
}

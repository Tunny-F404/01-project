package com.zeroone.star.project.j6.product_management;

import com.zeroone.star.project.j6.product_management.query.MdItemQuery;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface MdItemApis {
    /**
     * 导出物料产品列表
     * @param mdItemQuery 查询参数
     * @return Excel 文件内容
     */
    ResponseEntity<byte[]> exportToExcel(MdItemQuery mdItemQuery);
    /**
     * 下载导入模板
     * @return 导入模板文件内容
     */
    ResponseEntity<byte[]> importTemplate();
    /**
     * 导入物料产品数据
     * @param file Excel 文件
     * @param updateSupport 是否更新已经存在的用户数据
     * @return 导入结果
     */
    ResponseEntity<String> importFromExcel(MultipartFile file, boolean updateSupport);
}

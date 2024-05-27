package com.zeroone.star.customer.service;

import com.zeroone.star.customer.entity.MdClient;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zeroone.star.project.j6.customer.dto.ResultDTO;
import com.zeroone.star.project.j6.customer.query.MdClientExportQuery;

import java.io.File;

/**
 * <p>
 * 客户表 服务类
 * </p>
 *
 * @author 快乐小新
 * @since 2024-05-21
 */
public interface IMdClientService extends IService<MdClient> {
    /**
     * 客户数据导出
     * @param mdClientExportQuery 数据
     * @return 导出结果
     */
    ResultDTO MdClientExport(MdClientExportQuery mdClientExportQuery);

    /**
     * 数据集导入
     * @param file 数据
     * @return 导入结果
     */
    ResultDTO CustomerImport(File file);

    /**
     *
     * @return 返回模板下载情况
     */
    ResultDTO DownloadResult();
}

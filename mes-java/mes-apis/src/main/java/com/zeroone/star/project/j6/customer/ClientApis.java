package com.zeroone.star.project.j6.customer;

import com.zeroone.star.project.dto.PageDTO;
import com.zeroone.star.project.j6.customer.dto.ClientDTO;
import com.zeroone.star.project.j6.customer.dto.ClientUpdateDTO;
import com.zeroone.star.project.j6.customer.dto.ResultDTO;
import com.zeroone.star.project.j6.customer.query.ClientQuery;
import com.zeroone.star.project.j6.customer.query.CustomExportQuery;
import com.zeroone.star.project.vo.JsonVO;

import javax.validation.constraints.Min;
import java.util.List;

public interface ClientApis {
    // 新增客户
    JsonVO<String> addClient(ClientDTO client);

    // 删除客户
    JsonVO<String> deleteClient(List<Long> ids);

    // 修改客户信息
    JsonVO<String> updateClient(Long id, ClientUpdateDTO client);

    // 查询所有客户信息
    JsonVO<PageDTO<ClientDTO>> queryAll(ClientQuery query);

    // 根据id查询客户
    JsonVO<ClientDTO> queryById(@Min(value = 1, message = "id的最小值为1") Long id);

    /**
     * @param customExport 导出条件
     * @return 导出结果
     */
    JsonVO<ResultDTO> queryCustomExport(CustomExportQuery customExport);

    /**
     * @param customer 数据集
     * @return 导入结果
     */
    JsonVO<ResultDTO> addList(List customer);

    /**
     * @return 返回下载模板情况
     */
    JsonVO<ResultDTO> DownloadResult();
}

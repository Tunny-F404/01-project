package com.zeroone.star.project.j6.customer;

import com.zeroone.star.project.dto.PageDTO;
import com.zeroone.star.project.j6.customer.dto.ClientDTO;
import com.zeroone.star.project.j6.customer.dto.ClientUpdateDTO;
import com.zeroone.star.project.j6.customer.query.ClientExportQuery;
import com.zeroone.star.project.j6.customer.query.ClientQuery;
import com.zeroone.star.project.vo.JsonVO;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.util.List;

public interface ClientApis {
    // 新增客户
    JsonVO<String> addClient(@Validated ClientDTO client);

    // 删除客户
    JsonVO<String> deleteClient(@NotEmpty List<Long> ids);

    // 修改客户信息
    JsonVO<String> updateClient(@Validated ClientUpdateDTO client);

    // 查询所有客户信息
    JsonVO<PageDTO<ClientDTO>> queryAll(ClientQuery query);

    // 根据id查询客户
    JsonVO<ClientDTO> queryById(@Min(value = 1, message = "id的最小值为1") Long id);

    /**
     * @param clientExportQueryExport 导出条件
     * @param
     * @return 导出结果
     */
    ResponseEntity<byte[]> queryClientExportByExcel(ClientExportQuery clientExportQueryExport);

    /**
     * @param customer 数据集
     * @return 导入结果
     */
    JsonVO<String> importClientByExcel(MultipartFile customer);


    /**
     * @return 返回下载模板情况
     */
    ResponseEntity<byte[]> DownloadTemplate();

}

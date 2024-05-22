package com.zeroone.star.project.j6.customer;

import com.zeroone.star.project.dto.PageDTO;
import com.zeroone.star.project.j6.customer.dto.ClientDTO;
import com.zeroone.star.project.j6.customer.query.ClientQuery;
import com.zeroone.star.project.vo.JsonVO;

import java.util.List;

public interface ClientApis {
    // 新增客户
    JsonVO<String> addClient(ClientDTO client);

    // 删除客户
    JsonVO<String> deleteClient(List<Long> ids);

    // 修改客户信息
    JsonVO<String> updateClient(ClientDTO client);

    // 查询所有客户信息
    JsonVO<PageDTO<ClientDTO>> queryAll(ClientQuery query);

    // 根据id查询客户
    JsonVO<ClientDTO> queryById(Long id);
}

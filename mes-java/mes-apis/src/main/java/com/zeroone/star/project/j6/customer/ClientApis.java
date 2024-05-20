package com.zeroone.star.project.j6.customer;

import com.zeroone.star.project.dto.PageDTO;
import com.zeroone.star.project.j6.customer.dto.ClientDTO;
import com.zeroone.star.project.j6.customer.query.ClientQuery;
import com.zeroone.star.project.vo.JsonVO;

public interface ClientApis {
    // 新增客户
    JsonVO<ClientDTO> addClient(ClientDTO client);

    // 删除客户
    JsonVO<String> deleteClient(Long id);

    // 修改客户信息
    JsonVO<ClientDTO> updateClient(ClientDTO client);

    // 查询所有客户信息
    JsonVO<PageDTO<ClientDTO>> queryAll(ClientQuery query);

    // 根据id查询客户
    JsonVO<ClientDTO> queryById(Long id);
}

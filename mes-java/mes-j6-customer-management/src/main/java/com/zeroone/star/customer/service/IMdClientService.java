package com.zeroone.star.customer.service;

import com.zeroone.star.customer.entity.MdClient;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zeroone.star.project.dto.PageDTO;
import com.zeroone.star.project.j6.customer.dto.ClientDTO;
import com.zeroone.star.project.j6.customer.query.ClientQuery;
import com.zeroone.star.project.vo.JsonVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 客户表 服务类
 * </p>
 *
 * @author 小鱼
 * @since 2024-05-20
 */
public interface IMdClientService extends IService<MdClient> {
    /**
     * @Description 新增客户业务流程
     * @Param clientDTO [client]
     * @return com.zeroone.star.project.vo.JsonVO<com.zeroone.star.project.j6.customer.dto.ClientDTO>
     **/
    JsonVO<String> addClient(ClientDTO client);

    /**
     * @Description 删除客户业务流程
     * @Param List<Long> [ids]
     * @return com.zeroone.star.project.vo.JsonVO<java.lang.String>
     **/
    JsonVO<String> deleteClient(List<Long> ids);

    /**
     * @Description 更新客户
     * @Param clientDTO [client]
     * @return com.zeroone.star.project.vo.JsonVO<com.zeroone.star.project.j6.customer.dto.ClientDTO>
     **/
    JsonVO<String> updateClient(ClientDTO client);

    /**
     * @Description 分页查询客户数据
     * @Param query 查询条件
     * @return 查询结果
     **/
    PageDTO<ClientDTO> listAll(ClientQuery query);

    /**
     * @Description 通过id查询客户数据
     * @Param id
     * @return 查询结果
     **/
    ClientDTO getById(Long id);
}

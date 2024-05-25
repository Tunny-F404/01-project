package com.zeroone.star.customer.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zeroone.star.customer.entity.MdClient;
import com.zeroone.star.customer.mapper.MdClientMapper;
import com.zeroone.star.customer.service.IMdClientService;
import com.zeroone.star.project.dto.PageDTO;
import com.zeroone.star.project.j6.customer.dto.ClientDTO;
import com.zeroone.star.project.j6.customer.dto.ClientUpdateDTO;
import com.zeroone.star.project.j6.customer.query.ClientQuery;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Mapper(componentModel = "spring")
interface msClientMapper {
    /**
     * @Description 将MdClient对象转换为clientDTO对象
     * @return com.zeroone.star.project.j6.customer.dto.clientDTO
     **/
    ClientDTO clientToClientDTO(MdClient client);

    /**
     * @Description 将clientDTO对象转换为MdClient对象
     * @return com.zeroone.star.customer.entity.MdClient
     **/
    MdClient clientDTOToMdClient(ClientDTO clientDTO);
    /**
     * @Description 将clientUpdateDTO对象转换为MdClient对象
     * @return com.zeroone.star.customer.entity.MdClient
     **/
    MdClient clientUpdateDTOToMdClient(ClientUpdateDTO clientUpdateDTO);
}

@Service
public class MdClientServiceImpl extends ServiceImpl<MdClientMapper, MdClient> implements IMdClientService {

    @Resource
    private MdClientMapper mdClientMapper;

    @Resource
    private msClientMapper msClientMapper;

    @Override
    public boolean addClient(ClientDTO client) {
        // 将ClientDTO对象转换为DO
        MdClient mdClient = msClientMapper.clientDTOToMdClient(client);

        // 保存到数据库并返回操作结果
        return mdClientMapper.insert(mdClient) > 0;

    }

    @Override
    public boolean deleteClient(List<Long> ids) {
        // (批量)删除客户数据
        return mdClientMapper.deleteBatchIds(ids) > 0;
    }

    @Override
    public boolean updateClient(ClientUpdateDTO client) {
        // 查询客户是否存在
        MdClient existingClient = mdClientMapper.selectById(client.getClientId());
        if (existingClient == null) {
            return false;
        }

        // 将DTO对象转换为DO
        MdClient updatedClient = msClientMapper.clientUpdateDTOToMdClient(client);

        // 更新数据库中的客户信息
        return mdClientMapper.updateById(updatedClient) > 0;
    }


    @Override
    public PageDTO<ClientDTO> listAll(ClientQuery query) {
        // 构造分页对象
        Page<MdClient> clientPage = new Page<>(query.getPageNum(), query.getPageSize());
        // 构建查询条件
        QueryWrapper<MdClient> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("clientName", query.getClientName());
        // 查询客户列表数据
        Page<MdClient> clients = mdClientMapper.selectPage(clientPage, queryWrapper);

        // 返回封装分页信息和客户列表数据的PageDTO对象
        return PageDTO.create(clients, client -> msClientMapper.clientToClientDTO(client));
    }

    @Override
    public ClientDTO getById(Long id) {
        // 根据id查询数据库中的客户信息
        MdClient mdClient = mdClientMapper.selectById(id);

        // 将客户信息转换为DTO对象并返回
        return msClientMapper.clientToClientDTO(mdClient);
    }
}

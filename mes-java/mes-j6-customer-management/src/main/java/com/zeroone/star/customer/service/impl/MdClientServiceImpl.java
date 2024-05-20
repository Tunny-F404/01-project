package com.zeroone.star.customer.service.impl;

import com.zeroone.star.customer.entity.MdClient;
import com.zeroone.star.customer.mapper.MdClientMapper;
import com.zeroone.star.customer.service.IMdClientService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zeroone.star.project.dto.PageDTO;
import com.zeroone.star.project.j6.customer.dto.ClientDTO;
import com.zeroone.star.project.j6.customer.query.ClientQuery;
import com.zeroone.star.project.vo.JsonVO;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

@Mapper(componentModel = "Spring")
interface MsClientMapper{
    /**
     * @Description 将MdClient对象转换为clientDTO对象
     * @Date 13:40 2024/5/20
     * @Param [client]
     * @return com.zeroone.star.project.j6.customer.dto.clientDTO
     **/
    ClientDTO clientToClientDTO(MdClient client);
}

/**
 * <p>
 * 客户表 服务实现类
 * </p>
 *
 * @author root
 * @since 2024-05-20
 */
@Service
public class MdClientServiceImpl extends ServiceImpl<MdClientMapper, MdClient> implements IMdClientService {

    @Override
    public JsonVO<ClientDTO> addClient(ClientDTO client) {
        return null;
    }

    @Override
    public JsonVO<String> deleteClient(Long id) {
        return null;
    }

    @Override
    public JsonVO<ClientDTO> updateClient(ClientDTO client) {
        return null;
    }

    @Override
    public PageDTO<ClientDTO> listAll(ClientQuery query) {
        return null;
    }

    @Override
    public ClientDTO getById(Long id) {
        return null;
    }
}

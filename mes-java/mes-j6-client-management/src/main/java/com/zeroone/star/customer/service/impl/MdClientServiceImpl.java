package com.zeroone.star.customer.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zeroone.star.customer.entity.MdClient;
import com.zeroone.star.customer.mapper.MdClientMapper;
import com.zeroone.star.customer.service.IMdClientService;
import com.zeroone.star.project.dto.PageDTO;
import com.zeroone.star.project.j6.customer.dto.ClientDTO;
import com.zeroone.star.project.j6.customer.query.ClientQuery;
import com.zeroone.star.project.vo.JsonVO;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper(componentModel = "Spring")
interface MsClientMapper {
    /**
     * @return com.zeroone.star.project.j6.customer.dto.clientDTO
     * @Description 将MdClient对象转换为clientDTO对象
     * @Date 13:40 2024/5/20
     * @Param [client]
     **/
    ClientDTO clientToClientDTO(MdClient client);
}

@Service
public class MdClientServiceImpl extends ServiceImpl<MdClientMapper, MdClient> implements IMdClientService {

    @Override
    public JsonVO<String> addClient(ClientDTO client) {
        return null;
    }

    @Override
    public JsonVO<String> deleteClient(List<Long> ids) {
        return null;
    }

    @Override
    public JsonVO<String> updateClient(ClientDTO client) {
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

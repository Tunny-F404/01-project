package com.zeroone.star.customer.service.impl;

import cn.hutool.core.date.DateTime;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zeroone.star.customer.entity.MdClient;
import com.zeroone.star.customer.mapper.MdClientMapper;
import com.zeroone.star.customer.service.IMdClientService;
import com.zeroone.star.project.components.easyexcel.EasyExcelComponent;
import com.zeroone.star.project.components.easyexcel.ExcelReadListener;
import com.zeroone.star.project.components.fastdfs.FastDfsClientComponent;
import com.zeroone.star.project.components.fastdfs.FastDfsFileInfo;
import com.zeroone.star.project.dto.PageDTO;
import com.zeroone.star.project.j6.customer.dto.ClientDTO;
import com.zeroone.star.project.j6.customer.dto.ClientUpdateDTO;
import com.zeroone.star.project.j6.customer.query.ClientExportQuery;
import com.zeroone.star.project.j6.customer.query.ClientQuery;
import com.zeroone.star.project.vo.JsonVO;
import lombok.SneakyThrows;
import lombok.val;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
interface msClientMapper {
    /**
     * @return com.zeroone.star.project.j6.customer.dto.clientDTO
     * @Description 将MdClient对象转换为clientDTO对象
     **/
    ClientDTO clientToClientDTO(MdClient client);

    /**
     * @return com.zeroone.star.customer.entity.MdClient
     * @Description 将clientDTO对象转换为MdClient对象
     **/
    MdClient clientDTOToMdClient(ClientDTO clientDTO);

    /**
     * @return com.zeroone.star.customer.entity.MdClient
     * @Description 将clientUpdateDTO对象转换为MdClient对象
     **/
    MdClient clientUpdateDTOToMdClient(ClientUpdateDTO clientUpdateDTO);
}

@Service
@Transactional
public class MdClientServiceImpl extends ServiceImpl<MdClientMapper, MdClient> implements IMdClientService {

    @Autowired
    EasyExcelComponent easyExcelComponent;
    @Autowired
    FastDfsClientComponent dfs;
    @Value("${fastdfs.nginx-servers}")
    String urlPrefix;
    QueryWrapper<MdClient> queryWrapper;
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


    @SneakyThrows
    @Override
    public ResponseEntity<byte[]> queryClientExportByExcel(ClientExportQuery clientExportQuery) {

        List<MdClient> list = mdClientMapper.selectMdClientList(clientExportQuery);
        if (list == null || list.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        // 构建一个输出流
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        // 导出数据到输出流
        easyExcelComponent.export("客户列表", out, MdClient.class, list);
        // 获取字节数据
        byte[] bytes = out.toByteArray();
        out.close();
        //构建相应头
        HttpHeaders headers = new HttpHeaders();
        String filename = "clients-" + DateTime.now().toString("yyyyMMddHHmmss") + ".xlsx";
        headers.setContentDispositionFormData("attachment", filename);
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        //放回客户端
        return new ResponseEntity<>(bytes, headers, HttpStatus.CREATED);
    }

    @SneakyThrows
    @Override
    public JsonVO<String> importClientByExcel(MultipartFile customer) {
        String filename = customer.getOriginalFilename();
        assert filename != null;
        String suffix = filename.substring(filename.lastIndexOf(".") + 1);
        FastDfsFileInfo result = dfs.uploadFile(customer.getBytes(), suffix);
        if (result == null) {
            return JsonVO.fail(null);
        }


        ExcelReadListener excelReadListener = (ExcelReadListener) easyExcelComponent.parseExcel(urlPrefix, MdClient.class);
        List<MdClient> mdClients = excelReadListener.getDataList();
        if (mdClients != null && !mdClients.isEmpty()) {
            val clientIds = mdClients.stream()
                    .map(MdClient::getClientId)
                    .collect(Collectors.toList());

            QueryWrapper<MdClient> queryWrapper = new QueryWrapper<>();
            queryWrapper.in("client_id", clientIds);
            List<MdClient> existingClients = baseMapper.selectList(queryWrapper);

            if (existingClients != null && !existingClients.isEmpty()) {
                mdClients.removeAll(existingClients);
            }

            if (!mdClients.isEmpty()) {
                for (MdClient client : mdClients) {
                    mdClientMapper.insert(client);
                }
            }

            return JsonVO.success(dfs.fetchUrl(result, urlPrefix, false));
        }

        return JsonVO.fail("上传失败");
    }

    //初始化参考客户模板
    private MdClient initMdClient() {
        MdClient mdClient = new MdClient();
        mdClient.setClientId(null);
        mdClient.setClientCode("");
        mdClient.setClientName("Example Client"); // 添加这一行，给客户名称赋值
        mdClient.setClientNick("");
        mdClient.setClientEn("");
        mdClient.setClientDes("");
        mdClient.setClientLogo("");
        mdClient.setClientType("");
        mdClient.setAddress("");
        mdClient.setWebsite("");
        mdClient.setEmail("");
        mdClient.setTel("");
        mdClient.setContact1("");
        mdClient.setContact1Tel("");
        mdClient.setContact1Email("");
        mdClient.setContact2("");
        mdClient.setContact2Tel("");
        mdClient.setContact2Email("");
        mdClient.setCreditCode("");
        mdClient.setEnableFlag("");
        mdClient.setRemark("");
        mdClient.setAttr1("");
        mdClient.setAttr2("");
        mdClient.setAttr3(null);
        mdClient.setAttr4(null);
        mdClient.setCreateBy("");
        mdClient.setCreateTime(null);
        mdClient.setUpdateBy("");
        mdClient.setUpdateTime(null);
        return mdClient;
    }


    @SneakyThrows
    @Override
    public ResponseEntity<byte[]> DownloadTemplate() {
        List<MdClient> mdClients = new ArrayList<>();
        mdClients.add(initMdClient());
        // 构建一个输出流
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        // 导出数据到输出流
        easyExcelComponent.export("客户列表", out, MdClient.class, mdClients);
        // 获取字节数据
        byte[] bytes = out.toByteArray();
        out.close();
        // 构建响应头
        HttpHeaders headers = new HttpHeaders();
        String filename = "client-" + DateTime.now().toString("yyyyMMddHHmmss") + ".xlsx";
        headers.setContentDispositionFormData("attachment", filename);
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        // 响应文件给客户端
        return new ResponseEntity<>(bytes, headers, HttpStatus.CREATED);

    }
}

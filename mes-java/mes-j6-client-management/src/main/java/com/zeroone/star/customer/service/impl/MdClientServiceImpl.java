package com.zeroone.star.customer.service.impl;

import cn.hutool.core.date.DateTime;
import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zeroone.star.customer.entity.MdClient;
import com.zeroone.star.customer.entity.MdClientExcel;
import com.zeroone.star.customer.mapper.MdClientMapper;
import com.zeroone.star.customer.service.IMdClientService;
import com.zeroone.star.project.components.easyexcel.EasyExcelComponent;
import com.zeroone.star.project.components.easyexcel.ExcelReadListener;
import com.zeroone.star.project.components.fastdfs.FastDfsClientComponent;
import com.zeroone.star.project.components.fastdfs.FastDfsFileInfo;
import com.zeroone.star.project.dto.PageDTO;
import com.zeroone.star.project.j6.customer.dto.ClientDTO;
import com.zeroone.star.project.j6.customer.dto.ClientUpdateDTO;
import com.zeroone.star.project.j6.customer.query.ClientQuery;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.ResultStatus;
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

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
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



    @Override
    public ResponseEntity<byte[]> queryClientExportByExcel(List<Long> ids) {
        List<MdClient> list = new ArrayList<>();
        for (Long id : ids) {
            MdClient mdClient = mdClientMapper.selectById(id);
            if (mdClient != null) {
                list.add(mdClient);
            }
        }

        if (list.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        try (ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            easyExcelComponent.export("客户列表", out, MdClient.class, list);
            byte[] bytes = out.toByteArray();
            HttpHeaders headers = new HttpHeaders();
            String filename = "clients-" + DateTime.now().toString("yyyyMMddHHmmss") + ".xlsx";
            headers.setContentDispositionFormData("attachment", filename);
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            return new ResponseEntity<>(bytes, headers, HttpStatus.CREATED);
        } catch (IOException e) {
            // 处理异常并返回错误信息
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(("导出Excel文件时发生错误：" + e.getMessage()).getBytes());
        }
    }


    @Override
    public JsonVO<String> importClientByExcel(MultipartFile customer) {
        List<MdClient> mdClients;
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        StringBuilder failureNameMsg = new StringBuilder();

        try (BufferedInputStream inputStream = new BufferedInputStream(customer.getInputStream())) {
            mdClients = EasyExcel.read(inputStream).head(MdClient.class).sheet().doReadSync();
        } catch (IOException e) {
            return JsonVO.create(null, ResultStatus.FAIL.getCode(), "读取Excel文件失败");
        }

        if (mdClients == null || mdClients.isEmpty()) {
            return JsonVO.create(null, ResultStatus.FAIL.getCode(), "Excel文件中无数据");
        }

        for (MdClient mdClient : mdClients) {
            try {
                if (!mdClientMapper.checkMdClientCodeUnique(mdClient.getClientCode())) {
                    mdClientMapper.insert(mdClient);
                } else {
                    mdClientMapper.updateByClientCode(mdClient.getClientCode(), mdClient);
                }
                successNum++;
            } catch (Exception e) {
                failureNum++;
                failureNameMsg.append(failureNum).append("、").append(mdClient.getClientCode()).append(";");
            }
        }

        if (failureNum > 0) {
            failureMsg.append("成功导入").append(successNum).append("条数据，共").append(failureNum).append("条数据格式不正确，错误如下：").append(failureNameMsg);
            return JsonVO.create(null, ResultStatus.FAIL.getCode(), failureMsg.toString());
        } else {
            successMsg.append("导入成功！共 ").append(successNum).append(" 条");
            return JsonVO.create(null, ResultStatus.SUCCESS.getCode(), successMsg.toString());
        }
    }

    //初始化参考客户模板
    @PostConstruct
    public MdClientExcel initMdClient(){
        MdClientExcel mdClient = new MdClientExcel();
        mdClient.setClientCode("必填");
        mdClient.setClientName("必填"); // 添加这一行，给客户名称赋值
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
        List<MdClientExcel> mdClients = new ArrayList<>();
        mdClients.add(initMdClient());
        // 构建一个输出流
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        // 导出数据到输出流
        easyExcelComponent.export("客户列表", out, MdClientExcel.class, mdClients);
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

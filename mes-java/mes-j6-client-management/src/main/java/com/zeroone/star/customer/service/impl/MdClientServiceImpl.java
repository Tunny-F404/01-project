package com.zeroone.star.customer.service.impl;

import cn.hutool.core.date.DateTime;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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
import com.zeroone.star.project.j6.customer.query.ClientExportQuery;
import com.zeroone.star.project.j6.customer.query.ClientQuery;
import com.zeroone.star.project.j6.product_management.query.MdItemQuery;
import com.zeroone.star.project.vo.JsonVO;
import lombok.SneakyThrows;
import lombok.val;
import org.apache.commons.lang.StringUtils;
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

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
@Transactional
public class MdClientServiceImpl extends ServiceImpl<MdClientMapper, MdClient> implements IMdClientService {



    @Autowired
    EasyExcelComponent  easyExcelComponent;

    @Autowired
    FastDfsClientComponent dfs;


     QueryWrapper<MdClient> queryWrapper;

    @Autowired
    private MdClientMapper mdClientMapper;


    @Value("${fastdfs.nginx-servers}")
    String urlPrefix;


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



    @SneakyThrows
    @Override
    public ResponseEntity<byte[]> queryClientExportByExcel( ClientExportQuery clientExportQuery) {

        List<MdClient> list =  mdClientMapper.selectMdClientList(clientExportQuery);
        if(list == null || list.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        // 构建一个输出流
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        // 导出数据到输出流
        easyExcelComponent.export("客户列表", out, MdClient.class,list);
        // 获取字节数据
        byte[] bytes = out.toByteArray();
        out.close();
        //构建相应头
        HttpHeaders headers = new HttpHeaders();
        String filename ="clients-"+ DateTime.now().toString("yyyyMMddHHmmss")+".xlsx";
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
    private MdClient initMdClient(){
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
        easyExcelComponent.export("客户列表", out, MdClient.class,mdClients);
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

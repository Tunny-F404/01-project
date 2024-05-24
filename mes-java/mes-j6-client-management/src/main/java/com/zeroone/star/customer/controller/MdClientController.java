package com.zeroone.star.customer.controller;

import com.zeroone.star.customer.service.IMdClientService;
import com.zeroone.star.project.dto.PageDTO;
import com.zeroone.star.project.j6.customer.ClientApis;
import com.zeroone.star.project.j6.customer.dto.ClientDTO;
import com.zeroone.star.project.j6.customer.query.ClientExportQuery;
import com.zeroone.star.project.j6.customer.query.ClientQuery;
import com.zeroone.star.project.vo.JsonVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/md-client")
@Api(tags = "客户管理")
@Validated
public class MdClientController implements ClientApis {
    @Resource
    IMdClientService clientService;


    @ApiOperation(value = "新增客户")
    @PostMapping("/add")
    @Override
    public JsonVO<String> addClient(@RequestBody ClientDTO client) {
        return null;
    }

    @ApiOperation("删除客户")
    @DeleteMapping
    @Override
    public JsonVO<String> deleteClient(@RequestBody List<Long> ids) {
        return null;
    }

    @ApiOperation("更新客户")
    @PutMapping
    @Override
    public JsonVO<String> updateClient(@RequestBody ClientDTO client) {
        return null;
    }

    @ApiOperation("查询客户列表")
    @GetMapping("/all")
    @Override
    public JsonVO<PageDTO<ClientDTO>> queryAll(@RequestBody ClientQuery query) {
        return JsonVO.success(clientService.listAll(query));
    }

    @ApiOperation("根据ID查询客户")
    @GetMapping("/{id}")
    @Override
    public JsonVO<ClientDTO> queryById(@PathVariable Long id) {
        return JsonVO.success(clientService.getById(id));
    }


    @GetMapping("/export/queryClientExport")
    @ApiOperation(value = "导出客户")
    @ResponseBody
    public ResponseEntity<byte[]> queryClientExportByExcel(
            @RequestParam(required = false) List<Long> clientId,
            @RequestParam(required = false) String customerCode,
            @RequestParam(required = false) String customerEnglishName,
            @RequestParam(required = false) String customerName,
            @RequestParam(required = false) String customerSimpleName,
            @RequestParam(required = false) Integer status // 使用Optional<Integer>作为status的类型
    ) {
        // 构造 ClientExportQuery 对象

        ClientExportQuery clientExportQuery = new ClientExportQuery();

        clientExportQuery.setCustomerCode(customerCode);
        clientExportQuery.setCustomerEnglishName(customerEnglishName);
        clientExportQuery.setCustomerName(customerName);
        clientExportQuery.setCustomerSimpleName(customerSimpleName);
        if (clientId != null && !clientId.isEmpty())
            clientExportQuery.setClientId(clientId);

        if (status != null)
            clientExportQuery.setStatus(status); // 如果status为空，则设置为null

        return queryClientExportByExcel(clientExportQuery);
    }


    public ResponseEntity<byte[]> queryClientExportByExcel(ClientExportQuery clientExportQuery) {
        return clientService.queryClientExportByExcel(clientExportQuery);
    }


    @GetMapping("/import/importTemplate")
    @ApiOperation(value = "下载导入客户的模板")
    @ResponseBody
    @Override
    public ResponseEntity<byte[]> DownloadTemplate() {
        return clientService.DownloadTemplate();
    }

    @PostMapping("/import/importClient")
    @ApiOperation(value = "导入客户")
    @ResponseBody
    @Override
    public JsonVO<String> importClientByExcel(MultipartFile customer) {
        return clientService.importClientByExcel(customer);
    }

}

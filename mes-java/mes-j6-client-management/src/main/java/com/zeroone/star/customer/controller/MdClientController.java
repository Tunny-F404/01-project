package com.zeroone.star.customer.controller;

import com.zeroone.star.customer.service.IMdClientService;
import com.zeroone.star.project.dto.PageDTO;
import com.zeroone.star.project.j6.customer.ClientApis;
import com.zeroone.star.project.j6.customer.dto.ClientDTO;
import com.zeroone.star.project.j6.customer.dto.ClientUpdateDTO;
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
@RequestMapping("md-clients")
@Api(tags = "客户管理")
@Validated
public class MdClientController implements ClientApis {
    @Resource
    IMdClientService clientService;

    @ApiOperation(value = "新增客户")
    @PostMapping("add-client")
    @Override
    public JsonVO<String> addClient(@RequestBody ClientDTO client) {
        boolean isAdded = clientService.addClient(client);
        if (isAdded) {
            return JsonVO.success(null);
        }
        return JsonVO.fail(null);
    }

    @ApiOperation("删除客户")
    @DeleteMapping("delete-clients")
    @Override
    public JsonVO<String> deleteClient(@RequestBody List<Long> ids) {
        boolean isDeleted = clientService.deleteClient(ids);
        if (isDeleted) {
            return JsonVO.success(null);
        }
        return JsonVO.fail(null);
    }

    @ApiOperation("更新客户")
    @PutMapping("update-client")
    @Override
    public JsonVO<String> updateClient(@RequestBody ClientUpdateDTO client) {
        boolean isUpdated = clientService.updateClient(client);
        if (isUpdated) {
            return JsonVO.success(null);
        }
        return JsonVO.fail(null);
    }

    @ApiOperation("查询客户列表")
    @PostMapping("query-all")
    @Override
    public JsonVO<PageDTO<ClientDTO>> queryAll(@RequestBody ClientQuery query) {
        PageDTO<ClientDTO> clients = clientService.listAll(query);
        return JsonVO.success(clients);
    }

    @ApiOperation("根据ID查询客户")
    @GetMapping("query-one/{id}")
    @Override
    public JsonVO<ClientDTO> queryById(@PathVariable Long id) {
        ClientDTO client = clientService.getById(id);
        return JsonVO.success(client);
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

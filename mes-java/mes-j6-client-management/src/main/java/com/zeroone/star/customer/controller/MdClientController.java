package com.zeroone.star.customer.controller;

import com.zeroone.star.customer.service.IMdClientService;
import com.zeroone.star.project.dto.PageDTO;
import com.zeroone.star.project.j6.customer.ClientApis;
import com.zeroone.star.project.j6.customer.dto.ClientDTO;
import com.zeroone.star.project.j6.customer.query.ClientQuery;
import com.zeroone.star.project.j6.customer.query.ClientExportQuery;
import com.zeroone.star.project.vo.JsonVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Controller
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





    @PostMapping(value = "/export/queryClientExport",produces = "application/octet-stream")
    @ResponseBody
    @ApiOperation(value = "导出客户")
    public ResponseEntity<byte[]> queryClientExportByExcel( ClientExportQuery clientExportQuery) {
        return clientService.queryClientExportByExcel(clientExportQuery);
    }

    @PostMapping(value = "/import/importTemplate", produces = "application/octet-stream")
    @ApiOperation(value = "下载导入客户模板")
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

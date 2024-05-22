package com.zeroone.star.customer.controller;

import com.zeroone.star.customer.service.IMdClientService;
import com.zeroone.star.project.dto.PageDTO;
import com.zeroone.star.project.j6.customer.ClientApis;
import com.zeroone.star.project.j6.customer.dto.ClientDTO;
import com.zeroone.star.project.j6.customer.dto.ResultDTO;
import com.zeroone.star.project.j6.customer.query.ClientQuery;
import com.zeroone.star.project.j6.customer.query.CustomExportQuery;
import com.zeroone.star.project.vo.JsonVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("query-queryCustomExport")
    @ApiOperation(value = "返回查询导出客户结果")
    @Override
    public JsonVO<ResultDTO> queryCustomExport(CustomExportQuery customExport) {
        return null;
    }

    @PostMapping("/add-customers")
    @ApiOperation(value = "添加客户")
    @Override
    public JsonVO<ResultDTO> addList(List customer) {
        return null;
    }

    @GetMapping("query-DownloadResult")
    @ApiOperation(value = "下载模板结果")
    @Override
    public JsonVO<ResultDTO> DownloadResult() {
        return null;
    }
}

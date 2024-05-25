package com.zeroone.star.customer.controller;

import com.zeroone.star.customer.service.IMdClientService;
import com.zeroone.star.project.dto.PageDTO;
import com.zeroone.star.project.j6.customer.ClientApis;
import com.zeroone.star.project.j6.customer.dto.ClientDTO;
import com.zeroone.star.project.j6.customer.dto.ClientUpdateDTO;
import com.zeroone.star.project.j6.customer.dto.ResultDTO;
import com.zeroone.star.project.j6.customer.query.ClientQuery;
import com.zeroone.star.project.j6.customer.query.CustomExportQuery;
import com.zeroone.star.project.vo.JsonVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
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
    public JsonVO<String> addClient(@Validated @RequestBody ClientDTO client) {
        boolean isAdded = clientService.addClient(client);
        if (isAdded) {
            return JsonVO.success(null);
        }
        return JsonVO.fail(null);
    }

    @ApiOperation("删除客户")
    @DeleteMapping("delete-clients")
    @Override
    public JsonVO<String> deleteClient(@NotEmpty @RequestBody List<Long> ids) {
        boolean isDeleted = clientService.deleteClient(ids);
        if (isDeleted) {
            return JsonVO.success(null);
        }
        return JsonVO.fail(null);
    }

    @ApiOperation("更新客户")
    @PutMapping("update-client/{id}")
    @Override
    public JsonVO<String> updateClient(@PathVariable Long id, @Validated @RequestBody ClientUpdateDTO client) {
        client.setClientId(id);
        boolean isUpdated = clientService.updateClient(client);
        if (isUpdated) {
            return JsonVO.success(null);
        }
        return JsonVO.fail(null);
    }

    @ApiOperation("查询客户列表")
    @GetMapping("query-all")
    @Override
    public JsonVO<PageDTO<ClientDTO>> queryAll(@RequestBody ClientQuery query) {
        PageDTO<ClientDTO> clients = clientService.listAll(query);
        if (clients == null) {
            return JsonVO.fail(null);
        }
        return JsonVO.success(clients);
    }

    @ApiOperation("根据ID查询客户")
    @GetMapping("query-one/{id}")
    @Override
    public JsonVO<ClientDTO> queryById(@Min(value = 1, message = "id的最小值为1") @PathVariable Long id) {
        ClientDTO client = clientService.getById(id);
        if (client == null) {
            return JsonVO.fail(null);
        }
        return JsonVO.success(client);
    }

    @GetMapping("query-queryCustomExport")
    @ApiOperation(value = "返回查询导出客户结果")
    @Override
    public JsonVO<ResultDTO> queryCustomExport(CustomExportQuery customExport) {
        return null;
    }

    @PostMapping("add-customers")
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

package com.zeroone.star.customer.controller;

import com.zeroone.star.customer.service.IMdClientService;
import com.zeroone.star.project.dto.PageDTO;
import com.zeroone.star.project.j6.customer.ClientApis;
import com.zeroone.star.project.j6.customer.dto.ClientDTO;
import com.zeroone.star.project.j6.customer.query.ClientQuery;
import com.zeroone.star.project.vo.JsonVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 客户表 前端控制器
 * </p>
 *
 * @author 小鱼
 * @since 2024-05-20
 */
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
}


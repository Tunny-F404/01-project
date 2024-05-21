package com.zeroone.star.customer.controller;


import com.zeroone.star.project.j6.customer.CustomerApis;
import com.zeroone.star.project.j6.customer.dto.ResultDTO;
import com.zeroone.star.project.j6.customer.query.CustomExportQuery;
import com.zeroone.star.project.vo.JsonVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 客户表 前端控制器
 * </p>
 *
 * @author 快乐小新
 * @since 2024-05-21
 */
@RestController
@RequestMapping("/customer/md-client")
@Api(tags = "客户导入导出相关接口")
public class MdClientController implements CustomerApis {
    @GetMapping("query-queryCustomExport")
    @ApiOperation(value = "返回查询导出客户结果")
    @Override
    public JsonVO<ResultDTO> queryCustomExport(CustomExportQuery customExport) {
        return null;
    }

    @PostMapping("/add-customers")
    @ApiOperation(value =  "添加客户")
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


package com.zeroone.star.sysmanagement.controller;

import cn.hutool.core.date.DateTime;

import com.zeroone.star.project.components.easyexcel.EasyExcelComponent;
import com.zeroone.star.project.dto.PageDTO;
import com.zeroone.star.project.j2.sysmanagement.param.ParameterApis;
import com.zeroone.star.project.j2.sysmanagement.dto.param.ParameterDTO;
import com.zeroone.star.project.j2.sysmanagement.query.param.ParameterQuery;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.ResultStatus;
import com.zeroone.star.sysmanagement.service.ISysConfigService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.SneakyThrows;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 40斤、kino
 * @version 1.0.0
 * @Description: 配置控制器
 */

@RestController
@RequestMapping("param")
@Api(tags = "参数配置控制器")
public class ParameterController implements ParameterApis {

    @Resource
    private ISysConfigService sysConfigService;



    @Override
    @DeleteMapping("remove-parameter/{ids}")
    @ApiOperation("删除参数")
    public JsonVO<ResultStatus> removeParameterList(@PathVariable List<Integer> ids) {
        sysConfigService.removeParameterList(ids);
        return JsonVO.success(ResultStatus.SUCCESS);
    }

    @GetMapping("refreshCache")
    @ApiOperation("刷新参数")
    @Override
    public JsonVO<ResultStatus> refreshCache() {
        sysConfigService.refreshCache();
        return JsonVO.success(ResultStatus.SUCCESS);
    }

    @GetMapping(value = "export-Parameter",produces = "application/octet-stream")
    @ApiOperation("导出配置excel")
    @SneakyThrows
    @Override
    public ResponseEntity<byte[]> exportParameter() {
        return sysConfigService.exportParameter();
    }


    @Override
    @PostMapping("add")
    @ApiOperation("添加参数")
    public JsonVO<ParameterDTO> addParam(@RequestBody ParameterDTO parameterDTO){
        return JsonVO.success(parameterDTO);
    }

    @Override
    @DeleteMapping("/delete/id={id}")
    @ApiOperation("删除参数")
    public JsonVO<Integer> deleteById(@PathVariable("id") Integer id) {
        return JsonVO.success(1);
    }

    @Override
    @GetMapping("query-all")
    @ApiOperation("查询所有参数")
    public JsonVO<PageDTO<ParameterDTO>> queryAll(ParameterQuery parameterQuery) {
        PageDTO<ParameterDTO> pageDTO = new PageDTO<ParameterDTO>();
        return JsonVO.success(pageDTO);
    }
}

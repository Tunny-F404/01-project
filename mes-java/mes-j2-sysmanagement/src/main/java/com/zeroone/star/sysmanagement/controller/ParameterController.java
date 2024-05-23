package com.zeroone.star.sysmanagement.controller;

import cn.hutool.core.date.DateTime;

import com.zeroone.star.project.components.easyexcel.EasyExcelComponent;
import com.zeroone.star.project.dto.PageDTO;
import com.zeroone.star.project.j2.sysmanagement.param.ParameterApis;
import com.zeroone.star.project.j2.sysmanagement.dto.param.ParameterDTO;
import com.zeroone.star.project.j2.sysmanagement.query.param.ParameterQuery;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.sysmanagement.service.ParameterService;
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

    // 导入easyExcel组件
    @Resource
    EasyExcelComponent excelComponent;

    @Resource
    ParameterService service;

    @Override
    @DeleteMapping("remove-parameter")
    @ApiOperation("删除参数")
    public JsonVO<Integer> removeParameter(@RequestParam(name = "ids", required = true) List<Integer> ids) {
        return JsonVO.success(service.removeParameters(ids));
    }

    @GetMapping("query-parameter")
    @ApiOperation("刷新参数")
    @Override
    public JsonVO<List<ParameterDTO>> queryParameter() {
        //模拟一份配置数据
        ArrayList<ParameterDTO> configs = new ArrayList<>();
        ParameterDTO parameterDTO = new ParameterDTO();
        parameterDTO.setConfigId(1);
        parameterDTO.setConfigKey("sys.index.skinName");
        parameterDTO.setConfigName("主框架页-默认皮肤样式名称");
        parameterDTO.setConfigType("Y");
        parameterDTO.setUpdateBy("admin");
        parameterDTO.setUpdateTime(DateTime.now());
        parameterDTO.setConfigValue("skin-red");
        parameterDTO.setCreateBy("admin");
        parameterDTO.setCreateTime(DateTime.now());
        parameterDTO.setRemark("深色主题theme-dark，浅色主题theme-light");
        configs.add(parameterDTO);
        //直接返回
        return JsonVO.success(configs);
    }

    @GetMapping(value = "export-Parameter",produces = "application/octet-stream")
    @ApiOperation("导出配置excel")
    @SneakyThrows
    @Override
    public ResponseEntity<byte[]> exportParameter() {
        //模拟一份配置数据
        ArrayList<ParameterDTO> Parameters = new ArrayList<>();
        ParameterDTO parameterDTO = new ParameterDTO();
        parameterDTO.setConfigId(1);
        parameterDTO.setConfigKey("sys.index.skinName");
        parameterDTO.setConfigName("主框架页-默认皮肤样式名称");
        parameterDTO.setConfigType("Y");
        parameterDTO.setUpdateBy("admin");
        parameterDTO.setUpdateTime(DateTime.now());
        parameterDTO.setConfigValue("skin-red");
        parameterDTO.setCreateBy("admin");
        parameterDTO.setCreateTime(DateTime.now());
        parameterDTO.setRemark("深色主题theme-dark，浅色主题theme-light");
        Parameters.add(parameterDTO);
        //构建输出流
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        excelComponent.export("配置导出",out, ParameterDTO.class,Parameters);
        //响应文件给客户端
        byte[] bytes = out.toByteArray();
        out.close();
        //构建响应头
        HttpHeaders headers = new HttpHeaders();
        String filename="report-"+ DateTime.now().toString("yyyyMMddHHmmssS")+".xlsx";
        headers.setContentDispositionFormData("attachment",filename);
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return new ResponseEntity<>(bytes,headers, HttpStatus.CREATED);
    }


    @Override
    @PostMapping("add")
    @ApiOperation("添加参数")
    public JsonVO<Integer> addParam(@RequestBody ParameterDTO parameterDTO){
        return JsonVO.success(service.saveParameter(parameterDTO));
    }



    @Override
    @GetMapping("query-all")
    @ApiOperation("查询所有参数")
    public JsonVO<PageDTO<ParameterDTO>> queryAll(ParameterQuery parameterQuery) {

        return JsonVO.success(service.listAll(parameterQuery));
    }
}

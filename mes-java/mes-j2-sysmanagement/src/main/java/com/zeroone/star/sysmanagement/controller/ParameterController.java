package com.zeroone.star.sysmanagement.controller;

import cn.hutool.core.date.DateTime;
import com.zeroone.star.project.components.easyexcel.EasyExcelComponent;
import com.zeroone.star.project.j2.sysmanagent.ParameterApis;
import com.zeroone.star.project.j2.sysmanagent.dto.ParameterDTO;
import com.zeroone.star.project.vo.JsonVO;
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
 * @author 40斤
 * @version 1.0.0
 * @Description: 配置控制器
 */
@RestController
@RequestMapping("Parameter")
@Api(tags = "配置控制器")
public class ParameterController implements ParameterApis {

    // 导入easyExcel组件
    @Resource
    EasyExcelComponent excelComponent;

    @Override
    @DeleteMapping("remove-parameter/{ids}")
    @ApiOperation("删除参数")
    public JsonVO<Integer> removeParameter(@PathVariable List<Integer> ids) {
        return JsonVO.success(1);
    }

    @GetMapping("query-parameter")
    @ApiOperation("刷新参数")
    @Override
    public JsonVO<List<ParameterDTO>> queryParameter() {
        //模拟一份配置数据
        ArrayList<ParameterDTO> configs = new ArrayList<>();
        ParameterDTO parameterDTO = new ParameterDTO();
        parameterDTO.setId(1);
        parameterDTO.setKey("sys.index.skinName");
        parameterDTO.setName("主框架页-默认皮肤样式名称");
        parameterDTO.setType("Y");
        parameterDTO.setUpdateBy("admin");
        parameterDTO.setUpdateTime(DateTime.now());
        parameterDTO.setValue("skin-red");
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
        parameterDTO.setId(1);
        parameterDTO.setKey("sys.index.skinName");
        parameterDTO.setName("主框架页-默认皮肤样式名称");
        parameterDTO.setType("Y");
        parameterDTO.setUpdateBy("admin");
        parameterDTO.setUpdateTime(DateTime.now());
        parameterDTO.setValue("skin-red");
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
}

package com.zeroone.star.sysmanagement.controller;


import com.zeroone.star.project.j2.sysmanagent.ParameterApis;
import com.zeroone.star.project.j2.sysmanagent.dto.PageDTO;
import com.zeroone.star.project.j2.sysmanagent.dto.ParameterDTO;
import com.zeroone.star.project.j2.sysmanagent.query.ParameterQuery;
import com.zeroone.star.project.vo.JsonVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * @author kino
 * @version 1.0.0
 * @Description: 参数设置控制器
 */
@RestController
@RequestMapping("param")
@Api(tags = "参数设置控制器")
public class ParameterController implements ParameterApis {

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

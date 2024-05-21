package com.zeroone.star.sysmanager.controller;

import com.zeroone.star.project.j3.dto.InsertDictTypeDTO;
import com.zeroone.star.project.j3.sysmanager.DictionaryManageApis;
import com.zeroone.star.project.j3.vo.DictDataNameVO;
import com.zeroone.star.project.j3.vo.DictTypeNameVO;
import com.zeroone.star.project.vo.JsonVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.util.List;

@RestController
@RequestMapping("sys-manager/dictionary-manager")
@Api(tags = "字典管理")
@Validated
public class DictionaryManageController implements DictionaryManageApis {


    @ApiOperation(value = "新增字典类别")
    @PostMapping("add-dictType")
    @Override
    public JsonVO<Long> addDictType(@RequestBody InsertDictTypeDTO dto) {
        return null;
    }

    @ApiOperation(value = "根据字典类型获取字典数据名称列表")
    @GetMapping("query-dictDateNames-by-dictType")
    @Override
    public JsonVO<List<DictDataNameVO>> queryDictDataNamesByDictType(@NotBlank(message = "字典类型不能为空") String dictType) {
        return null;
    }

    @ApiOperation(value = "获取字典名称列表")
    @GetMapping("query-dictTypeNames")
    @Override
    public JsonVO<List<DictTypeNameVO>> queryDictTypeNames() {
        return null;
    }
}

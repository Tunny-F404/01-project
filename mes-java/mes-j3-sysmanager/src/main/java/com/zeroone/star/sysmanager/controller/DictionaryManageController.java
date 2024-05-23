package com.zeroone.star.sysmanager.controller;

import com.zeroone.star.project.j3.dto.InsertDictTypeDTO;
import com.zeroone.star.project.j3.dto.SysDictDataDTO;
import com.zeroone.star.project.j3.sysmanager.DictionaryManageApis;
import com.zeroone.star.project.j3.vo.DictDataNameVO;
import com.zeroone.star.project.j3.vo.DictTypeNameVO;
import com.zeroone.star.project.vo.JsonVO;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.zeroone.star.project.vo.JsonVO;
import io.swagger.annotations.ApiOperation;
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

    @Override
    @ApiOperation(value = "新增字典数据接口")
    @PostMapping("add-dict-data")
    public JsonVO<Integer> addDictData(@RequestBody SysDictDataDTO sysDictDataDTO) {
        return null;
    }

    @Override
    @ApiOperation(value = "修改字典数据接口")
    @PutMapping("modify-dict-data")
    public JsonVO<Integer> modifyDictData(@RequestBody SysDictDataDTO sysDictDataDTO) {
        return null;
    }

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

    @Override
    @ApiOperation(value = "删除字典数据接口")
    @DeleteMapping("remove-dict-data/{dictCodes}")
    public JsonVO<Void> removeDictData(@PathVariable Long[] dictCodes) {
        return null;
    }
}


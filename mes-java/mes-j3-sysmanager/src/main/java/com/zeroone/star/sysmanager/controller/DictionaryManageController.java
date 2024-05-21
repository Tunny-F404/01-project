package com.zeroone.star.sysmanager.controller;

import com.zeroone.star.project.j3.dto.SysDictDataDTO;
import com.zeroone.star.project.j3.sysmanager.DictionaryManageApis;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.zeroone.star.project.vo.JsonVO;
import io.swagger.annotations.ApiOperation;

@Api(tags = "字典管理")
@Controller
@RequestMapping("sys-manager/dictionary-manager")
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

    @Override
    @ApiOperation(value = "删除字典数据接口")
    @DeleteMapping("remove-dict-data/{dictCodes}")
    public JsonVO<Void> removeDictData(@PathVariable Long[] dictCodes) {
        return null;
    }
}


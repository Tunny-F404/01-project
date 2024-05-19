package com.zeroone.star.sysmanager.controller;

import com.zeroone.star.project.j3.dto.SysDictDataDTO;
import com.zeroone.star.project.j3.sysmanager.DictionaryManageApis;
import com.zeroone.star.project.vo.JsonVO;
import io.swagger.annotations.ApiOperation;

public class DictionaryManageController implements DictionaryManageApis {

    @Override
    @ApiOperation(value = "新增字典数据接口")
    public JsonVO<Integer> addDictData(SysDictDataDTO sysDictDataDTO) {
        return null;
    }

    @Override
    @ApiOperation(value = "修改字典数据接口")
    public JsonVO<Integer> modifyDictData(SysDictDataDTO sysDictDataDTO) {
        return null;
    }

    @ApiOperation(value = "删除字典数据接口")
    @Override
    public JsonVO<Void> removeDictData(Long[] dictCodes) {
        return null;
    }
}


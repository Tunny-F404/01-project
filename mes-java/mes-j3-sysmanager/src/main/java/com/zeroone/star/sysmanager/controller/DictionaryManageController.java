package com.zeroone.star.sysmanager.controller;

import com.zeroone.star.project.j3.sysmanager.DictionaryManageApis;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.zeroone.star.project.query.dict.SysDictTypeQuery;
import com.zeroone.star.project.vo.JsonVO;

import java.util.List;

@Api(tags = "字典管理")
@Controller
@RequestMapping("/dict")
public class DictionaryManageController implements DictionaryManageApis {
    @Override
    @ApiOperation(value = "编辑修改字典")
    @PutMapping("edit-dict-type")
    public JsonVO<Void> editDictType(@RequestBody SysDictTypeQuery sysDictTypeQuery) {
        return null;
    }

    @Override
    @ApiOperation(value = "(批量)删除字典")
    @DeleteMapping("delete-dict-type")
    public JsonVO<Void> deleteDictType(@PathVariable String dictListIdsStr) {
        return null;
    }

    @Override
    @ApiOperation(value = "导出字典成excel")
    @PostMapping("export-dict-type")
    public JsonVO<Void> exportDictType(@RequestBody SysDictTypeQuery sysDictTypeQuery) {
        return null;
    }

    @Override
    @ApiOperation(value = "刷新字典缓存")
    @DeleteMapping("refresh-cache")
    public JsonVO<Void> refreshCache() {
        return null;
    }
}

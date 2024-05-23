package com.zeroone.star.sysmanager.controller;

import com.zeroone.star.project.j3.dto.dict.SysDictDataDTO;
import com.zeroone.star.project.j3.dto.dict.SysDictTypeDTO;
import com.zeroone.star.project.j3.query.dict.SysDictDataQuery;
import com.zeroone.star.project.j3.query.dict.SysDictTypeQuery;
import com.zeroone.star.project.j3.sysmanager.DictionaryManageApis;
import com.zeroone.star.project.j3.vo.SysDictDataVO;
import com.zeroone.star.project.j3.vo.SysDictTypeVO;
import com.zeroone.star.project.vo.JsonVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "字典管理")
@RestController
@RequestMapping("sys-manager/dictionary-manager")
public class DictionaryManageController implements DictionaryManageApis {

    @GetMapping("/type/list")
    @ApiOperation("获取字典类型列表")
    @Override
    public JsonVO<List<SysDictTypeVO>> listDictType(SysDictTypeQuery dictTypeQuery) {
        return null;
    }

    @GetMapping("/type/{dictId}")
    @ApiOperation("获取字典类型详情")
    @Override
    public JsonVO<SysDictTypeDTO> getDictType(@PathVariable Long dictId) {
        return null;
    }

    @PostMapping("/type/expert")
    @ApiOperation("导出字典类型列表（excel）")
    @Override
    public ResponseEntity<byte[]> exportDictType(@RequestBody SysDictTypeDTO sysDictTypeDTO) {
        return null;
    }

    @GetMapping("/data/list")
    @ApiOperation("获取字典数据列表")
    @Override
    public JsonVO<List<SysDictDataVO>> listDictData(SysDictDataQuery dictDataQuery) {
        return null;
    }

    @GetMapping("/type/{dictCode}")
    @ApiOperation("获取字典数据详情")
    @Override
    public JsonVO<SysDictDataDTO> getDictData(@PathVariable Long dictCode) {
        return null;
    }
}

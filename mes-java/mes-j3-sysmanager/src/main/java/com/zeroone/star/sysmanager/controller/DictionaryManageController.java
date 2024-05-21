package com.zeroone.star.sysmanager.controller;

import com.zeroone.star.project.j3.dto.dict.SysDictDataDTO;
import com.zeroone.star.project.j3.dto.dict.SysDictTypeDTO;
import com.zeroone.star.project.j3.query.dict.SysDictDataQuery;
import com.zeroone.star.project.j3.query.dict.SysDictTypeQuery;
import com.zeroone.star.project.j3.sysmanager.DictionaryManageApis;
import com.zeroone.star.project.vo.JsonVO;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "字典管理")
@RestController
@RequestMapping("sys-manager/dictionary-manager")
public class DictionaryManageController implements DictionaryManageApis {

    @GetMapping("/type/list")
    @Override
    public JsonVO<List<SysDictTypeDTO>> listDictType(SysDictTypeQuery dictTypeQuery) {
        return null;
    }

    @GetMapping("/type/{dictId}")
    @Override
    public JsonVO<SysDictTypeDTO> getDictType(@PathVariable Long dictId) {
        return null;
    }

    @PostMapping("/type/expert")
    @Override
    public ResponseEntity<byte[]> exportDictType(@RequestBody SysDictTypeDTO sysDictTypeDTO) {
        return null;
    }

    @GetMapping("/data/list")
    @Override
    public JsonVO<List<SysDictDataDTO>> listDictData(SysDictDataQuery dictDataQuery) {
        return null;
    }

    @GetMapping("/type/{dictCode}")
    @Override
    public JsonVO<SysDictDataDTO> getDictData(@PathVariable Long dictCode) {
        return null;
    }
}

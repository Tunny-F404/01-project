package com.zeroone.star.sysmanager.controller;

import com.zeroone.star.project.dto.PageDTO;
import com.zeroone.star.project.j3.dto.InsertDictTypeDTO;
import com.zeroone.star.project.j3.dto.SysDictDataDTO;
import com.zeroone.star.project.j3.dto.dict.*;
import com.zeroone.star.project.j3.query.dict.SysDictDataQuery;
import com.zeroone.star.project.j3.query.dict.SysDictTypeModifyQuery;
import com.zeroone.star.project.j3.query.dict.SysDictTypeQuery;
import com.zeroone.star.project.j3.sysmanager.DictionaryManageApis;
import com.zeroone.star.project.j3.vo.DictDataNameVO;
import com.zeroone.star.project.j3.vo.DictTypeNameVO;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.sysmanager.service.ISysDictDataService;
import com.zeroone.star.sysmanager.service.ISysDictTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("sys-manager/dictionary-manager")
@Api(tags = "字典管理")
@Validated
public class DictionaryManageController implements DictionaryManageApis {

    @Resource
    private ISysDictDataService sysDictDataService;

    @Resource
    private ISysDictTypeService sysDictTypeService;


    @Override
    @ApiOperation(value = "编辑修改字典")
    @PutMapping("modify/update/upate/edit-dict-type")
    public JsonVO<Void> editDictType(@RequestBody SysDictTypeModifyQuery sysDictTypeModifyQuery) {
        return null;
    }

    @Override
    @ApiOperation(value = "(批量)删除字典")
    @DeleteMapping("remove/remove/delete/delete-dict-type/{dictListIds}")
    public JsonVO<Void> deleteDictType(@PathVariable Long[] dictListIds) {
        return null;
    }

    @GetMapping("/type/list")
    @ApiOperation("获取字典类型列表")
    @Override
    public JsonVO<PageDTO<SysDictTypeListDTO>> listDictType(@Valid SysDictTypeQuery dictTypeQuery) {
        return sysDictTypeService.listDictType(dictTypeQuery);
    }

    @GetMapping("/type/{dictId}")
    @ApiOperation("获取字典类型详情")
    @Override
    public JsonVO<SysDictTypeDetailDTO> getDictType(@PathVariable
                                                    @NotNull(message = "不能为空")
                                                    Long dictId) {
        return sysDictTypeService.getDictType(dictId);
    }

    @PostMapping("/data/export")
    @ApiOperation("导出字典数据列表（excel）")
    @Override
    public ResponseEntity<byte[]> exportDictData(@RequestBody
                                                 @Valid
                                                 SysDictDataExportDTO sysDictDataExportDTO) {
        return sysDictDataService.exportDictData(sysDictDataExportDTO);
    }

    @GetMapping("/data/list")
    @ApiOperation("获取字典数据列表")
    @Override
    public JsonVO<PageDTO<SysDictDataListDTO>> listDictData(@Valid SysDictDataQuery dictDataQuery) {
        return sysDictDataService.listDictData(dictDataQuery);
    }

    @GetMapping("/data/{dictCode}")
    @ApiOperation("获取字典数据详情")
    @Override
    public JsonVO<SysDictDataDetailDTO> getDictData(@PathVariable
                                                    @NotNull(message = "不能为空")
                                                    Long dictCode) {
        return sysDictDataService.getDictData(dictCode);
    }

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

    @Override
    @ApiOperation(value = "删除字典数据接口")
    @DeleteMapping("remove-dict-data/{dictCodes}")
    public JsonVO<Void> removeDictData(@PathVariable Long[] dictCodes) {
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

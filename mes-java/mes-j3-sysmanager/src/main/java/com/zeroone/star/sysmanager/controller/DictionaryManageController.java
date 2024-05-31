package com.zeroone.star.sysmanager.controller;

import cn.hutool.core.date.DateTime;
import com.zeroone.star.project.j3.dto.InsertDictTypeDTO;
import com.zeroone.star.project.j3.dto.SysDictDataDTO;
import com.zeroone.star.project.j3.dto.dict.*;
import com.zeroone.star.project.j3.query.dict.SysDictDataQuery;
import com.zeroone.star.project.j3.query.dict.SysDictTypeQuery;
import com.zeroone.star.project.j3.query.dict.SysDictTypeModifyQuery;
import com.zeroone.star.project.j3.sysmanager.DictionaryManageApis;
import com.zeroone.star.project.j3.vo.DictDataNameVO;
import com.zeroone.star.project.j3.vo.DictTypeNameVO;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.sysmanager.service.ISysDictTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.http.ResponseEntity;
import java.util.List;
import javax.validation.constraints.NotBlank;

@RestController
@RequestMapping("sys-manager/dictionary-manager")
@Api(tags = "字典管理")
@Validated
public class DictionaryManageController implements DictionaryManageApis {

    @Autowired
    ISysDictTypeService sysDictTypeService;

    @Override
    @ApiOperation(value = "编辑修改字典")
    @PutMapping("modify/update/upate/edit-dict-type")
    public JsonVO<Integer> editDictType(@RequestBody SysDictTypeModifyQuery sysDictTypeModifyQuery) {
        return sysDictTypeService.editDictType(sysDictTypeModifyQuery);
    }

    @Override
    @ApiOperation(value = "(批量)删除字典")
    @DeleteMapping("remove/remove/delete/delete-dict-type/{dictListIds}")
    public JsonVO<Integer> deleteDictType(@PathVariable Long[] dictListIds) {
        return sysDictTypeService.deleteDictType(dictListIds);
    }

    @GetMapping("/type/list")
    @ApiOperation("获取字典类型列表")
    @Override
    public JsonVO<List<SysDictTypeListDTO>> listDictType(SysDictTypeQuery dictTypeQuery) {
        return null;
    }

    @GetMapping("/type/{dictId}")
    @ApiOperation("获取字典类型详情")
    @Override
    public JsonVO<SysDictTypeDetailDTO> getDictType(@PathVariable Long dictId) {
        return null;
    }

    @PostMapping("/type/expert")
    @ApiOperation("导出字典类型列表（excel）")
    @Override
    public ResponseEntity<byte[]> exportDictType(@RequestBody SysDictTypeExportDTO sysDictTypeExportDTO) {
        return null;
    }

    @GetMapping("/data/list")
    @ApiOperation("获取字典数据列表")
    @Override
    public JsonVO<List<SysDictDataListDTO>> listDictData(SysDictDataQuery dictDataQuery) {
        return null;
    }

    @GetMapping("/type/{dictCode}")
    @ApiOperation("获取字典数据详情")
    @Override
    public JsonVO<SysDictDataDetailDTO> getDictData(@PathVariable Long dictCode) {
        return null;
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
    public JsonVO<List<DictDataNameVO>> queryDictDataNamesByDictType(String dictType) {
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
    public ResponseEntity<byte[]> exportDictType(@RequestBody SysDictTypeQuery sysDictTypeQuery) {
        // 构建响应头
        HttpHeaders headers = new HttpHeaders();
        String filename = "report-" + DateTime.now().toString("yyyyMMddHHmmssS") + ".xlsx";
        headers.setContentDispositionFormData("attachment", filename);
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        // 响应文件给客户端
        byte[] bytes = sysDictTypeService.exportDictType(sysDictTypeQuery);
        return new ResponseEntity<>(bytes, headers, HttpStatus.CREATED);
    }

    @Override
    @ApiOperation(value = "刷新字典缓存")
    @DeleteMapping("refresh-cache")
    public JsonVO<Void> refreshCache() {
        return JsonVO.success(sysDictTypeService.refreshCache());
    }
}

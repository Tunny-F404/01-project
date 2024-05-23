package com.zeroone.star.project.j3.sysmanager;


import com.zeroone.star.project.j3.dto.InsertDictTypeDTO;
import com.zeroone.star.project.j3.vo.DictDataNameVO;
import com.zeroone.star.project.j3.vo.DictTypeNameVO;
import com.zeroone.star.project.vo.JsonVO;

import java.util.List;

import com.zeroone.star.project.j3.dto.SysDictDataDTO;
import com.zeroone.star.project.vo.JsonVO;

import com.zeroone.star.project.j3.dto.dict.*;
import com.zeroone.star.project.j3.query.dict.SysDictDataQuery;
import com.zeroone.star.project.j3.query.dict.SysDictTypeQuery;
import com.zeroone.star.project.vo.JsonVO;
import org.springframework.http.ResponseEntity;

import java.util.List;

import com.zeroone.star.project.j3.query.dict.SysDictTypeModifyQuery;
import com.zeroone.star.project.j3.query.dict.SysDictTypeQuery;
import com.zeroone.star.project.vo.JsonVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * 系统管理-字典管理相关接口
 */
public interface DictionaryManageApis {
    /**
     *   修改字典
     */
    JsonVO<Void> editDictType(SysDictTypeModifyQuery sysDictTypeModifyQuery);

    /**
     *  批量删除字典
     */
    JsonVO<Void> deleteDictType(Long[] dictListIds);
    /**
     *  导出字典
     */
    JsonVO<Void> exportDictType(SysDictTypeQuery sysDictTypeQuery);
    /**
     *  刷新字典缓存
     */
    JsonVO<Void> refreshCache();

    /**
     * 新增字典(dict_type)
     * @param dto 新增数据
     * @return 新增数据的唯一编号
     */
    JsonVO<Long> addDictType(InsertDictTypeDTO dto);

    /**
     * 根据给定的字典类型获取对应的字典数据名称列表
     * @param dictType 字典类型, 例如sys_user_sex
     * @return 对应的字典数据名称列表
     */
    JsonVO<List<DictDataNameVO>> queryDictDataNamesByDictType(String dictType);

    /**
     * 获取字典名称列表
     * @return 字典名称列表
     */
    JsonVO<List<DictTypeNameVO>> queryDictTypeNames();

    /**
     * 新增字典数据接口
     */
    JsonVO<Integer> addDictData(SysDictDataDTO sysDictDataDTO);

    /**
     * 修改字典数据接口
     */
    JsonVO<Integer> modifyDictData(SysDictDataDTO sysDictDataDTO);

    /**
     * 删除字典数据接口
     */
    JsonVO<Void> removeDictData(Long[] dictCodes);

    /**
     * 字典类型接口
     */
    // 查询字典类型列表
    public JsonVO<List<SysDictTypeListDTO>> listDictType(SysDictTypeQuery dictTypeQuery);

    // 查询字典类型详情
    public JsonVO<SysDictTypeDetailDTO> getDictType(Long dictId);

    public ResponseEntity<byte[]> exportDictType(SysDictTypeExportDTO sysDictTypeExportDTO);


    /**
     *  字典数据接口
     */
    // 查询字典数据列表
    public JsonVO<List<SysDictDataListDTO>> listDictData(SysDictDataQuery dictDataQuery);

    // 查询字典数据详情
    public JsonVO<SysDictDataDetailDTO> getDictData(Long dictCode);
}

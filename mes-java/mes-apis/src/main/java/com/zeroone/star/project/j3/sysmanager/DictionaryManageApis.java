package com.zeroone.star.project.j3.sysmanager;


import com.zeroone.star.project.j3.dto.dict.SysDictDataDTO;
import com.zeroone.star.project.j3.dto.dict.SysDictTypeDTO;
import com.zeroone.star.project.j3.query.dict.SysDictDataQuery;
import com.zeroone.star.project.j3.query.dict.SysDictTypeQuery;
import com.zeroone.star.project.vo.JsonVO;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * 系统管理-字典管理相关接口
 */
public interface DictionaryManageApis {

    /**
     * 字典类型接口
     */
    // 查询字典类型列表
    public JsonVO<List<SysDictTypeDTO>> listDictType(SysDictTypeQuery dictTypeQuery);

    // 查询字典类型详情
    public JsonVO<SysDictTypeDTO> getDictType(Long dictId);

    public ResponseEntity<byte[]> exportDictType(SysDictTypeDTO sysDictTypeDTO);


    /**
     *  字典数据接口
     */
    // 查询字典数据列表
    public JsonVO<List<SysDictDataDTO>> listDictData(SysDictDataQuery dictDataQuery);

    // 查询字典数据详情
    public JsonVO<SysDictDataDTO> getDictData(Long dictCode);
}

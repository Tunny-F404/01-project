package com.zeroone.star.project.j3.sysmanager;


import com.zeroone.star.project.j3.dto.dict.SysDictDataDTO;
import com.zeroone.star.project.j3.dto.dict.SysDictTypeDTO;
import com.zeroone.star.project.j3.query.dict.SysDictDataQuery;
import com.zeroone.star.project.j3.query.dict.SysDictTypeQuery;
import com.zeroone.star.project.vo.JsonVO;

import java.util.List;

/**
 * 系统管理-字典管理相关接口
 */
public interface DictionaryManageApis {

    /**
     * 字典类型接口
     */
    JsonVO<List<SysDictTypeDTO>> listDictType(SysDictTypeQuery dictTypeQuery);

    JsonVO<SysDictTypeDTO> getDictType(Long dictId);

    void exportDictType(SysDictTypeQuery dictTypeQuery);


    /**
     *  字典数据接口
     */
    JsonVO<List<SysDictDataDTO>> listDictData(SysDictDataQuery dictDataQuery);

    JsonVO<SysDictDataDTO> getDictData(Long dictId);
}

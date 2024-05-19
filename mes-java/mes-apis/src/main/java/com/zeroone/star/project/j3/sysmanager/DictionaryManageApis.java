package com.zeroone.star.project.j3.sysmanager;


import com.zeroone.star.project.j3.dto.SysDictDataDTO;
import com.zeroone.star.project.vo.JsonVO;

/**
 * 系统管理-字典管理相关接口
 */
public interface DictionaryManageApis {
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
}

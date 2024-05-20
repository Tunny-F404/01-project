package com.zeroone.star.project.j3.sysmanager;


import com.zeroone.star.project.j3.dto.InsertDictTypeDTO;
import com.zeroone.star.project.j3.vo.DictDataNameVO;
import com.zeroone.star.project.j3.vo.DictTypeNameVO;
import com.zeroone.star.project.vo.JsonVO;

import java.util.List;

/**
 * 系统管理-字典管理相关接口
 */
public interface DictionaryManageApis {

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

}

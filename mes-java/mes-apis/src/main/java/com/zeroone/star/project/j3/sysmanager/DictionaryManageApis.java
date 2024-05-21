package com.zeroone.star.project.j3.sysmanager;


import com.zeroone.star.project.query.dict.SysDictTypeQuery;
import com.zeroone.star.project.vo.JsonVO;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * 系统管理-字典管理相关接口
 */
public interface DictionaryManageApis {
    /**
     *   修改字典
     */
    JsonVO<Void> editDictType(SysDictTypeQuery sysDictTypeQuery);
    /**
     *  批量删除字典
     */
    JsonVO<Void> deleteDictType(String dictListIdsStr);
    /**
     *  导出字典
     */
    JsonVO<Void> exportDictType(SysDictTypeQuery sysDictTypeQuery);
    /**
     *  刷新字典缓存
     */
    JsonVO<Void> refreshCache();
}

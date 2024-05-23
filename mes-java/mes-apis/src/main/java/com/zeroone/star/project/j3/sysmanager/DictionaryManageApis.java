package com.zeroone.star.project.j3.sysmanager;


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
    JsonVO<Void> deleteDictType(List<Long> dictListIds);
    /**
     *  导出字典
     */
    JsonVO<Void> exportDictType(SysDictTypeQuery sysDictTypeQuery);
    /**
     *  刷新字典缓存
     */
    JsonVO<Void> refreshCache();
}

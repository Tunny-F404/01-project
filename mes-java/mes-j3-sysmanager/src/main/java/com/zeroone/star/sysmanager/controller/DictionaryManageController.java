package com.zeroone.star.sysmanager.controller;

import com.zeroone.star.project.j3.sysmanager.DictionaryManageApis;
import com.zeroone.star.project.query.dict.SysDictTypeQuery;
import com.zeroone.star.project.vo.JsonVO;

public class DictionaryManageController implements DictionaryManageApis {
    @Override
    public JsonVO<Void> editDictType(SysDictTypeQuery sysDictTypeQuery) {
        return null;
    }

    @Override
    public JsonVO<Void> deleteDictType(SysDictTypeQuery sysDictTypeQuery) {
        return null;
    }

    @Override
    public JsonVO<Void> exportDictType(SysDictTypeQuery sysDictTypeQuery) {
        return null;
    }

    @Override
    public JsonVO<Void> refreshCache() {
        return null;
    }
}

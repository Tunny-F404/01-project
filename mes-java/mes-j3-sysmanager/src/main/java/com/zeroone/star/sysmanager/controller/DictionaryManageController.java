package com.zeroone.star.sysmanager.controller;

import com.zeroone.star.project.j3.sysmanager.DictionaryManageApis;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.zeroone.star.project.query.dict.SysDictTypeQuery;
import com.zeroone.star.project.vo.JsonVO;

@Api(tags = "字典管理")
@Controller
@RequestMapping("/dict")
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

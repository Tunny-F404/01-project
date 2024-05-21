package com.zeroone.star.sysmanager.controller;

import com.zeroone.star.project.j3.sysmanager.DictionaryManageApis;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Api(tags = "字典管理")
@Controller
@RequestMapping("sys-manager/dictionary-manager")
public class DictionaryManageController implements DictionaryManageApis {

}

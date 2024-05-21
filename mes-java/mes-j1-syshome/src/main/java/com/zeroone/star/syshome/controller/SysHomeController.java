package com.zeroone.star.syshome.controller;

import com.zeroone.star.project.j1.syshome.SysHomeApis;
import com.zeroone.star.project.j1.syshome.dto.PageDTO;
import com.zeroone.star.project.j1.syshome.dto.plan.PlanDTO;
import com.zeroone.star.project.j1.syshome.dto.toDoEvent.ToDoEventDTO;
import com.zeroone.star.project.j1.syshome.dto.workshop.WorkshopDTO;
import com.zeroone.star.project.j1.syshome.query.PageQuery;
import com.zeroone.star.project.vo.JsonVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 描述：TODO
 * </p>
 * @author 李兴昊
 * @version 1.0.0
 */
@RestController
@RequestMapping("syshome")
@Api(tags = "系统首页")
public class SysHomeController implements SysHomeApis {

    @GetMapping("query-workshop")
    @ApiOperation(value = "查询车间展示信息")
    @Override
    public JsonVO<List<WorkshopDTO>> queryWorkshopList() {
        return null;
    }

    @GetMapping("query-plan")
    @ApiOperation(value = "查询排班情况信息")
    @Override
    public JsonVO<PageDTO<PlanDTO>> queryPlan(PageQuery pageQuery) {
        return null;
    }

    @GetMapping("query-toDoEvent")
    @ApiOperation(value = "查询我的待办信息")
    @Override
    public JsonVO<PageDTO<ToDoEventDTO>> queryToDoEvent(PageQuery pageQuery) {
        return null;
    }


}

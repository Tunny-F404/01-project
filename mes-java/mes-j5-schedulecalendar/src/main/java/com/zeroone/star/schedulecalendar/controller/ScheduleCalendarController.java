package com.zeroone.star.schedulecalendar.controller;

import com.zeroone.star.project.j5.dto.schedulecalendar.ScheduleCalendarDTO;
import com.zeroone.star.project.j5.query.schedulecalendar.ScheduleQueryTeam;
import com.zeroone.star.project.j5.query.schedulecalendar.ScheduleQueryType;
import com.zeroone.star.project.j5.query.schedulecalendar.ScheduleQueryUser;
import com.zeroone.star.project.j5.schedulecalendar.ScheduleCalendarApis;
import com.zeroone.star.project.vo.JsonVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 排班日历 查询
 * @program: mes-java
 * @ClassName ScheduleCalendarIMP
 * @author: nangua
 * @create: 2024-05-22 19:45
 * @Version 1.0
 **/

@RestController
@RequestMapping("calendar")
@Api(tags = "排班日历")
public class ScheduleCalendarController implements ScheduleCalendarApis {

    @GetMapping("/list-by-type")
    @ApiOperation("获取指定班组类型排班计划")
    @Override
    public JsonVO<ScheduleCalendarDTO> listScheduleByType(ScheduleQueryType condition) {
        return null;
    }
    @GetMapping("/list-by-team")
    @ApiOperation("获取指定班组排班计划")
    @Override
    public JsonVO<ScheduleCalendarDTO> listScheduleByTeam(ScheduleQueryTeam condition) {
        return null;
    }
    @GetMapping("/list-by-user")
    @ApiOperation("获取指定人员排班计划")
    @Override
    public JsonVO<ScheduleCalendarDTO> listScheduleByTeam(ScheduleQueryUser condition) {
        return null;
    }




}

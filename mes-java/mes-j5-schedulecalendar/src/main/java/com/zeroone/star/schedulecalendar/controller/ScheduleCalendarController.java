package com.zeroone.star.schedulecalendar.controller;

import com.zeroone.star.project.dto.PageDTO;
import com.zeroone.star.project.j5.dto.schedulecalendar.ScheduleCalendarDTO;
import com.zeroone.star.project.j5.dto.scheduleplan.planteam.PlanTeamDTO;
import com.zeroone.star.project.j5.query.holidaysetting.SettingHolidayQuery;
import com.zeroone.star.project.j5.query.scheduleplan.planteam.PlanTeamQuery;
import com.zeroone.star.project.j5.schedulecalendar.ScheduleCalendarApis;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.ResultStatus;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @program: mes-java
 * @ClassName ScheduleCalendarIMP
 * @author: nangua
 * @create: 2024-05-22 19:45
 * @Version 1.0
 **/

@RestController
@RequestMapping("/cal/calholiday")
@Api(tags = "节假日设置")
public class ScheduleCalendarController implements ScheduleCalendarApis {

    @GetMapping("/list")
    @ApiOperation("获取节假日配置")
    @Override
    public JsonVO<ScheduleCalendarDTO> listHoliday() {
        return null;
    }


    @PostMapping("/list")
    @ApiOperation("设置节假日配置")
    @Override
    public JsonVO<ResultStatus> setHoliday(SettingHolidayQuery condition) {
        return null;
    }
}
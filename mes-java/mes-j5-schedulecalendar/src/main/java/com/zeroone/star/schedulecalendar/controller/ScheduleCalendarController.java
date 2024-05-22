package com.zeroone.star.schedulecalendar.controller;

import com.zeroone.star.project.j5.schedulecalendar.ScheduleCalendarApis;
import io.swagger.annotations.Api;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 描述：排班日历控制器
 * </p>
 * <p>版权：&copy;01星球</p>
 * <p>地址：01星球总部</p>
 * @author interstellar
 * @version 1.0.0
 */
@RestController
@RequestMapping("sch-manage/sch-calendar")
@Api(tags = "排班日历接口")
@Validated
public class ScheduleCalendarController implements ScheduleCalendarApis {
}

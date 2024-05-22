package com.zeroone.star.project.j5.schedulecalendar;

import com.zeroone.star.project.j5.dto.schedulecalendar.ScheduleCalendarDTO;
import com.zeroone.star.project.j5.query.schedulecalendar.ScheduleQueryTeam;
import com.zeroone.star.project.j5.query.schedulecalendar.ScheduleQueryType;
import com.zeroone.star.project.j5.query.schedulecalendar.ScheduleQueryUser;
import com.zeroone.star.project.vo.JsonVO;

/**
 * <p>
 * 描述：排班日历接口
 * </p>
 * <p>版权：&copy;01星球</p>
 * <p>地址：01星球总部</p>
 * @author interstellar
 * @version 1.0.0
 */
public interface ScheduleCalendarApis {
    /**
     * 获取指定班组类型排班计划
     * @return 排班计划列表
     */
    public JsonVO<ScheduleCalendarDTO> listScheduleByType(ScheduleQueryType condition);

    /**
     * 获取指定班组排班计划
     * @return 排班计划列表
     */
    public JsonVO<ScheduleCalendarDTO> listScheduleByTeam(ScheduleQueryTeam condition);

    /**
     * 获取指定人员排班计划
     * @return 排班计划列表
     */
    public JsonVO<ScheduleCalendarDTO> listScheduleByTeam(ScheduleQueryUser condition);


}

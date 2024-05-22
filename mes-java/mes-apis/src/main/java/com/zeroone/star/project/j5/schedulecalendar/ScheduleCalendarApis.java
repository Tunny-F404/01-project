package com.zeroone.star.project.j5.schedulecalendar;

import com.zeroone.star.project.j5.dto.schedulecalendar.ScheduleCalendarDTO;
import com.zeroone.star.project.j5.query.holidaysetting.SettingHolidayQuery;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.ResultStatus;

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
     * 获取节假日配置
     * @return 返回节假日配置列表
     */
    public JsonVO<ScheduleCalendarDTO> listHoliday();

    /**
     * 设置节假日配置
     * @param condition
     * @return 返回状态码
     */
    public JsonVO<ResultStatus> setHoliday(SettingHolidayQuery condition);
}

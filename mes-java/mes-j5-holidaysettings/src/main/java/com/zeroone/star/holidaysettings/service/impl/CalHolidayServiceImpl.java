package com.zeroone.star.holidaysettings.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zeroone.star.holidaysettings.entity.CalHoliday;
import com.zeroone.star.holidaysettings.mapper.CalHolidayMapper;
import com.zeroone.star.holidaysettings.service.ICalHolidayService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zeroone.star.project.j5.dto.holidaysetting.HolidayDTO;
import com.zeroone.star.project.j5.dto.holidaysetting.HolidaysListDTO;
import com.zeroone.star.project.j5.query.holidaysetting.ListHolidayQuery;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 节假日设置 服务实现类
 * </p>
 *
 * @author interstellar
 * @since 2024-05-25
 */
@Service
public class CalHolidayServiceImpl extends ServiceImpl<CalHolidayMapper, CalHoliday> implements ICalHolidayService {

    @Mapper
    CalHolidayMapper calHolidayMapper;
    @Override
    public HolidaysListDTO getList(ListHolidayQuery condition) {
        //根据ListHolidayQuery中的theDay查询指定日期数据
        QueryWrapper<CalHoliday> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("the_day",condition.getDate());
        List<CalHoliday> holidaysDO = calHolidayMapper.selectList(queryWrapper);

        //将holidaysDO数据封装成HolidaysListDTO
        HolidaysListDTO holidaysListDTO = new HolidaysListDTO();
        holidaysListDTO.setHolidaysList(holidaysDO);
        return holidaysListDTO;



    }
}

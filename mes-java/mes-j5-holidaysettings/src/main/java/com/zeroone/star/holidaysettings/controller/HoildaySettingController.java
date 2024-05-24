package com.zeroone.star.holidaysettings.controller;

import com.zeroone.star.project.j5.dto.holidaysetting.HolidaysListDTO;
import com.zeroone.star.project.j5.holidaysettings.HolidaySettingsApis;
import com.zeroone.star.project.j5.query.holidaysetting.SettingHolidayQuery;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.ResultStatus;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 节假日设置
 * @program: mes-java
 * @ClassName HoildaySettingController
 * @author: nangua
 * @create: 2024-05-22 21:15
 * @Version 1.0
 **/
@RestController
@RequestMapping("calholiday")
@Api(tags = "节假日设置")
public class HoildaySettingController implements HolidaySettingsApis {
    @GetMapping("/list")
    @ApiOperation("获取节假日配置")
    @Override
    public JsonVO<HolidaysListDTO> listHoliday() {
        return null;
    }


    @PostMapping("/list")
    @ApiOperation("设置节假日配置")
    @Override
    public JsonVO<ResultStatus> setHoliday(SettingHolidayQuery condition) {
        return null;
    }

}
package com.zeroone.star.project.j5.query.schedulecalendar;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

/**
 * @description:
 * @program: mes-java
 * @ClassName ScheduleDate
 * @author: nangua
 * @create: 2024-05-28 20:00
 * @Version 1.0
 **/

@Data
public class ScheduleDate {

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty(value = "日期", example = "2024-05-22")
    private LocalDate theDay;

}
package com.zeroone.star.schedulecalendar.service;


import com.zeroone.star.project.j5.dto.schedulecalendar.ScheduleCalendarDTO;
import com.zeroone.star.project.j5.query.schedulecalendar.ScheduleDate;
import com.zeroone.star.project.j5.query.schedulecalendar.ScheduleTeamQuery;
import com.zeroone.star.schedulecalendar.entity.CalTeamshift;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;


@Mapper(componentModel = "spring")
@Service
public interface TeamShiftTransfer {
    TeamShiftTransfer INSTANCE = Mappers.getMapper(TeamShiftTransfer.class);

//    @Mapping(source = "calendarType", target = "calendarType")
//    @Mapping(source = "teamId", target = "teamId")
//    @Mapping(source = "userId", target = "userId")
    CalTeamshift queryToTeamshiftDO(ScheduleDate condition);

    ScheduleCalendarDTO teamshiftDOToShiftDTO(CalTeamshift calTeamshift);

}

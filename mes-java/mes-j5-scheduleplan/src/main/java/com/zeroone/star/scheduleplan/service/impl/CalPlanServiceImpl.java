package com.zeroone.star.scheduleplan.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zeroone.star.project.j5.dto.scheduleplan.PlanDTO;
import com.zeroone.star.project.j5.vo.scheduleplan.PlanVO;
import com.zeroone.star.scheduleplan.entity.CalPlan;
import com.zeroone.star.scheduleplan.mapper.CalPlanMapper;
import com.zeroone.star.scheduleplan.service.ICalPlanService;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

@Mapper(componentModel = "spring")
interface MsTeamMapper {


    /**
     * 计划实体类转DTO
     * @param calPlan 计划实体类
     * @return 计划DTO
     */
    PlanDTO planDTOToPlan(CalPlan calPlan);


}
/**
 * <p>
 * 排班计划表 服务实现类
 * </p>
 *
 * @author interstellar
 * @since 2024-05-25
 */
@Service
public class CalPlanServiceImpl extends ServiceImpl<CalPlanMapper, CalPlan> implements ICalPlanService {

    /**
     *
     * @param planId
     * @return 详情
     */
    @Override
    public PlanVO queryPlanDetails(Long planId) {
        return null;
    }
}

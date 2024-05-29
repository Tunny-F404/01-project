package com.zeroone.star.scheduleplan.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zeroone.star.project.j5.vo.scheduleplan.PlanVO;
import com.zeroone.star.scheduleplan.entity.CalPlan;
import com.zeroone.star.scheduleplan.mapper.CalPlanMapper;
import com.zeroone.star.scheduleplan.service.ICalPlanService;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Mapper(componentModel = "spring")
interface MsPlanMapper {


    /**
     * 计划实体类转DTO
     * @param calPlan 计划实体类
     * @return 计划DTO
     */
    PlanVO planToPlanVO(CalPlan calPlan);


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

    @Resource
    MsPlanMapper msPlanMapper;

    @Override
    public PlanVO queryPlanDetails(Long planId) {
        CalPlan calPlan = baseMapper.selectById(planId);
        return msPlanMapper.planToPlanVO(calPlan);
    }

//    @Override
//    public TeamDTO queryTeamDetails(Long teamId) {
//        // 将数据查询出
//        CalTeam calTeam = baseMapper.selectById(teamId);
//        // 转为DTO并返回
//        return msTeamMapper.teamToTeamDTO(calTeam);
//    }
}

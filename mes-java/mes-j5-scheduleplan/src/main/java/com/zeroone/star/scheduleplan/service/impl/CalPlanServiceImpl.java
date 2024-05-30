package com.zeroone.star.scheduleplan.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zeroone.star.project.dto.PageDTO;
import com.zeroone.star.project.j5.query.scheduleplan.PlanPageQuery;
import com.zeroone.star.project.j5.vo.scheduleplan.PlanListVO;
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
     * 计划实体类转计划详情VO
     * @param calPlan 计划实体类
     * @return 计划详情VO
     */
    PlanVO planToPlanVO(CalPlan calPlan);

    /**
     * 计划实体类转计划列表VO
     * @param calPlan 计划实体类
     * @return 计划列表VO
     */
    PlanListVO planToPlanListVO(CalPlan calPlan);

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
    public PageDTO<PlanListVO> queryPlanList(PlanPageQuery condition) {
        //1.构建分页对象
        Page<CalPlan> page = new Page<>(condition.getPageIndex(), condition.getPageSize());
        //2.构建查询条件
        LambdaQueryWrapper<CalPlan> wrapper = new LambdaQueryWrapper<>();
        wrapper
                .like(condition.getPlanCode() != null,CalPlan::getPlanCode,condition.getPlanCode())
                .like(condition.getPlanName() != null,CalPlan::getPlanName,condition.getPlanName())
                .eq(condition.getCalendarType()!= null, CalPlan::getCalendarType,condition.getCalendarType())
                .ge(condition.getStartDate() != null, CalPlan::getStartDate, condition.getStartDate())
                .le(condition.getEndDate() != null, CalPlan::getEndDate, condition.getEndDate());
        //3.执行分页查询
        Page<CalPlan> calPlanPage = baseMapper.selectPage(page, wrapper);
        //转为PlanListVO
        return PageDTO.create(calPlanPage,msPlanMapper::planToPlanListVO);
    }

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

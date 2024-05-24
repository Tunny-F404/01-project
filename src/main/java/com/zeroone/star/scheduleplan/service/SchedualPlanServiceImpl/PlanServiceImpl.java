package com.zeroone.star.scheduleplan.service.SchedualPlanServiceImpl;

import com.zeroone.star.scheduleplan.PlansVO.Plan;
import com.zeroone.star.scheduleplan.mapper.PlanMapper;
import com.zeroone.star.scheduleplan.service.SchedualPlanService.IPlanService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 排班计划表 服务实现类
 * </p>
 *
 * @author brickbreaker
 * @since 2024-05-22
 */
@Service
public class PlanServiceImpl extends ServiceImpl<PlanMapper, Plan> implements IPlanService {

}

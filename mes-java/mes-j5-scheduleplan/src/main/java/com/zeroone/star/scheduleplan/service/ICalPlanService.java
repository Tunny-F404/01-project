package com.zeroone.star.scheduleplan.service;

import com.zeroone.star.project.j5.vo.scheduleplan.PlanVO;
import com.zeroone.star.scheduleplan.entity.CalPlan;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 排班计划表 服务类
 * </p>
 *
 * @author interstellar
 * @since 2024-05-25
 */
public interface ICalPlanService extends IService<CalPlan> {

    /**
     *
     * @param planId
     * @return 计划详情
     */
    PlanVO queryPlanDetails(Long planId);
}

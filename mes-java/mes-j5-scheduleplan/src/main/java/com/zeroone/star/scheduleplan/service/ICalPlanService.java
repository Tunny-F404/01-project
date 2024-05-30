package com.zeroone.star.scheduleplan.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zeroone.star.project.dto.PageDTO;
import com.zeroone.star.project.j5.dto.scheduleplan.AddPlanDTO;
import com.zeroone.star.project.j5.query.scheduleplan.PlanPageQuery;
import com.zeroone.star.project.j5.vo.scheduleplan.PlanListVO;
import com.zeroone.star.project.j5.vo.scheduleplan.PlanVO;
import com.zeroone.star.scheduleplan.entity.CalPlan;

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
     * 分页+条件查询
     * @author brickbreaker
     * @param condition 查询条件
     * @return 分页数据
     */
    PageDTO<PlanListVO> queryPlanList(PlanPageQuery condition);

    /**
     * 查询计划详情
     * @author brickbreaker
     * @param planId 计划ID
     * @return 计划详情
     */
    PlanVO queryPlanDetails(Long planId);


    /**
     * 添加计划
     * @param condition 添加条件
     * @return 添加结果
     */
    boolean addPlan(AddPlanDTO condition);
}

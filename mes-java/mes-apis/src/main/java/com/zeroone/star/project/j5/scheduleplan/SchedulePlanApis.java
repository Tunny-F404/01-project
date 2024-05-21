package com.zeroone.star.project.j5.scheduleplan;

import com.zeroone.star.project.dto.PageDTO;
import com.zeroone.star.project.j5.dto.scheduleplan.PlanDTO;
import com.zeroone.star.project.j5.query.scheduleplan.PlanPageQuery;
import com.zeroone.star.project.j5.vo.scheduleplan.PlanListVO;
import com.zeroone.star.project.j5.vo.scheduleplan.PlanVO;
import com.zeroone.star.project.vo.JsonVO;

/**
 * <p>
 * 描述：排班计划接口
 * </p>
 * <p>版权：&copy;01星球</p>
 * <p>地址：01星球总部</p>
 * @author interstellar
 * @version 1.0.0
 */
public interface SchedulePlanApis {
    /**
     * 查询排班计划列表
     * @param condition 查询条件
     * @author brickbreaker
     * @return  排班计划列表
     */
    JsonVO<PageDTO<PlanListVO>> queryPlanList (PlanPageQuery condition);

    /**
     * 获取计划详情
     * @param planId
     * @author brickbreaker
     * @return 计划详情
     */
    JsonVO<PlanVO> queryPlanDetails(Long planId);


    /**
     * 添加计划
     * @param planDTO 计划信息
     * @author brickbreaker
     * @return 添加结果
     */
    JsonVO<Integer> addPlan(PlanDTO planDTO);


    /**
     * 修改计划
     * @param planDTO 计划信息
     * @author brickbreaker
     * @return 修改结果
     */
    JsonVO<Integer> modifyTeam(PlanDTO planDTO);

}

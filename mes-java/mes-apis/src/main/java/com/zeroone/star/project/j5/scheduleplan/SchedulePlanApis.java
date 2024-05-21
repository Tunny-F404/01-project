package com.zeroone.star.project.j5.scheduleplan;

import com.zeroone.star.project.dto.PageDTO;
import com.zeroone.star.project.j5.dto.scheduleplan.PlanDTO;
import com.zeroone.star.project.j5.query.scheduleplan.PlanPageQuery;
import com.zeroone.star.project.j5.vo.schedualplan.PlanListVO;
import com.zeroone.star.project.j5.vo.schedualplan.PlanVO;
import com.zeroone.star.project.vo.JsonVO;

import com.zeroone.star.project.j5.dto.scheduleplan.SchPlanDTO;
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

    /**
     * 删除排版计划(可批量删除)
     * @param rems 删除数据的id集合
     *  @author sailing
     */
    JsonVO<Integer> removeSchPlan(Long[] rems);

    /**
     * 修改计划状态
     * @param schPlanDTO  修改状态模型
     * @author sailing
     */
    JsonVO<Integer>  modifySchPlanStatus(SchPlanDTO schPlanDTO);

}

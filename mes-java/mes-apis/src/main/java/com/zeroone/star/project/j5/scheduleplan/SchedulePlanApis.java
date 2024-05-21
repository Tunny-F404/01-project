package com.zeroone.star.project.j5.scheduleplan;

import com.zeroone.star.project.dto.PageDTO;
import com.zeroone.star.project.j5.query.schedualplan.PlanPageQuery;
import com.zeroone.star.project.j5.vo.schedualplan.PlanListVO;
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
     * @return  排班计划列表
     */
    JsonVO<PageDTO<PlanListVO>> queryPlanList (PlanPageQuery condition);
}

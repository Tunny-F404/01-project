package com.zeroone.star.project.j5.scheduleplan;

import com.zeroone.star.project.j5.dto.scheduleplan.SchPlanDto;
import com.zeroone.star.project.j5.vo.SchPlan.DeletePlan;
import com.zeroone.star.project.j5.vo.SchPlan.UpdatePlanStatus;
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
     * 删除排版计划(可批量删除)
     * @param rems 删除数据的id集合
     *  @author sailing
     */
    JsonVO<Integer> removeSchPlan(int[] rems);

    /**
     * 修改计划状态
     * @param schPlanDto  修改状态模型
     * @author sailing
     */
    JsonVO<Integer>  modifySchPlanStatus(SchPlanDto schPlanDto);

    /**
     * 导出计划
     * @author sailing
     */
    JsonVO<SchPlanDto[]>  exportSchPlan(SchPlanDto[] plans);
}

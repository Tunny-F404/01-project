package com.zeroone.star.project.j5.scheduleplan;

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

    /**
     * 导出计划
     * @author sailing
     * 参数待合并后补充query
     */
    JsonVO<SchPlanDTO[]>  exportSchPlan();
}

package com.zeroone.star.project.j5.scheduleplan;

import com.zeroone.star.project.j5.vo.SchPlan.DeletePlan;
import com.zeroone.star.project.j5.vo.SchPlan.UpdatePlanStatus;

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
     * @param deletePlans 指定删除数据
     *  @author sailing
     */
    void deleteSchPlan(DeletePlan[] deletePlans);

    /**
     * 修改计划状态
     * @param updateStatus  修改状态模型
     * @author sailing
     */
    void updateSchPlanStatus(UpdatePlanStatus updateStatus);

    /**
     * 导出计划
     * 待和组员沟通排班计划的模型封装,补充参数(同列表类)
     * @author sailing
     */
    void exportSchPlan();
}

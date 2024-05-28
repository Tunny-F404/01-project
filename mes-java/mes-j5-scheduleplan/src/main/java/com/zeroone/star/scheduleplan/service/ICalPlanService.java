package com.zeroone.star.scheduleplan.service;

import com.zeroone.star.project.j5.dto.scheduleplan.PlanDTO;
import com.zeroone.star.project.j5.dto.scheduleplan.SchPlanDTO;
import com.zeroone.star.project.j5.query.scheduleplan.PlanPageQuery;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.scheduleplan.entity.CalPlan;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.http.ResponseEntity;

import java.util.List;

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
     * 删除排班计划(可批量删除)
     * @param rems 删除数据的id集合
     *  @author sailing
     */
    boolean removeSchPlan(List<Long> rems);

    /**
     * 修改计划状态
     * @param condition  修改状态模型
     * @author sailing
     */
    boolean  modifySchPlanStatus(PlanDTO condition);

    /**
     * 导出排班计划
     * @param condition 查询条件
     * @author interstellar
     */
    ResponseEntity<byte[]> exportSchPlan(PlanPageQuery condition);
}

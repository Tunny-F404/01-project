package com.zeroone.star.project.j5.scheduleplan.team;

import com.zeroone.star.project.dto.PageDTO;
import com.zeroone.star.project.j5.dto.scheduleplan.planteam.AddPlanTeamDTO;
import com.zeroone.star.project.j5.dto.scheduleplan.planteam.PlanTeamDTO;
import com.zeroone.star.project.j5.query.scheduleplan.planteam.PlanTeamQuery;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.ResultStatus;

/**
 * <p>
 * 描述：关联班组API接口定义
 * </p>
 * @author linglan
 * @version 1.0.0
 */
public interface TeamApis {
    /**
     * 关联班组分页查询
     * @param condition 查询条件
     * @return 查询结果
     */
    JsonVO<PageDTO<PlanTeamDTO>> queryAllPlanTeam(PlanTeamQuery condition);

    /**
     * 添加关联班组
     * @param addPlanTeamDTO 添加关联班组参数
     * @return 结果
     */
    JsonVO<Integer> addPlanTeam(AddPlanTeamDTO addPlanTeamDTO);

    /**
     * 删除关联班组
     * @param recordId 流水号, 对应数据库record_id
     * @return 结果
     */
    JsonVO<Integer> deletePlanTeam(Integer recordId);

}

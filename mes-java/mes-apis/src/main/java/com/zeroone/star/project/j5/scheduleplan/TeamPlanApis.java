package com.zeroone.star.project.j5.scheduleplan;

import com.zeroone.star.project.dto.PageDTO;
import com.zeroone.star.project.dto.sample.SampleDTO;
import com.zeroone.star.project.j5.dto.planteam.PlanTeamDTO;
import com.zeroone.star.project.j5.query.planteam.PlanTeamQuery;
import com.zeroone.star.project.query.sample.SampleQuery;
import com.zeroone.star.project.vo.JsonVO;

/**
 * <p>
 * 描述：关联班组API接口定义
 * </p>
 * @author linglan
 * @version 1.0.0
 */
public interface TeamPlanApis {
    /**
     * 测试分页查询
     * @param condition 查询条件
     * @return 查询结果
     */
    JsonVO<PageDTO<PlanTeamDTO>> queryAll(PlanTeamQuery condition);

}

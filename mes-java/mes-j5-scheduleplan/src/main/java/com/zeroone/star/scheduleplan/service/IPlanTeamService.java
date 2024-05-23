package com.zeroone.star.scheduleplan.service;

import com.zeroone.star.project.dto.PageDTO;
import com.zeroone.star.project.j5.dto.scheduleplan.planteam.PlanTeamDTO;
import com.zeroone.star.project.j5.query.scheduleplan.planteam.PlanTeamQuery;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zeroone.star.scheduleplan.entity.CalPlanTeam;

/**
 * <p>
 * 演示示例表 服务类
 * </p>
 *
 * @author awei
 * @since 2024-05-10
 */
public interface IPlanTeamService extends IService<CalPlanTeam> {
    /**
     * 分页查询所有数据
     * @param query 查询条件
     * @return 查询结果
     */
    PageDTO<PlanTeamDTO> listAll(PlanTeamQuery query);

    /**
     * 通过Id查询数据
     * @param id ID
     * @return 查询结果
     */
    PlanTeamDTO getById(int id);

    /**
     * 测试seata声明式服务调用
     * @return 执行结果
     */
//    int testSeata();
}

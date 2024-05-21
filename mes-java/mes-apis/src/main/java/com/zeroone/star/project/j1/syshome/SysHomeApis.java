package com.zeroone.star.project.j1.syshome;

import com.zeroone.star.project.j1.syshome.dto.PageDTO;
import com.zeroone.star.project.j1.syshome.dto.plan.PlanDTO;
import com.zeroone.star.project.j1.syshome.dto.toDoEvent.ToDoEventDTO;
import com.zeroone.star.project.j1.syshome.dto.workshop.WorkshopDTO;
import com.zeroone.star.project.j1.syshome.query.PageQuery;
import com.zeroone.star.project.vo.JsonVO;

import java.util.List;

/**
 * <p>
 * 描述：系统首页接口
 * </p>
 * @author 李兴昊
 * @version 1.0.0
 */
public interface SysHomeApis {
    /**
     * 车间信息查询
     * @param
     * @return 查询结果
     */
    JsonVO<List<WorkshopDTO>> queryWorkshopList();

    /**
     * 排班情况分页查询
     * @param
     * @return 查询结果
     */
    JsonVO<PageDTO<PlanDTO>> queryPlan(PageQuery pageQuery);

    /**
     * 我的待办分页查询
     * @param
     * @return 查询结果
     */
    JsonVO<PageDTO<ToDoEventDTO>> queryToDoEvent(PageQuery pageQuery);
}

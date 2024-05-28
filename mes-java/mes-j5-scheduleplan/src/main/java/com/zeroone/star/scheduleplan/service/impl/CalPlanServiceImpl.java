package com.zeroone.star.scheduleplan.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zeroone.star.project.j5.dto.scheduleplan.SchPlanDTO;
import com.zeroone.star.project.j5.query.scheduleplan.PlanPageQuery;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.scheduleplan.entity.CalPlan;
import com.zeroone.star.scheduleplan.mapper.CalPlanMapper;
import com.zeroone.star.scheduleplan.service.ICalPlanService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 排班计划表 服务实现类
 * </p>
 *
 * @author interstellar
 * @since 2024-05-25
 */
@Service
public class CalPlanServiceImpl extends ServiceImpl<CalPlanMapper, CalPlan> implements ICalPlanService {

    @Resource
    CalPlanMapper calPlanMapper;

    /**
     * 删除排班计划(可批量删除)
     * @param rems 删除数据的id集合
     * @return
     */
    @Override
    public boolean removeSchPlan(List<Long> rems) {
        return calPlanMapper.deleteBatchIds(rems)>0;
    }

    @Override
    public boolean modifySchPlanStatus(SchPlanDTO schPlanDTO) {
        return false;
    }

    @Override
    public ResponseEntity<byte[]> exportSchPlan(PlanPageQuery condition) {
        return null;
    }
}

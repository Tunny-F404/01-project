package com.zeroone.star.scheduleplan.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zeroone.star.project.j5.dto.scheduleplan.PlanDTO;
import com.zeroone.star.project.j5.query.scheduleplan.PlanPageQuery;
import com.zeroone.star.scheduleplan.entity.CalPlan;
import com.zeroone.star.scheduleplan.mapper.CalPlanMapper;
import com.zeroone.star.scheduleplan.service.ICalPlanService;
import org.mapstruct.Mapper;
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
@Mapper(componentModel = "spring")
interface MsPlanMapper {
    /**
     * 实体类转DTO
     *
     * @param calPlan 计划do对象
     * @return 计划dto对象
     */
    PlanDTO planToPlanDTO(CalPlan calPlan);

    /**
     * 计划DTO转实体类
     *
     * @param planDTO
     * @return
     */
    CalPlan PlanDTOToplan(PlanDTO planDTO);
}

@Service
public class CalPlanServiceImpl extends ServiceImpl<CalPlanMapper, CalPlan> implements ICalPlanService {

    @Resource
    private MsPlanMapper msPlanMapper;
    @Resource
    private CalPlanMapper planMapper;

    /**
     * 删除排班计划(可批量删除)
     *
     * @param rems 删除数据的id集合
     * @return
     */
    @Override
    public boolean removeSchPlan(List<Long> rems) {
        return planMapper.deleteBatchIds(rems) > 0;
    }

    @Override
    public boolean modifySchPlanStatus(PlanDTO condition) {
        //1.查询当前数据是否存在
        CalPlan modifyPlan = baseMapper.selectById(condition.getPlanId());
        //2.数据不存在,修改失败,返回false
        if (modifyPlan == null) {
            return false;
        }
        //3.存在则执行修改操作---将DTO转为DO
        CalPlan calPlan = msPlanMapper.PlanDTOToplan(condition);

        return baseMapper.updateById(calPlan) > 0;
    }

    @Override
    public ResponseEntity<byte[]> exportSchPlan(PlanPageQuery condition) {
        return null;
    }


}

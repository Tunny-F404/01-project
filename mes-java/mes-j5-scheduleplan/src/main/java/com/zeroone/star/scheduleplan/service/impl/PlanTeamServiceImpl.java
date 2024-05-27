package com.zeroone.star.scheduleplan.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zeroone.star.project.dto.PageDTO;
import com.zeroone.star.project.j5.dto.scheduleplan.planteam.AddPlanTeamDTO;
import com.zeroone.star.project.j5.dto.scheduleplan.planteam.PlanTeamDTO;
import com.zeroone.star.project.j5.query.scheduleplan.planteam.PlanTeamQuery;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zeroone.star.scheduleplan.entity.CalPlanTeam;
import com.zeroone.star.scheduleplan.mapper.CalPlanTeamMapper;
import com.zeroone.star.scheduleplan.service.IPlanTeamService;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 描述：Sample对应MapStructMapper接口
 * </p>
 * <p>版权：&copy;01星球</p>
 * <p>地址：01星球总部</p>
 * @author 阿伟学长
 * @version 1.0.0
 */
@Mapper(componentModel = "spring")
interface MsCalPlanTeamMapper {
    /**
     * 将 SampleDO 转换成 SampleDTO
     * @param calPlanTeam do对象
     * @return 转换后的结果
     */
    PlanTeamDTO calPlanTeamToPlanTeamDTO(CalPlanTeam calPlanTeam);

    /**
     * 将 AddPlanTeamDTO 转换成 CalPlanTeam
     * @param addPlanTeamDTO dto对象
     * @return 转换后的结果
     */
    CalPlanTeam addPlanTeamDTOToCalPlanTeam(AddPlanTeamDTO addPlanTeamDTO);
}

/**
 * <p>
 * 演示示例表 服务实现类
 * </p>
 * @author awei
 * @since 2024-05-10
 */
@Service
public class PlanTeamServiceImpl extends ServiceImpl<CalPlanTeamMapper, CalPlanTeam> implements IPlanTeamService {

    @Resource
    MsCalPlanTeamMapper msCalPlanTeamMapper;

    @Override
    public PageDTO<PlanTeamDTO> listAll(PlanTeamQuery query) {
        // 构建分页查询对象
        Page<CalPlanTeam> page = new Page<>(query.getPageIndex(), query.getPageSize());
        // 构建查询条件
        QueryWrapper<CalPlanTeam> wrapper = new QueryWrapper<>();
        wrapper.eq("plan_id", query.getPlanId());
        // 执行分页查询
        Page<CalPlanTeam> result = baseMapper.selectPage(page, wrapper);
        // 结果转换成DTO
        return PageDTO.create(result, src -> msCalPlanTeamMapper.calPlanTeamToPlanTeamDTO(src));
    }

    @Override
    public Integer addPlanTeam(AddPlanTeamDTO addPlanTeamDTO) {
        int res = baseMapper.insert(msCalPlanTeamMapper.addPlanTeamDTOToCalPlanTeam(addPlanTeamDTO));
        return res > 0 ? 1 : 0;
    }

    @Override
    public Integer deletePlanTeam(Integer recordId) {
        int res = baseMapper.deleteById(recordId);
        return res > 0 ? 1 : 0;
    }
}

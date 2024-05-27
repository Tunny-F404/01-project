package com.zeroone.star.teamsettings.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zeroone.star.project.dto.PageDTO;
import com.zeroone.star.project.j5.dto.teamsettings.AddTeamDTO;
import com.zeroone.star.project.j5.dto.teamsettings.TeamDTO;
import com.zeroone.star.project.j5.query.teamsettings.TeamQuery;
import com.zeroone.star.teamsettings.entity.CalTeam;
import com.zeroone.star.teamsettings.mapper.CalTeamMapper;
import com.zeroone.star.teamsettings.service.ICalTeamService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.mapstruct.Mapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Mapper(componentModel = "spring")
interface MsTeamMapper {
    /**
     * 班组实体类转DTO
     * @param calTeam 班组实体类
     * @return 班组DTO
     */
    TeamDTO teamToTeamDTO(CalTeam calTeam);

    /**
     * 班组DTO转实体类
     * @param teamDTO 班组DTO
     * @return 班组实体类
     */
    CalTeam teamDTOToTeam(TeamDTO teamDTO);

    /**
     * 添加班组DTO转实体类
     * @param addTeamDTO
     * @return
     */
    CalTeam addTeamDTOToTeam(AddTeamDTO addTeamDTO);
}

/**
 * <p>
 * 班组表 服务实现类
 * </p>
 *
 * @author interstellar
 * @since 2024-05-25
 */
@Service
public class CalTeamServiceImpl extends ServiceImpl<CalTeamMapper, CalTeam> implements ICalTeamService {
    @Override
    public boolean removeTeam(List<Long> ids) {
        return baseMapper.deleteBatchIds(ids) > 0;
    }

    @Resource
    MsTeamMapper msTeamMapper;


    @Override
    public PageDTO<TeamDTO> listAll(TeamQuery condition) {
        // 构建分页对象
        Page<CalTeam> page = new Page<>(condition.getPageIndex(), condition.getPageSize());
        // 构建查询条件
        QueryWrapper<CalTeam> wrapper = new QueryWrapper<>();
        wrapper.lambda()
                .like(condition.getTeamCode() != null, CalTeam::getTeamCode, condition.getTeamCode())
                .like(condition.getTeamName() != null, CalTeam::getTeamName, condition.getTeamName())
                .like(condition.getCalendarType() != null, CalTeam::getCalendarType, condition.getCalendarType());
        // 执行分页查询
        Page<CalTeam> result = baseMapper.selectPage(page, wrapper);

        return PageDTO.create(result, msTeamMapper::teamToTeamDTO);
    }

    @Override
    public TeamDTO queryTeamDetails(Long teamId) {
        // 将数据查询出
        CalTeam calTeam = baseMapper.selectById(teamId);
        // 转为DTO并返回
        return msTeamMapper.teamToTeamDTO(calTeam);
    }

    @Override
    public boolean addTeam(AddTeamDTO condition) {
        // DTO 转为 DO
        CalTeam calTeam = msTeamMapper.addTeamDTOToTeam(condition);

        // 保存到数据库并返回结果
        return baseMapper.insert(calTeam) > 0;
    }

    @Override
    public boolean modifyTeam(TeamDTO condition) {
        // 查询是否存在
        CalTeam existCalTeam = baseMapper.selectById(condition.getTeamId());
        if (existCalTeam == null) {
            return false;
        }

        // DTO 转 DO
        CalTeam calTeam = msTeamMapper.teamDTOToTeam(condition);

        // 更新数据库信息
        return baseMapper.updateById(calTeam) > 0;
    }

    @Override
    public ResponseEntity<byte[]> queryTeamListByExcel(TeamQuery condition) {
        return null;
    }
}

package com.zeroone.star.teamsettings.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zeroone.star.project.dto.PageDTO;
import com.zeroone.star.project.j5.dto.teamsettings.MemberDTO;
import com.zeroone.star.project.j5.query.teamsettings.MemberQuery;
import com.zeroone.star.project.query.PageQuery;
import com.zeroone.star.teamsettings.entity.CalTeamMember;
import com.zeroone.star.teamsettings.mapper.CalTeamMemberMapper;
import com.zeroone.star.teamsettings.service.ICalTeamMemberService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
interface MsTeamMemberMapper {
    /**
     * 成员实体类转DTO
     * @param calTeamMember 成员实体类
     * @return 成员DTO
     */
    MemberDTO memberToMemberDTO(CalTeamMember calTeamMember);

    /**
     * 成员DTO转实体类
     * @param memberDTO 成员DTO
     * @return 成员实体类
     */
    CalTeamMember memberDTOToMember(MemberDTO memberDTO);

    /**
     * 成员DTO列表转实体类列表
     * @param memberDTOList 成员DTO列表
     * @return 成员实体类列表
     */
    List<CalTeamMember> memberDTOListToMemberList(List<MemberDTO> memberDTOList);

    /**
     * 成员实体类列表转DTO列表
     * @param calTeamMemberList 成员实体类列表
     * @return 成员DTO列表
     */
    List<MemberDTO> memberListToMemberDTOList(List<CalTeamMember> calTeamMemberList);
}


/**
 * <p>
 * 班组成员表 服务实现类
 * </p>
 *
 * @author interstellar
 * @since 2024-05-25
 */
@Service
public class CalTeamMemberServiceImpl extends ServiceImpl<CalTeamMemberMapper, CalTeamMember> implements ICalTeamMemberService {

    @Override
    public PageDTO<MemberDTO> queryMembers(MemberQuery condition) {
        Page<CalTeamMember> page = new Page<>(condition.getPageIndex(), condition.getPageSize());
        QueryWrapper<CalTeamMember> queryWrapper = new QueryWrapper<>();
        // 根据需要添加查询条件

        Page<CalTeamMember> resultPage = this.page(page, queryWrapper);
        return PageDTO.create(resultPage, MemberDTO.class);
    }

    @Override
    public void addMembers(List<MemberDTO> memberDTOList) {
        List<CalTeamMember> members = memberDTOList.stream()
                .map(dto -> {
                    CalTeamMember entity = new CalTeamMember();
                    BeanUtils.copyProperties(dto, entity);
                    return entity;
                }).collect(Collectors.toList());

        this.saveBatch(members);
    }

    @Override
    public void deleteMembers(List<Integer> memberIds) {
        this.removeByIds(memberIds);
    }

    @Override
    public byte[] exportMembers(MemberQuery condition) {
        QueryWrapper<CalTeamMember> queryWrapper = new QueryWrapper<>();
        // 根据需要添加查询条件

        List<CalTeamMember> members = this.list(queryWrapper);
        // 转换为 DTO
        List<MemberDTO> memberDTOList = members.stream()
                .map(entity -> {
                    MemberDTO dto = new MemberDTO();
                    BeanUtils.copyProperties(entity, dto);
                    return dto;
                }).collect(Collectors.toList());

        // 假设你有一个方法可以将 DTO 列表转换为字节数组（如 CSV 或 Excel）
        return convertToByteArray(memberDTOList);
    }
    private byte[] convertToByteArray(List<MemberDTO> memberDTOList) {
        // 实现将 DTO 列表转换为字节数组的逻辑（如 CSV 或 Excel）
        // 这是一个占位符，需要实际实现
        return new byte[0];
    }
}

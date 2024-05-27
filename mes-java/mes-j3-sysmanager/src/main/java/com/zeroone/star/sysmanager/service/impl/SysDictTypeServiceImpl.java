package com.zeroone.star.sysmanager.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zeroone.star.project.dto.PageDTO;
import com.zeroone.star.project.j3.dto.dict.SysDictTypeDetailDTO;
import com.zeroone.star.project.j3.dto.dict.SysDictTypeListDTO;
import com.zeroone.star.project.j3.query.dict.SysDictTypeQuery;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.sysmanager.entity.SysDictType;
import com.zeroone.star.sysmanager.mapper.SysDictTypeMapper;
import com.zeroone.star.sysmanager.service.ISysDictTypeService;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 字典类型表 服务实现类
 * </p>
 *
 * @author Axe
 * @since 2024-05-24
 */
@Service
public class SysDictTypeServiceImpl extends ServiceImpl<SysDictTypeMapper, SysDictType> implements ISysDictTypeService {

    @Resource
    private TsSysDictTypeMapper tsSysDictTypeMapper;

    @Override
    public JsonVO<PageDTO<SysDictTypeListDTO>> listDictType(SysDictTypeQuery dictTypeQuery) {
        // 开始分页
        Page<SysDictType> pageType = new Page<>(dictTypeQuery.getPageIndex(), dictTypeQuery.getPageSize());

        page(pageType, new LambdaQueryWrapper<SysDictType>()
                .like(dictTypeQuery.getDictName() != null,
                        SysDictType::getDictName, dictTypeQuery.getDictName())
                .like(dictTypeQuery.getDictType() != null,
                        SysDictType::getDictType, dictTypeQuery.getDictType())
                .eq(dictTypeQuery.getStatus() != null,
                        SysDictType::getStatus, dictTypeQuery.getStatus())
                .between(dictTypeQuery.getCreateBeginTime() != null && dictTypeQuery.getCreateEndTime() != null
                        , SysDictType::getCreateTime, dictTypeQuery.getCreateBeginTime(), dictTypeQuery.getCreateEndTime())
        );

        return JsonVO.success(PageDTO.create(pageType, tsSysDictTypeMapper::toDto));
    }

    @Override
    public JsonVO<SysDictTypeDetailDTO> getDictType(Long dictId) {
        return JsonVO.success(tsSysDictTypeMapper.toDetailDTO(getById(dictId)));
    }
}

@Mapper(componentModel = "spring")
interface TsSysDictTypeMapper {
    SysDictTypeListDTO toDto(SysDictType entity);

    SysDictTypeDetailDTO toDetailDTO(SysDictType sysDictType);
}
package com.zeroone.star.sysmanager.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zeroone.star.project.j3.dto.InsertDictTypeDTO;
import com.zeroone.star.project.j3.vo.DictTypeNameVO;
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
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
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
    public Long saveDictType(InsertDictTypeDTO dto) {
        //判断dto的dictType是否重复
        String dictType = dto.getDictType();
        LambdaQueryWrapper<SysDictType> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SysDictType::getDictType, dictType);
        long count = count(wrapper);
        //若重复则抛出异常
        if(count>0)
            throw new RuntimeException("字典类型不能重复");
        //若无重复则继续存储
        SysDictType sysDictType = new SysDictType();
        BeanUtils.copyProperties(dto, sysDictType);
        //成功存储返回新增id, 若失败则返回null
        return save(sysDictType) ? sysDictType.getDictId() : null;
    }

    @Override
    public List<DictTypeNameVO> listDictTypeName() {
        //查询数据库中所有字典类型的名称(需要去重)
        // 创建LambdaQueryWrapper对象
        LambdaQueryWrapper<SysDictType> wrapper = new LambdaQueryWrapper<>();

        // 设置查询条件，选择typeName
        wrapper.select(SysDictType::getDictName);

        // 执行查询
        List<SysDictType> dictTypeList = list(wrapper);

        // 使用Set来去重
        Set<String> typeNameSet = dictTypeList.stream()
                .map(SysDictType::getDictName)
                .collect(Collectors.toSet());

        // 转换Set为VO对象列表
        List<DictTypeNameVO> result = typeNameSet.stream()
                .map(typeName -> new DictTypeNameVO(typeName))
                .collect(Collectors.toList());

        return result;
    }
    
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
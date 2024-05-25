package com.zeroone.star.sysmanager.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.zeroone.star.project.j3.dto.InsertDictTypeDTO;
import com.zeroone.star.sysmanager.entity.SysDictType;
import com.zeroone.star.sysmanager.mapper.SysDictTypeMapper;
import com.zeroone.star.sysmanager.service.ISysDictTypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

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
}

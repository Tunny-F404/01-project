package com.zeroone.star.sysmanager.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zeroone.star.project.dto.dict.SysDictTypeDTO;
import com.zeroone.star.sysmanager.entity.SysDictTypeDO;
import com.zeroone.star.sysmanager.mapper.SysDictTypeMapper;
import com.zeroone.star.sysmanager.service.ISysDictTypeService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

//@Mapper(componentModel = "spring")
interface MsSysDictTypeMapper{
    /**
     * 讲 **DO 转换成 DTO对象
     */
    SysDictTypeDTO toDTO(SysDictTypeDO sysDictTypeDO);
}


/**
 * <p>
 * 字典类型表 服务实现类
 * </p>
 *
 * @author sud
 * @since 2024-05-21
 */
@Service
public class SysDictTypeServiceImpl extends ServiceImpl<SysDictTypeMapper, SysDictTypeDO> implements ISysDictTypeService {

}

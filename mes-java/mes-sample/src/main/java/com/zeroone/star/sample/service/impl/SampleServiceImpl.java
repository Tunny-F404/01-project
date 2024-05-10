package com.zeroone.star.sample.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zeroone.star.project.dto.PageDTO;
import com.zeroone.star.project.dto.sample.SampleDTO;
import com.zeroone.star.project.query.sample.SampleQuery;
import com.zeroone.star.sample.entity.Sample;
import com.zeroone.star.sample.mapper.SampleMapper;
import com.zeroone.star.sample.service.ISampleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
interface MsSampleMapper {
    /**
     * 将 SampleDO 转换成 SampleDTO
     * @param sample do对象
     * @return 转换后的结果
     */
    SampleDTO sampleToSampleDTO(Sample sample);
}

/**
 * <p>
 * 演示示例表 服务实现类
 * </p>
 * @author awei
 * @since 2024-05-10
 */
@Service
public class SampleServiceImpl extends ServiceImpl<SampleMapper, Sample> implements ISampleService {

    @Resource
    MsSampleMapper msSampleMapper;

    @Override
    public PageDTO<SampleDTO> listAll(SampleQuery query) {
        // 构建分页查询对象
        Page<Sample> page = new Page<>(query.getPageIndex(), query.getPageSize());
        // 构建查询条件
        QueryWrapper<Sample> wrapper = new QueryWrapper<>();
        wrapper.like("name", query.getName());
        // 执行分页查询
        Page<Sample> result = baseMapper.selectPage(page, wrapper);
        // 结果转换成DTO
        return PageDTO.create(result, src -> msSampleMapper.sampleToSampleDTO(src));
    }

    @Override
    public SampleDTO getById(int id) {
        Sample sample = baseMapper.selectById(id);
        if (sample != null) {
            return msSampleMapper.sampleToSampleDTO(sample);
        }
        return null;
    }
}

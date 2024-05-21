package com.zeroone.star.basicdata.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zeroone.star.basicdata.mapper.MdUnitMeasureMapper;
import com.zeroone.star.basicdata.service.IMdUnitMeasureService;
import com.zeroone.star.project.dto.j4.basicdata.entity.MdUnitMeasure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 单位表 服务实现类
 * </p>
 *
 * @author wxz
 * @since 2024-05-21
 */
@Service
public class MdUnitMeasureServiceImpl extends ServiceImpl<MdUnitMeasureMapper, MdUnitMeasure> implements IMdUnitMeasureService {

    @Autowired
    private MdUnitMeasureMapper mdUnitMeasureMapper;

    /**
     * 查询单位列表
     * @param mdUnitMeasure
     * @return
     */
    @Override
    public List<MdUnitMeasure> selectMdUnitMeasureList(MdUnitMeasure mdUnitMeasure) {
        return mdUnitMeasureMapper.selectMdUnitMeasureList(mdUnitMeasure);
    }
}

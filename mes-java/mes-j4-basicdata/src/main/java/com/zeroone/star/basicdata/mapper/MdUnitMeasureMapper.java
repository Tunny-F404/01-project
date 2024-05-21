package com.zeroone.star.basicdata.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zeroone.star.project.dto.j4.basicdata.entity.MdUnitMeasure;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 单位表 Mapper 接口
 * </p>
 *
 * @author wxz
 * @since 2024-05-21
 */
@Mapper
public interface MdUnitMeasureMapper extends BaseMapper<MdUnitMeasure> {

    /**
     * 查询单位列表
     * @param mdUnitMeasure
     * @return
     */
    List<MdUnitMeasure> selectMdUnitMeasureList(MdUnitMeasure mdUnitMeasure);
}

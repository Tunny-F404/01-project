package com.zeroone.star.basicdata.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zeroone.star.basicdata.entity.MdUnitMeasure;
import com.zeroone.star.project.dto.j4.basicdata.UnitExcelSelectDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * <p>
 * 单位表 Mapper 接口
 * </p>
 *
 * @author 本鼠
 * @since 2024-05-21
 */
@Mapper
public interface MdUnitMeasureMapper extends BaseMapper<MdUnitMeasure> {

    /*
    * 批量删除单位
    * */
    Long deleteByIds(List<Long> idList);

    /*
    * 根据条件查询单位数据
    * */
    List<MdUnitMeasure> listUnitMeasure(UnitExcelSelectDTO unitExcelSelectDTO);
}

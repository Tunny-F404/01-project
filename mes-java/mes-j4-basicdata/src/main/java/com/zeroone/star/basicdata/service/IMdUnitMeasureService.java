package com.zeroone.star.basicdata.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zeroone.star.project.dto.j4.basicdata.entity.MdUnitMeasure;

import java.util.List;

/**
 * <p>
 * 单位表 服务类
 * </p>
 *
 * @author wxz
 * @since 2024-05-21
 */
public interface IMdUnitMeasureService extends IService<MdUnitMeasure> {

    /**
     * 查询单位列表
     * @param mdUnitMeasure
     * @return
     */
    List<MdUnitMeasure> selectMdUnitMeasureList(MdUnitMeasure mdUnitMeasure);
}

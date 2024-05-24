package com.zeroone.star.basicdata.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.zeroone.star.basicdata.entity.MdUnitMeasure;
import com.zeroone.star.project.dto.j4.basicdata.UnitAddDTO;
import com.zeroone.star.project.dto.j4.basicdata.UnitExcelSelectDTO;
import com.zeroone.star.project.dto.j4.basicdata.UnitMeasureDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * <p>
 * 单位表 服务类
 * </p>
 *
 * @author 本鼠
 * @since 2024-05-21
 */
public interface IMdUnitMeasureService extends IService<MdUnitMeasure> {

    /*
    * 批量删除单位
    * */
    Long deleteByIds(List<Long> measureIds);

    /*
    * 导出单位数据
    * */
    ResponseEntity<byte[]> exportUnitMeasure(UnitExcelSelectDTO unitExcelSelectDTO);
    /**
     * 查询单位列表
     * @param mdUnitMeasure
     * @return
     */
    List<UnitMeasureDTO> selectMdUnitMeasureList(UnitMeasureDTO mdUnitMeasure);

    List<MdUnitMeasure> selectMdUnitMeasureList(MdUnitMeasure mdUnitMeasure);
    /**
     * 添加单位信心
     *  @param data 添加信息
     * @return 成功返回true,失败false
     */
    Boolean addUnit(UnitAddDTO data);

}

package com.zeroone.star.productManagement.mapper;

import com.zeroone.star.productManagement.entity.MdProductBom;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zeroone.star.project.j6.product_management.dto.BomDTO;
import org.apache.ibatis.annotations.Mapper;
/**
 * <p>
 * 产品BOM关系表 Mapper 接口
 * </p>
 *
 * @author panda
 * @since 2024-05-27
 */
@Mapper
public interface MdProductBomMapper extends BaseMapper<MdProductBom> {

}

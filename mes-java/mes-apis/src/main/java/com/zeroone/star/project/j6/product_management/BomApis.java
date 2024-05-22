package com.zeroone.star.project.j6.product_management;

import com.zeroone.star.project.j6.product_management.dto.BomDTO;
import com.zeroone.star.project.j6.product_management.query.BomQuery;
import com.zeroone.star.project.vo.JsonVO;

import java.util.List;

/**
 * <p>
 * 描述：BOM相关接口
 * </p>
 * <p>地址：</p>
 *
 * @author 熊猫
 * @version 1.0.0
 */
public interface BomApis {
    JsonVO<List<BomDTO>> queryBomList(BomQuery query);
    JsonVO<String> addBom(BomDTO dto);
    JsonVO<String> updateBom(BomDTO dto);
    JsonVO<String> deleteBOM(String bomId);
}

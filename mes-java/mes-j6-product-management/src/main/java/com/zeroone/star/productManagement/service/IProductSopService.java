package com.zeroone.star.productManagement.service;

import com.zeroone.star.project.j6.product_management.dto.ProductSopDTO;
import com.zeroone.star.project.j6.product_management.query.ProductSopQuery;

import java.util.List;

public interface IProductSopService {
   /***
            * 查询产品SOP列表
     * @param query 查询条件
     * @return 查询结果
     */
    List<ProductSopDTO> selectMdProductSopList(ProductSopQuery query);

    /**
     * 通过ID查询产品SOP
     * @param id 编号
     * @return 查询结果
     */
    ProductSopDTO selectMdProductSopById(Long id);

    /**
     * 新增产品SOP
     * @param dto 产品SOP
     */
    void insertMdProductSop(ProductSopDTO dto);

    /**
     * 修改产品SOP
     * @param dto 产品SOP
     */
    void updateMdProductSop(ProductSopDTO dto);

    /**
     * 批量删除产品SOP
     * @param ids 需要删除的产品SOP主键
     */
    void deleteMdProductSopByIds(Long[] ids);

}

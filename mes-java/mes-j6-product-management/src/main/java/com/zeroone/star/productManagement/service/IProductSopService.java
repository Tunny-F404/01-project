package com.zeroone.star.productManagement.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zeroone.star.productManagement.entity.ProductSop;
import com.zeroone.star.project.dto.PageDTO;
import com.zeroone.star.project.j6.product_management.dto.ProductSopDTO;
import com.zeroone.star.project.j6.product_management.query.ProductSopQuery;

import java.util.List;

public interface IProductSopService extends IService<ProductSop> {
   /***
    * 查询产品SOP列表
     * @param query 查询条件
     * @return 查询结果
     */
   PageDTO<ProductSopDTO> selectProductSopPage(ProductSopQuery query);

    /**
     * 通过ID查询产品SOP
     * @param id 编号
     * @return 查询结果
     */
    ProductSopDTO selectProductSopById(Long id);

    /**
     * 新增产品SOP
     * @param dto 产品SOP
     */
    void insertProductSop(ProductSopDTO dto);

    /**
     * 修改产品SOP
     * @param dto 产品SOP
     */
    void updateProductSop(ProductSopDTO dto);

    /**
     * 批量删除产品SOP
     * @param ids 需要删除的产品SOP主键
     */
    void deleteProductSopByIds(Long[] ids);

}

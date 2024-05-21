package com.zeroone.star.productManagement.service.impl;

import com.zeroone.star.project.j6.product_management.dto.ProductSopDTO;
import com.zeroone.star.project.j6.product_management.query.ProductSopQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
public class ProductSopServiceImpl {
    @Autowired
    private ProductSopMapper ProductSopMapper;

    @Override
    public List<ProductSopDTO> selectProductSopList(ProductSopQuery query) {
        return ProductSopMapper.selectProductSopList(query);
    }

    @Override
    public ProductSopDTO selectProductSopById(Long id) {
        return ProductSopMapper.selectProductSopById(id);
    }

    @Override
    public void insertProductSop(ProductSopDTO dto) {
        ProductSopMapper.insertProductSop(dto);
    }

    @Override
    public void updateProductSop(ProductSopDTO dto) {
        ProductSopMapper.updateProductSop(dto);
    }

    @Override
    public void deleteProductSopByIds(Long[] ids) {
        ProductSopMapper.deleteProductSopByIds(ids);
}

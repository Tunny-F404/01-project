package com.zeroone.star.productManagement.service.impl;

import com.alibaba.cloud.commons.lang.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zeroone.star.productManagement.entity.ProductSop;
import com.zeroone.star.productManagement.mapper.ProductSopMapper;
import com.zeroone.star.productManagement.service.IProductSopService;
import com.zeroone.star.project.components.fastdfs.FastDfsClientComponent;
import com.zeroone.star.project.components.fastdfs.FastDfsFileInfo;
import com.zeroone.star.project.dto.PageDTO;
import com.zeroone.star.project.j6.product_management.dto.ProductSopDTO;
import com.zeroone.star.project.j6.product_management.query.ProductSopQuery;
import io.swagger.annotations.ApiOperation;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProductSopServiceImpl extends ServiceImpl<ProductSopMapper, ProductSop> implements IProductSopService {
    @Autowired
    private ProductSopMapper ProductSopMapper;
    @Resource
    FastDfsClientComponent dfs;
    @Value("${fastdfs.nginx-servers}")
    String urlPrefix;
    @Override
    public PageDTO<ProductSopDTO> selectProductSopPage(ProductSopQuery query) {
        //构建分页条件对象
        Page page = new Page<>(query.getPageIndex(),query.getPageSize());
        //构建查询条件
        QueryWrapper<ProductSop> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(query.getSopTitle())) {
            queryWrapper.like("title",query.getSopTitle());
        }
        //执行查询
        page= baseMapper.selectPage(page,queryWrapper);
        PageDTO<ProductSopDTO> sop = PageDTO.create(page);
        return sop;
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
    @Override
    @SneakyThrows
    @ResponseBody
    @PostMapping("upload")
    @ApiOperation(value = "上传文件")
    public String uploadFile(MultipartFile file) {
        try {
            String filename = file.getOriginalFilename();
            assert filename != null;
            String suffix = filename.substring(filename.lastIndexOf(".") + 1);
            FastDfsFileInfo result = dfs.uploadFile(file.getBytes(), suffix);
            if (result != null) {
                return dfs.fetchUrl(result, "http://" + urlPrefix, true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

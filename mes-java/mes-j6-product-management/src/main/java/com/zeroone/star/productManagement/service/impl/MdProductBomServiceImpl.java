package com.zeroone.star.productManagement.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zeroone.star.productManagement.entity.MdProductBom;
import com.zeroone.star.productManagement.mapper.MdProductBomMapper;
import com.zeroone.star.productManagement.service.IMdProductBomService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zeroone.star.project.dto.PageDTO;
import com.zeroone.star.project.j6.product_management.dto.BomDTO;
import com.zeroone.star.project.j6.product_management.query.BomQuery;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import static com.baomidou.mybatisplus.extension.plugins.pagination.PageDTO.*;

@org.mapstruct.Mapper(componentModel = "spring")
interface MsProductBomMapper{
    BomDTO mdProductBomToBomDTO(MdProductBom mdProductBom);
}

/**
 * <p>
 * 产品BOM关系表 服务实现类
 * </p>
 *
 * @author panda
 * @since 2024-05-27
 */
@Service
public class MdProductBomServiceImpl extends ServiceImpl<MdProductBomMapper, MdProductBom> implements IMdProductBomService {

    @Resource
    MsProductBomMapper msProductBomMapper;

    @Override
    public boolean insertProductBom(BomDTO dto) {

        return false;
    }

    @Override
    public boolean updateProductBom(BomDTO dto) {
        return false;
    }

    @Override
    public boolean deleteProductBomByIds(List<Long> ids) {

        return false;
    }

    @Override
    public PageDTO<BomDTO> selectProductBomsPageByItemId(BomQuery query) {
        Page<MdProductBom> page = new Page<>(query.getPageIndex(),query.getPageSize());

        QueryWrapper<MdProductBom> wrapper = new QueryWrapper<>();
        wrapper.like("item_id",query.getItemId());

        Page<MdProductBom> result = baseMapper.selectPage(page,wrapper);

        return PageDTO.create(result,src -> msProductBomMapper.mdProductBomToBomDTO(src));
    }
}

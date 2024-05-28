package com.zeroone.star.productManagement.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zeroone.star.productManagement.entity.MdProductSip;
import com.zeroone.star.productManagement.mapper.MdProductSipMapper;
import com.zeroone.star.productManagement.service.IMdProductSipService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zeroone.star.project.dto.PageDTO;
import com.zeroone.star.project.j6.product_management.dto.SipDTO;
import com.zeroone.star.project.j6.product_management.query.SipQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@org.mapstruct.Mapper(componentModel = "spring")
interface MsProductSipMapper{
    SipDTO mdProductSipToSipDTO(MdProductSip mdProductBom);
}
/**
 * <p>
 * 产品SIP表 服务实现类
 * </p>
 *
 * @author xiebao
 * @since 2024-05-27
 */
@Service
public class MdProductSipServiceImpl extends ServiceImpl<MdProductSipMapper, MdProductSip> implements IMdProductSipService {


    @Resource
    MsProductSipMapper msProductSipMapper;

    @Autowired
    private MdProductSipMapper mdProductSipMapper;

    @Override
    public boolean insertProductSip(SipDTO dto) {
        int result = mdProductSipMapper.insertSip(dto);
        return result > 0;
    }

    @Override
    public boolean updateProductSip(SipDTO dto) {
        int result = mdProductSipMapper.updateSip(dto);
        return result > 0;
    }

    @Override
    public boolean deleteProductSipByIds(Long[] ids) {
        int result = mdProductSipMapper.deleteSip(ids);
        return result > 0;
    }

    @Override
    public PageDTO<SipDTO> selectProductSipPageByItemId(SipQuery query) {
        Page<MdProductSip> page = new Page<>(query.getPageIndex(),query.getPageSize());

        QueryWrapper<MdProductSip> wrapper = new QueryWrapper<>();
        wrapper.like("item_id",query.getItemId());

        Page<MdProductSip> result = baseMapper.selectPage(page,wrapper);

        return PageDTO.create(result,src -> msProductSipMapper.mdProductSipToSipDTO(src));
    }
}

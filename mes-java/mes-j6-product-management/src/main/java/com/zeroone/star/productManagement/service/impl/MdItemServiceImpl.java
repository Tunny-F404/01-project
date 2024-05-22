package com.zeroone.star.productManagement.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zeroone.star.productManagement.entity.MdItem;
import com.zeroone.star.productManagement.mapper.MdItemMapper;
import com.zeroone.star.productManagement.service.IMdItemService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zeroone.star.project.j6.product_management.query.MdItemQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 物料产品表 服务实现类
 * </p>
 *
 * @author xiaotian
 * @since 2024-05-20
 */
@Service
public class MdItemServiceImpl extends ServiceImpl<MdItemMapper, MdItem> implements IMdItemService {
    @Autowired
    private MdItemMapper mdItemMapper;

    public List<MdItem> getItemsByQuery(MdItemQuery mdItemQuery) {
        return mdItemMapper.getItemsByQuery(mdItemQuery);
    }
}

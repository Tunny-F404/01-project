package com.zeroone.star.basicdata.service.impl;

import com.zeroone.star.basicdata.entity.MdVendor;
import com.zeroone.star.basicdata.mapper.MdVendorMapper;
import com.zeroone.star.basicdata.service.IMdVendorService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zeroone.star.project.dto.j4.basicdata.VendorDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 供应商表 服务实现类
 * </p>
 *
 * @author zjx
 * @since 2024-05-20
 */
@Service
public class MdVendorServiceImpl extends ServiceImpl<MdVendorMapper, MdVendor> implements IMdVendorService {
    @Override
    public int addVendor(VendorDTO data){
        MdVendor mdVendor = new MdVendor();
        BeanUtils.copyProperties(mdVendor, data);
        return baseMapper.insert(mdVendor);
    }
}

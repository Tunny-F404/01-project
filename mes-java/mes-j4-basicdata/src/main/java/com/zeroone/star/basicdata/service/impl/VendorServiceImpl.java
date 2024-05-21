package com.zeroone.star.basicdata.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zeroone.star.basicdata.entity.MdVendor;
import com.zeroone.star.basicdata.mapper.VendorMapper;
import com.zeroone.star.basicdata.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendorServiceImpl extends ServiceImpl<VendorMapper, MdVendor> implements VendorService {

    @Autowired
    private VendorMapper vendorMapper;

    @Override
    public MdVendor getByVendorId(Long vendorId) {
        return vendorMapper.getById(vendorId);
    }

    @Override
    public void deleteVendors(List<Integer> ids) {
        ids.forEach(vendorId->{
            vendorMapper.deleteVendor(vendorId);
        });
    }
}

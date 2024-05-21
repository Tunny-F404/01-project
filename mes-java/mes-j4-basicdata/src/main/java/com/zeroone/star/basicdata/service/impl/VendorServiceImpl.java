package com.zeroone.star.basicdata.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zeroone.star.basicdata.entity.mdVendor;
import com.zeroone.star.basicdata.mapper.VendorMapper;
import com.zeroone.star.basicdata.service.VendorService;
import org.springframework.stereotype.Service;

@Service
public class VendorServiceImpl extends ServiceImpl<VendorMapper, mdVendor> implements VendorService {
}

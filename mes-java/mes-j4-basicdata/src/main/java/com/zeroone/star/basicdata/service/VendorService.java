package com.zeroone.star.basicdata.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zeroone.star.basicdata.entity.MdVendor;

import java.util.List;

public interface VendorService extends IService<MdVendor> {
    MdVendor getByVendorId(Long vendorId);

    void deleteVendors(List<Integer> ids);
}

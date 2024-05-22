package com.zeroone.star.basicdata.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zeroone.star.basicdata.entity.MdVendor;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface VendorMapper extends BaseMapper<MdVendor> {

    @Select("select * from md_vendor where vendor_id = #{vendorId}")
    MdVendor getById(Long vendorId);

    @Delete("delete from md_vendor where vendor_id = #{vendorId}")
    void deleteVendor(Integer vendorId);
}

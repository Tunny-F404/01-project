package com.zeroone.star.shopsettings.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zeroone.star.shopsettings.entity.WorkShop;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Mapper
public interface WorkShopMapper extends BaseMapper<WorkShop> {
    @Select("select workshop_name from md_workshop")
    List<String> queryWorkShopNameList();
}

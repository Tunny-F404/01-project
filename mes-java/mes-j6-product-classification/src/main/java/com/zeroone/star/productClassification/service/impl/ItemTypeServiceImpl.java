package com.zeroone.star.productClassification.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zeroone.star.productClassification.entity.ItemType;
import com.zeroone.star.productClassification.mapper.ItemTypeMapper;
import com.zeroone.star.productClassification.service.IItemTypeService;
import org.springframework.stereotype.Service;

@Service
public class ItemTypeServiceImpl extends ServiceImpl<ItemTypeMapper, ItemType> implements IItemTypeService {

}
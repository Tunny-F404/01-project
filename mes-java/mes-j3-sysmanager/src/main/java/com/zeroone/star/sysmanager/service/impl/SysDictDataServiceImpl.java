package com.zeroone.star.sysmanager.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.zeroone.star.project.components.user.UserDTO;
import com.zeroone.star.project.j3.dto.SysDictDataDTO;
import com.zeroone.star.sysmanager.entity.SysDictData;
import com.zeroone.star.sysmanager.mapper.SysDictDataMapper;
import com.zeroone.star.sysmanager.service.ISysDictDataService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 字典数据表 服务实现类
 * </p>
 *
 * @author Axe
 * @since 2024-05-24
 */
@Service
public class SysDictDataServiceImpl extends ServiceImpl<SysDictDataMapper, SysDictData> implements ISysDictDataService {
    @Resource
    private RedisTemplate<String,Object> redisTemplate;

    @Override
    public Integer saveDictData(SysDictDataDTO sysDictDataDTO, UserDTO currentUser) {
        //数据类型转换
        SysDictData sysDictData = new SysDictData();
        BeanUtils.copyProperties(sysDictDataDTO,sysDictData);
        sysDictData.setCreateBy(currentUser.getUsername());
        sysDictData.setCreateTime(LocalDateTime.now());
        //插入字典数据
        int row = baseMapper.insert(sysDictData);
        //如果插入成功则将与该字典数据同类型的字典数据放入Redis
        if(row > 0){
            //查询与该字典数据同类型的字典数据列表
            LambdaQueryWrapper<SysDictData> wrapper = new LambdaQueryWrapper<>();
            wrapper.eq(SysDictData::getDictType, sysDictDataDTO.getDictType());
            List<SysDictData> sysDictDataCacheList = baseMapper.selectList(wrapper);
            //存入redis,key为sys_dict:字典类型
            redisTemplate.opsForValue().set("sys_dict:"+sysDictDataDTO.getDictType(), sysDictDataCacheList);
        }else{
            throw new RuntimeException("新增字典数据失败");
        }
        return row;
    }
}

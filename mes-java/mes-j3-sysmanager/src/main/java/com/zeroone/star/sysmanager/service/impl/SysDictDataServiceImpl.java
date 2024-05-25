package com.zeroone.star.sysmanager.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.zeroone.star.project.j3.vo.DictDataNameVO;
import com.zeroone.star.sysmanager.entity.SysDictData;
import com.zeroone.star.sysmanager.mapper.SysDictDataMapper;
import com.zeroone.star.sysmanager.service.ISysDictDataService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

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
    RedisTemplate<String, List<SysDictData>> redisTemplate;

    @Override
    public List<DictDataNameVO> listDictDataNameByDictType(String dictType) {
        List<DictDataNameVO> dictDataNameVOS;
        List<SysDictData> sysDictDataList;
        //先查询redis中是否含有对应dictType
        String key = "sys_dict:" + dictType;//是否需要定义常量类?
        sysDictDataList = redisTemplate.opsForValue().get(key);
        //若redis中有, 则包装后直接返回
        if(sysDictDataList!=null&&!sysDictDataList.isEmpty()){
            dictDataNameVOS = sysDictDataList.stream()
                            .map(sysDictData -> {
                                DictDataNameVO dictDataNameVO = new DictDataNameVO();
                                BeanUtils.copyProperties(sysDictData, dictDataNameVO);
                                return dictDataNameVO;
                            })
                            .collect(Collectors.toList());
            return dictDataNameVOS;
        }
        //若redis没有, 则查询mysql
        LambdaQueryWrapper<SysDictData> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(StringUtils.hasText(dictType), SysDictData::getDictType, dictType);
        wrapper.eq(SysDictData::getStatus, "0"); //是否需要定义常量类?
        wrapper.orderByAsc(SysDictData::getDictSort);
        sysDictDataList = list(wrapper);
        //若mysql查询不到, 则不存在该dictType, 抛出异常
        if(sysDictDataList==null||sysDictDataList.isEmpty())
            throw new RuntimeException("非法字典类型, 无对应字典数据");
        //若mysql有, 则读入redis并返回结果
        redisTemplate.opsForValue().set(key, sysDictDataList);
        dictDataNameVOS =
                sysDictDataList.stream()
                .map(sysDictData -> {
                    DictDataNameVO dictDataNameVO = new DictDataNameVO();
                    BeanUtils.copyProperties(sysDictData, dictDataNameVO);
                    return dictDataNameVO;
                })
                .collect(Collectors.toList());
        return dictDataNameVOS;
    }
}

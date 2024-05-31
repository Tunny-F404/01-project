package com.zeroone.star.sysmanager.service.impl;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zeroone.star.project.components.easyexcel.EasyExcelComponent;
import com.zeroone.star.project.j3.query.dict.SysDictTypeModifyQuery;
import com.zeroone.star.project.j3.query.dict.SysDictTypeQuery;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.sysmanager.entity.SysDictData;
import com.zeroone.star.sysmanager.entity.SysDictType;
import com.zeroone.star.sysmanager.mapper.SysDictDataMapper;
import com.zeroone.star.sysmanager.mapper.SysDictTypeMapper;
import com.zeroone.star.sysmanager.service.ISysDictTypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.SneakyThrows;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.ByteArrayOutputStream;
import java.util.*;
import java.util.stream.Collectors;

/**
 * <p>
 * 字典类型表 服务实现类
 * </p>
 *
 * @author Axe
 * @since 2024-05-24
 */
@Service
public class SysDictTypeServiceImpl extends ServiceImpl<SysDictTypeMapper, SysDictType> implements ISysDictTypeService {

    @Autowired
    EasyExcelComponent excel;

    @Autowired
    SysDictTypeMapper sysDictTypeMapper;

    @Autowired
    SysDictDataMapper sysDictDataMapper;

    @Autowired
    RedisTemplate redisTemplate;

    public static final String SYS_DICT_KEY = "sys_dict:";

    /**
     * 编辑修改字典数据
     *
     * @param sysDictTypeModifyQuery
     * @return
     */
    @Override
    public JsonVO<Integer> editDictType(SysDictTypeModifyQuery sysDictTypeModifyQuery) {
        // 校验字典类型是否唯一
        SysDictType sysDictType = sysDictTypeMapper.selectByType(sysDictTypeModifyQuery.getDictType());
        if(sysDictType!=null&&sysDictType.getDictId().longValue()!=sysDictTypeModifyQuery.getDictId().longValue()){
            return JsonVO.create(null,500,"修改字典'" + sysDictTypeModifyQuery.getDictName() + "'失败，字典类型已存在");
        }
        //查询原来的
        SysDictType oldDict = sysDictTypeMapper.selectById(sysDictTypeModifyQuery.getDictId());
        //根据原来的进行同步修改字典数据信息
        SysDictType dict = new SysDictType();
        BeanUtils.copyProperties(sysDictTypeModifyQuery,dict);
        sysDictDataMapper.updateDictDataType(oldDict.getDictType(), dict.getDictType());
        //修改字典类型信息
        int row = sysDictTypeMapper.updateById(dict);
        if (row > 0)
        {
            //修改成功后，更新一下字典数据的缓存
            List<SysDictData> dictDatas = sysDictDataMapper.selectDictDataByType(dict.getDictType());
            //DictUtils.setDictCache(dict.getDictType(), dictDatas);
            redisTemplate.opsForValue().set(dict.getDictType(),dictDatas);
        }
        return JsonVO.success(row);
    }

    /**
     * 批量删除字典数据
     *
     * @param dictListIds
     * @return
     */
    @Override
    public JsonVO<Integer> deleteDictType(Long[] dictListIds) {
        List<Long> message = new ArrayList<>();
        int row = 0;
        for (Long dictId : dictListIds) {
            //查询字典数据表
            SysDictType sysDictType = sysDictTypeMapper.selectById(dictId);
            int count =  sysDictDataMapper.countDictDataByType(sysDictType.getDictType());
            if(count>0) {
                message.add(dictId);
                continue;
            }
            //进行删除操作
            row += sysDictTypeMapper.deleteDictTypeById(dictId);
            //清楚对应的缓存  todo 确认key的前缀是什么
            redisTemplate.delete(sysDictType.getDictType());
        }
        StringBuilder mes = new StringBuilder();
        if(message.size()>0){
            for (Long aLong : message) {
                mes.append(aLong);
                mes.append(" ");
            }
            mes.append("已分配，不可删除");
            return JsonVO.create(row,200,mes.toString());
        }
        return JsonVO.success(row);
    }

    /**
     * 获取导出字典数据流
     * @param sysDictTypeQuery
     * @return
     */
    @Override
    @SneakyThrows
    public byte[] exportDictType(SysDictTypeQuery sysDictTypeQuery) {
        // 构建一个输出流
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        // 导出数据到输出流
        List<SysDictType> sysDictTypeList = sysDictTypeMapper.selectList(new QueryWrapper<>());
        excel.export("测试", out, SysDictType.class, sysDictTypeList);
        return out.toByteArray();
    }

    /**
     * 刷新字典数据
     */
    @Override
    public Void refreshCache() {

        //清空所有字典数据
        //获取hash表中多个key
        Set keys = redisTemplate.keys(SYS_DICT_KEY + "*");
        redisTemplate.delete(keys);
        //查询所有字典数据，并存入缓存
        SysDictData dictData = new SysDictData();
        dictData.setStatus("0");
        Map<String, List<SysDictData>> dictDataMap = sysDictDataMapper.selectDictDataList(dictData).stream().collect(Collectors.groupingBy(SysDictData::getDictType));
        for (Map.Entry<String, List<SysDictData>> entry : dictDataMap.entrySet())
        {
            //DictUtils.setDictCache(entry.getKey(), entry.getValue().stream().sorted(Comparator.comparing(SysDictData::getDictSort)).collect(Collectors.toList()));
            redisTemplate.opsForValue().set(entry.getKey(), entry.getValue().stream().sorted(Comparator.comparing(SysDictData::getDictSort)).collect(Collectors.toList()));
        }
        return null;
    }
}

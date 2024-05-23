package com.zeroone.star.sysmanagement.service.impl;

import cn.hutool.core.date.DateTime;
import com.zeroone.star.project.components.easyexcel.EasyExcelComponent;
import com.zeroone.star.project.j2.sysmanagement.dto.param.ParameterDTO;
import com.zeroone.star.sysmanagement.Constants.configConstants;
import com.zeroone.star.sysmanagement.entity.parameterDO;
import com.zeroone.star.sysmanagement.mapper.SysConfigMapper;
import com.zeroone.star.sysmanagement.mapstruct.parameterMapstruct;
import com.zeroone.star.sysmanagement.service.ISysConfigService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.SneakyThrows;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Set;


/**
 * <p>
 * 参数配置表 服务实现类
 * </p>
 *
 * @author sishijin
 * @since 2024-05-22
 */

@Service
public class SysConfigServiceImpl extends ServiceImpl<SysConfigMapper, parameterDO> implements ISysConfigService {
    // 参数映射 领域模型转换
    @Resource
    private parameterMapstruct parameterMapstruct;

    // redis组件
    @Resource
    private RedisTemplate redisTemplate;

    //dao层
    @Resource
    private SysConfigMapper sysConfigMapper;

    // 导入easyExcel组件
    @Resource
    EasyExcelComponent excelComponent;


    // 项目启动时，初始化参数到缓存
    @PostConstruct
    public void init()
    {
        loadConfigCache();
    }


    @Override
    public void refreshCache() {
        //1.清空redis缓存
        clearConfigCache();
        //2.将数据库数据缓存到redis中
        loadConfigCache();
    }

    /**
     * @description: 将数据库数据缓存到redis中
     * @author: 40斤
     * @date: 2024/5/23 10:42
     * @param: []
     * @return: void
     **/
    private void loadConfigCache() {
        //1.从数据库中查询所有数据
        List<parameterDO> parameterDOS = sysConfigMapper.selectList(null);
        if (parameterDOS.isEmpty()) {
            return;
        }
        //2.将数据保存到redis中
        for (parameterDO parameterDO : parameterDOS) {
            if (parameterDO.getConfigKey()!=null&&parameterDO.getConfigValue()!=null){
                redisTemplate.opsForValue().set(configConstants.SYS_CONFIG_KEY+ parameterDO.getConfigKey(),
                        parameterDO.getConfigValue());
            }

        }
    }
    /**
     * @description:    清除redis缓存
     * @author: 40斤
     * @date: 2024/5/23 14:12
     * @param: []
     * @return: void
     **/
    private void clearConfigCache() {
        Set<String> keys = redisTemplate.keys(configConstants.SYS_CONFIG_KEY + "*");
        if (keys==null||keys.isEmpty()){
            return;
        }
        redisTemplate.delete(keys);
    }

    @Override
    public void removeParameterList(List<Integer> ids) {
        //根据ids遍历每一个sysConfig
        for (Integer id : ids) {
            //1.根据id到数据库中查询对应的redis的key
            parameterDO parameterDO = sysConfigMapper.selectById(id);
            //2.删除数据库中的数据
            //2.1判断类型是否为系统内置
            if (parameterDO.getConfigType().equals(configConstants.YES)){
                //2.1.1是系统内置，则不能删除
                throw new RuntimeException("系统内置参数不能删除");
            }
            //2.2不是系统内置，则删除
            sysConfigMapper.deleteById(id);
            //3.根据key删除redis的数据
            redisTemplate.delete(configConstants.SYS_CONFIG_KEY+ parameterDO.getConfigKey());
        }
    }

    @SneakyThrows
    @Override
    public ResponseEntity<byte[]> exportParameter() {
        //1.从数据库中查询所有数据
        List<parameterDO> parameterDOS = sysConfigMapper.selectList(null);
        //2.转换领域模型
        List<ParameterDTO> parameterDTOS = parameterMapstruct.DOs2DTOs(parameterDOS);
        for (ParameterDTO parameterDTO : parameterDTOS) {
            if (parameterDTO.getConfigType().equalsIgnoreCase(configConstants.YES)){
                parameterDTO.setConfigType("是");
            }else {
                parameterDTO.setConfigType("否");
            }
        }
        //3.easyexcel构建输出流
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        excelComponent.export("配置导出",out, ParameterDTO.class, parameterDTOS);
        //4.构建响应结果
        byte[] bytes = out.toByteArray();
        out.close();
        //5.构建响应头
        HttpHeaders headers = new HttpHeaders();
        String filename= configConstants.EXPORT_CONFIG_PREFIX                   //文件名前缀
                + DateTime.now().toString(configConstants.EXPORT_CONFIG_TIME)   //文件名内容（时间）
                +configConstants.EXPORT_CONFIG_SUFFIX;                          //文件名后缀
        headers.setContentDispositionFormData("attachment",filename);
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        //6.返回响应结果
        return new ResponseEntity<>(bytes,headers, HttpStatus.CREATED);
    }
}

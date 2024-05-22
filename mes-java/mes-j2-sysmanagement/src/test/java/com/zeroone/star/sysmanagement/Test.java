package com.zeroone.star.sysmanagement;

import com.zeroone.star.project.j2.sysmanagement.dto.param.ParameterDTO;
import com.zeroone.star.sysmanagement.entity.ParameterDO;
import com.zeroone.star.sysmanagement.mapper.ParameterMapper;
import com.zeroone.star.sysmanagement.service.ParameterService;
import org.junit.runner.RunWith;
import org.mapstruct.Mapper;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Date;
import java.util.List;



/**
 * 描述： TODO
 *
 * @Author hui
 * @Version 1.0
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class Test {

    @Resource
    ParameterMapper mapper;

    @Resource
    ParameterService service;

    @org.junit.Test
    public void test01(){
        List<Integer> ids = Arrays.asList(1,2,3);
        List<ParameterDO> parameterDOS = mapper.selectBatchIds(ids);
        parameterDOS.forEach(System.out::println);
    }

    @org.junit.Test
    public void deleteTest(){
        List<Integer> ids = Arrays.asList(11);
        int i = mapper.deleteBatchIds(ids);
        System.out.println(i);
    }

    @org.junit.Test
    public void addTest(){
        ParameterDTO parameterDTO = new ParameterDTO();
        parameterDTO.setConfigName("date");
        parameterDTO.setConfigKey("key1");
        parameterDTO.setConfigValue("testDAte");
        parameterDTO.setCreateTime(new Date());
        int insert = service.saveParameter(parameterDTO);
        System.out.println(insert);
    }
}

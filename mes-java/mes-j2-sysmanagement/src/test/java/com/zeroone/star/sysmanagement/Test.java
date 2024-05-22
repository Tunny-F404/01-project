package com.zeroone.star.sysmanagement;

import com.zeroone.star.project.j2.sysmanagement.dto.param.ParameterDTO;
import com.zeroone.star.sysmanagement.entity.ParameterDO;
import com.zeroone.star.sysmanagement.mapper.ParameterMapper;
import org.junit.runner.RunWith;
import org.mapstruct.Mapper;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@Mapper(componentModel = "spring")
interface MsParameterMapper{

    ParameterDO paraDtoToDo(ParameterDTO parameterDTO);
}

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
        ParameterDO parameterDO = new ParameterDO();
        parameterDO.setConfigName("test");
        parameterDO.setConfigKey("key1");
        parameterDO.setConfigValue("hjydashabi");
        int insert = mapper.insert(parameterDO);
        System.out.println(insert);
    }
}

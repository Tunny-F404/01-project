package com.zeroone.star.sysmanagement;

import com.zeroone.star.sysmanagement.entity.ParameterDO;
import com.zeroone.star.sysmanagement.mapper.ParameterMapper;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Arrays;
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

    @org.junit.Test
    public void test01(){
        List<Integer> ids = Arrays.asList(1,2,3);
        List<ParameterDO> parameterDOS = mapper.selectBatchIds(ids);
        parameterDOS.forEach(System.out::println);
    }
}

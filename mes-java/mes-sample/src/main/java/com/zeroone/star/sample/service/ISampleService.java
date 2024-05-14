package com.zeroone.star.sample.service;

import com.zeroone.star.project.dto.PageDTO;
import com.zeroone.star.project.dto.sample.SampleDTO;
import com.zeroone.star.project.query.sample.SampleQuery;
import com.zeroone.star.sample.entity.Sample;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 演示示例表 服务类
 * </p>
 *
 * @author awei
 * @since 2024-05-10
 */
public interface ISampleService extends IService<Sample> {
    /**
     * 分页查询所有数据
     * @param query 查询条件
     * @return 查询结果
     */
    PageDTO<SampleDTO> listAll(SampleQuery query);

    /**
     * 通过Id查询数据
     * @param id ID
     * @return 查询结果
     */
    SampleDTO getById(int id);

    /**
     * 测试seata声明式服务调用
     * @return 执行结果
     */
    int testSeata();
}

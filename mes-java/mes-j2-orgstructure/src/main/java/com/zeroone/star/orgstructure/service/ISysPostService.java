package com.zeroone.star.orgstructure.service;

import com.zeroone.star.orgstructure.entity.SysPost;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zeroone.star.project.j2.orgstructure.dto.job.JobDTO;
import org.springframework.http.ResponseEntity;

/**
 * <p>
 * 岗位信息表 服务类
 * </p>
 *
 * @author 爱吃猫的鱼
 * @since 2024-05-22
 */
public interface ISysPostService extends IService<SysPost> {

    boolean saveJob(JobDTO jobDTO);

    boolean removeJob(Long[] ids);

    boolean modifyJob(JobDTO jobDTO);

    ResponseEntity<byte[]> download();
}

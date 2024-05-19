package com.zeroone.star.project.j2.orgstructure.job;

import com.zeroone.star.project.j2.orgstructure.dto.job.JobDTO;
import com.zeroone.star.project.vo.ResultStatus;
import org.springframework.http.ResponseEntity;

/**
 * @author 爱吃猫的鱼
 * @version 1.0.0
 * @Description:岗位相关API
 */
public interface JobApis {

    //添加岗位
    ResultStatus addJob(JobDTO jobDTO);

    //删除岗位
    ResultStatus removeJob(Long[] ids);

    //修改岗位
    ResultStatus modifyJob(JobDTO jobDTO);

    //导出岗位文件
    ResponseEntity<byte[]> exportJob(String group, String storageId);
}

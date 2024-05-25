package com.zeroone.star.orgstructure.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zeroone.star.orgstructure.entity.PostDO;
import com.zeroone.star.orgstructure.entity.UserAndPsotDO;
import com.zeroone.star.orgstructure.mapper.PostMapper;
import com.zeroone.star.orgstructure.mapper.UserMapper;
import com.zeroone.star.orgstructure.mapper.UserAndPostMapper;
import com.zeroone.star.orgstructure.service.PostService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zeroone.star.project.components.user.UserDTO;
import com.zeroone.star.project.components.user.UserHolder;
import com.zeroone.star.project.j2.orgstructure.dto.job.JobDTO;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.ByteArrayOutputStream;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

/**
 * <p>
 * 岗位信息表 服务实现类
 * </p>
 *
 * @author 爱吃猫的鱼
 * @since 2024-05-22
 */
@Service
@RequiredArgsConstructor
public class PostServiceImpl extends ServiceImpl<PostMapper, PostDO> implements PostService {


    @Resource
    private PostMapper postMapper;

    @Resource
    private UserAndPostMapper userAndPostMapper;

    @Resource
    private UserMapper userMapper;

    @Resource
    private UserHolder userHolder;

    /**
     * 新增岗位
     *
     * @param jobDTO
     * @return
     */
    @SneakyThrows
    @Override
    public boolean execSaveJob(JobDTO jobDTO) {
        try {
            // 复制属性
            PostDO postDO = BeanUtil.copyProperties(jobDTO, PostDO.class);

            // 设置创建时间
            postDO.setCreateTime(LocalDateTime.now());

            // 获取当前登录人
            //TODO 获取当前登录人（暂时默认为defult）
            UserDTO currentUser;
            currentUser = userHolder.getCurrentUser();

            if (currentUser != null) {
                postDO.setCreateBy(currentUser.getUsername());
            }else {
                postDO.setCreateBy("defult");
            }

            // 保存sysPost
            return save(postDO);
        } catch (Exception e) {
            // 记录异常日志，或者根据需求进行其他处理
            e.printStackTrace();
            // 返回保存失败的标志
            return false;
        }
    }


    /**
     * 删除岗位
     *
     * @param ids
     * @return
     */
    @Override
    @Transactional
    public boolean execRemoveJob(Long[] ids) {
        try {
            HashMap<Long, List<Long>> map = new HashMap<Long, List<Long>>();
            // 先查询岗位下的用户
            for (Long id : ids) {
                List<Long> userids = userAndPostMapper.selectBypostId(id);
                map.put(id, userids);
            }
            //遍历map，删除岗位下的用户
            for (Long id : ids) {
                List<Long> userids = map.get(id);
                if (userids != null && !userids.isEmpty()) {
                    userMapper.deleteBatchIds(userids);
                }
            }
            //删除用户与岗位的关联关系
            userAndPostMapper.delete(new QueryWrapper<UserAndPsotDO>().in("post_id", ids));
            // 删除岗位
            return removeByIds(Arrays.asList(ids));
        } catch (Exception e) {
            // 记录异常日志，或者根据需求进行其他处理
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 修改岗位
     *
     * @param jobDTO
     * @return
     */
    @SneakyThrows
    @Override
    public boolean execModifyJob(JobDTO jobDTO) {
        try {
            PostDO postDO = BeanUtil.copyProperties(jobDTO, PostDO.class);

            // 设置更新时间
            postDO.setUpdateTime(LocalDateTime.now());

            // 获取当前登录人
            //TODO 获取当前登录人（暂时默认为defult）
            UserDTO currentUser;
            currentUser = userHolder.getCurrentUser();
            if (currentUser != null) {
                postDO.setUpdateBy(currentUser.getUsername());
            }else{
                postDO.setUpdateBy("defult");
            }


            // 更新sysPost
            return updateById(postDO);
        } catch (Exception e) {
            // 记录异常日志，或者根据需求进行其他处理
            e.printStackTrace();
            // 返回更新失败的标志
            return false;
        }
    }


    /**
     * 导出岗位信息
     *
     * @return
     */
    @Override
    public ResponseEntity<byte[]> download() {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.select("post_id", "post_name", "post_code", "post_sort", "status", "remark");
        List<PostDO> posts = postMapper.selectList(queryWrapper);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        EasyExcel.write(out, PostDO.class).sheet("岗位信息").doWrite(posts);
        // 获取字节数组
        byte[] byteArray = out.toByteArray();
        String fileName = UUID.randomUUID().toString() + ".xlsx";
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentDispositionFormData("attachment", fileName);
        httpHeaders.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        // 返回响应
        return ResponseEntity.ok().headers(httpHeaders).body(byteArray);
    }
}

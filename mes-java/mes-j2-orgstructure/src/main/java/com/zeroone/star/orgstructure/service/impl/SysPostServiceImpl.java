package com.zeroone.star.orgstructure.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zeroone.star.orgstructure.client.LoginClient;
import com.zeroone.star.orgstructure.entity.SysPost;
import com.zeroone.star.orgstructure.mapper.SysPostMapper;
import com.zeroone.star.orgstructure.mapper.SysUserMapper;
import com.zeroone.star.orgstructure.mapper.SysUserPostMapper;
import com.zeroone.star.orgstructure.service.ISysPostService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zeroone.star.project.j2.orgstructure.dto.job.JobDTO;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.login.LoginVO;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.io.ByteArrayOutputStream;
import java.io.DataInput;
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
public class SysPostServiceImpl extends ServiceImpl<SysPostMapper, SysPost> implements ISysPostService {

    private final LoginClient loginClient;

    @Resource
    private SysPostMapper sysPostMapper;

    @Resource
    private SysUserPostMapper sysUserPostMapper;

    @Resource
    private SysUserMapper sysUserMapper;

    /**
     * 新增岗位
     * @param jobDTO
     * @return
     */
    @SneakyThrows
    @Override
    public boolean saveJob(JobDTO jobDTO) {
        try {
            // 复制属性
            SysPost sysPost = BeanUtil.copyProperties(jobDTO, SysPost.class);

            // 设置创建时间
            sysPost.setCreateTime(LocalDateTime.now());

            // 获取当前登录人
            //TODO 获取当前登录人
            JsonVO<LoginVO> currUser = loginClient.getCurrUser();
            LoginVO loginVO = currUser.getData();
            if (loginVO != null) {
                sysPost.setCreateBy(loginVO.getUsername());
            } else {
                // 处理获取登录人信息失败的情况，例如设置默认值或者抛出自定义异常
                throw new RuntimeException("未得到当前登录用户信息");
            }

            // 保存sysPost
            return save(sysPost);
        } catch (Exception e) {
            // 记录异常日志，或者根据需求进行其他处理
            e.printStackTrace();
            // 返回保存失败的标志
            return false;
        }
    }


    /**
     * 删除岗位
     * @param ids
     * @return
     */
    @Override
    @Transactional
    public boolean removeJob(Long[] ids) {
        try {
            HashMap<Long, List<Long>> map = new HashMap<Long, List<Long>>();
            // 先查询岗位下的用户
            for (Long id : ids) {
                List<Long> userids = sysUserPostMapper.selectBypostId(id);
                map.put(id, userids);
            }
            //遍历map，删除岗位下的用户
            for (Long id : ids) {
                List<Long> userids = map.get(id);
                if (userids != null&&!userids.isEmpty()) {
                    sysUserMapper.deleteBatchIds(userids);
                }
            }
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
     * @param jobDTO
     * @return
     */
    @SneakyThrows
    @Override
    public boolean modifyJob(JobDTO jobDTO) {
        try {
            SysPost sysPost = BeanUtil.copyProperties(jobDTO, SysPost.class);

            // 设置更新时间
            sysPost.setUpdateTime(LocalDateTime.now());

            // 获取当前登录人
            //TODO 获取当前登录人
            JsonVO<LoginVO> currUser = loginClient.getCurrUser();
            LoginVO loginVO = currUser.getData();
            if (loginVO != null) {
                sysPost.setUpdateBy(loginVO.getUsername());
            } else {
                // 处理获取登录人信息失败的情况，例如设置默认值或者抛出自定义异常
                throw new RuntimeException("未得到当前登录用户信息");
            }

            // 更新sysPost
            return updateById(sysPost);
        } catch (Exception e) {
            // 记录异常日志，或者根据需求进行其他处理
            e.printStackTrace();
            // 返回更新失败的标志
            return false;
        }
    }


    @Override
    public ResponseEntity<byte[]> download(){
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.select("post_id","post_name","post_code","post_sort","status","remark");
        List<SysPost> posts = sysPostMapper.selectList(queryWrapper);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        EasyExcel.write(out, SysPost.class).sheet("岗位信息").doWrite(posts);
        // 获取字节数组
        byte[] byteArray = out.toByteArray();
        String fileName = UUID.randomUUID().toString()+".xlsx";
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentDispositionFormData("attachment", fileName);
        httpHeaders.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        // 返回响应
        return ResponseEntity.ok().headers(httpHeaders).body(byteArray);
    }
}

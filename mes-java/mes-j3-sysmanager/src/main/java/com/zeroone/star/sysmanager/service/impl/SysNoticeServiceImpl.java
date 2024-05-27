package com.zeroone.star.sysmanager.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.zeroone.star.project.j3.dto.NoticeDTO;
import com.zeroone.star.sysmanager.entity.SysNotice;
import com.zeroone.star.sysmanager.mapper.SysNoticeMapper;
import com.zeroone.star.sysmanager.service.ISysNoticeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * <p>
 * 通知公告表 服务实现类
 * </p>
 *
 * @author Axe
 * @since 2024-05-24
 */
@Service
public class SysNoticeServiceImpl extends ServiceImpl<SysNoticeMapper, SysNotice> implements ISysNoticeService {

    @Autowired
    private SysNoticeMapper sysNoticeMapper;
    /**
     * 更新公告
     * @param noticeDTO
     */
    @Override
    public void updateNotice(NoticeDTO noticeDTO) {
        // 1. 验证参数是否为空
        if (noticeDTO == null) {
            throw new RuntimeException("公告信息不能为空");
        }
        //根据id修改公告
        LambdaQueryWrapper<SysNotice> sysNoticeQueryWrapper = new LambdaQueryWrapper<>();
        sysNoticeQueryWrapper.eq(SysNotice::getNoticeId, noticeDTO.getId());
        SysNotice sysNotice = new SysNotice();
        // 3. 将noticeDTO中的属性复制到sysNotice中
        BeanUtils.copyProperties(noticeDTO,sysNotice);
        // 4. 保存更新后的公告到数据库
        sysNotice.setUpdateTime(LocalDateTime.now());
        sysNoticeMapper.update(sysNotice,sysNoticeQueryWrapper);
    }

}

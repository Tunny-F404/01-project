package com.zeroone.star.mongo.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.zeroone.star.mongo.dto.MemberReadHistoryDTO;
import com.zeroone.star.mongo.entity.MemberReadHistory;
import com.zeroone.star.mongo.mapper.MemberReadHistoryRepository;
import com.zeroone.star.mongo.service.MemberReadHistoryService;
import com.zeroone.star.mongo.vo.MemberReadHistoryVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 描述：会员浏览记录管理Service实现类
 * </p>
 * <p>版权：&copy;01星球</p>
 * <p>地址：01星球总部</p>
 * @author 阿伟学长
 * @version 1.0.0
 */
@Service
public class MemberReadHistoryServiceImpl implements MemberReadHistoryService {
    @Resource
    private MemberReadHistoryRepository memberReadHistoryRepository;

    @Override
    public int save(MemberReadHistoryDTO memberReadHistory) {
        MemberReadHistory history = new MemberReadHistory();
        BeanUtil.copyProperties(memberReadHistory, history, true);
        history.setCreateTime(new Date());
        memberReadHistoryRepository.save(history);
        return 1;
    }

    @Override
    public int remove(List<String> ids) {
        List<MemberReadHistory> deleteList = new ArrayList<>();
        for (String id : ids) {
            MemberReadHistory memberReadHistory = new MemberReadHistory();
            memberReadHistory.setId(id);
            deleteList.add(memberReadHistory);
        }
        memberReadHistoryRepository.deleteAll(deleteList);
        return ids.size();
    }

    @Override
    public List<MemberReadHistoryVO> list(Long memberId) {
        List<MemberReadHistory> result = memberReadHistoryRepository.findByMemberIdOrderByCreateTimeDesc(memberId);
        List<MemberReadHistoryVO> vl = new ArrayList<>();
        for (MemberReadHistory history : result) {
            MemberReadHistoryVO vo = new MemberReadHistoryVO();
            BeanUtil.copyProperties(history, vo, true);
            vl.add(vo);
        }
        return vl;
    }
}

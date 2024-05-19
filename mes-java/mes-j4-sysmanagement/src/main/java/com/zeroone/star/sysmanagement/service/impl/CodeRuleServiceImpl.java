package com.zeroone.star.sysmanagement.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zeroone.star.project.dto.PageDTO;
import com.zeroone.star.project.dto.j4.sysmanagement.coderule.CodeRuleDTO;
import com.zeroone.star.project.query.j4.sysmanagement.coderule.CodeRuleQuery;
import com.zeroone.star.sysmanagement.entity.CodeRule;
import com.zeroone.star.sysmanagement.mapper.CodeRuleMapper;
import com.zeroone.star.sysmanagement.mapper.MsCodeRuleMapper;
import com.zeroone.star.sysmanagement.service.ICodeRuleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 编码生成规则表 服务实现类
 * </p>
 *
 * @author jm
 * @since 2024-05-19
 */
@Service
public class CodeRuleServiceImpl extends ServiceImpl<CodeRuleMapper, CodeRule> implements ICodeRuleService {
    @Autowired
    private CodeRuleMapper codeRuleMapper;
    @Resource
    private MsCodeRuleMapper msCodeRuleMapper;
//  删除编码规则（支持批量删除）
    @Override
    public void removeCodeRule(List<String> ruleIds) {
        codeRuleMapper.deleteBatchIds(ruleIds);
    }

    /**
     * 分页查询
     * @param codeRuleQuery
     * @return
     */
    @Override
    public PageDTO<CodeRuleDTO> listCodeRules(CodeRuleQuery codeRuleQuery) {
//        构建分页查询对象
        Page<CodeRule> page = new Page<>(codeRuleQuery.getPageIndex(), codeRuleQuery.getPageSize());
//        构建查询条件
        QueryWrapper<CodeRule> wrapper = new QueryWrapper<CodeRule>()
                .like(codeRuleQuery.getRuleName() != null,"rule_name", codeRuleQuery.getRuleName())
                .like(codeRuleQuery.getRuleCode() != null,"rule_code", codeRuleQuery.getRuleCode())
                .eq(codeRuleQuery.getEnableFlag() != null,"enable_flag", codeRuleQuery.getEnableFlag());
//        进行分页查询
        Page<CodeRule> codeRulePage = codeRuleMapper.selectPage(page, wrapper);
//        将do对象转换为dto对象
//        PageDTO<CodeRuleDTO> pageDTO = PageDTO.create(codeRulePage, src -> msCodeRuleMapper.toCodeRuleDTO(src));
        PageDTO<CodeRuleDTO> codeRuleDTOPage = new PageDTO<>();
        /*
        使用BeanUtil.copyProperties来从Page<CodeRule>复制属性到PageDTO<CodeRuleDTO>。这种方法会复制分页信息（如总页数、当前页数等），
        但不会复制数据记录（Page对象中的records属性）。
         */
        BeanUtil.copyProperties(codeRulePage, codeRuleDTOPage);

        List<CodeRuleDTO> recordsDTO = new ArrayList<>();
        for (CodeRule codeRule : codeRulePage.getRecords()) {
            CodeRuleDTO codeRuleDTO = new CodeRuleDTO();
            BeanUtil.copyProperties(codeRule, codeRuleDTO);
            recordsDTO.add(codeRuleDTO);
        }
        codeRuleDTOPage.setRows(recordsDTO);
        return codeRuleDTOPage;
    }

    /**
     * 新增编码规则
     * @param codeRuleDTO 编码规则
     */
    @Override
    public void saveCodeRule(CodeRuleDTO codeRuleDTO) {
//        将dto数据转换为do
//        CodeRule codeRule = msCodeRuleMapper.toCodeRule(codeRuleDTO);
        CodeRule codeRule = new CodeRule();
        BeanUtil.copyProperties(codeRuleDTO, codeRule);
        codeRuleMapper.insert(codeRule);
    }

    /**
     * 修改编码规则
     * @param codeRuleDTO 编码规则
     */
    @Override
    public void updateCodeRule(CodeRuleDTO codeRuleDTO) {
//        将dto数据转换为do
//        CodeRule codeRule = msCodeRuleMapper.toCodeRule(codeRuleDTO);
        CodeRule codeRule = new CodeRule();
        BeanUtil.copyProperties(codeRuleDTO, codeRule);
        codeRuleMapper.updateById(codeRule);
    }
}

package com.zeroone.star.seata.controller;

import com.zeroone.star.seata.service.TransService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 描述：测试远程事务调用
 * </p>
 * <p>版权：&copy;01星球</p>
 * <p>地址：01星球总部</p>
 * @author 阿伟学长
 * @version 1.0.0
 */
@RestController
public class SeataController {
    @Resource
    TransService s;

    @GetMapping("test-trans")
    public Integer testTrans() {
        return s.saveData();
    }
}

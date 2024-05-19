package com.zeroone.star.publish.controller;

import com.zeroone.star.project.dto.notify.SampleNotifyDTO;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.publish.comp.PublishComponent;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 描述：测试消息发布控制器
 * </p>
 * <p>版权：&copy;01星球</p>
 * <p>地址：01星球总部</p>
 * @author 阿伟学长
 * @version 1.0.0
 */
@RestController
@Api(tags = "消息发布控制器")
public class PublishController {
    @Resource
    PublishComponent comp;

    @ApiOperation(value = "测试消息发布")
    @PostMapping("test-notify")
    public JsonVO<String> testNotify(SampleNotifyDTO dto){
        comp.publishNotify(dto);
        return JsonVO.success("消息发布成功");
    }
}

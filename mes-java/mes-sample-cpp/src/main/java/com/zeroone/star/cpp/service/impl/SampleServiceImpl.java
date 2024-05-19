package com.zeroone.star.cpp.service.impl;

import com.zeroone.star.cpp.service.SampleService;
import com.zeroone.star.project.dto.PageDTO;
import com.zeroone.star.project.dto.cpp.SampleDTO;
import com.zeroone.star.project.vo.JsonVO;
import lombok.AllArgsConstructor;

import java.util.Map;

/**
 * <p>
 * 描述：默认值降级实现
 * </p>
 * <p>版权：&copy;01星球</p>
 * <p>地址：01星球总部</p>
 * @author 阿伟学长
 * @version 1.0.0
 */
@AllArgsConstructor
public class SampleServiceImpl implements SampleService {
    private Throwable th;

    private <T> JsonVO<T> setMessage(JsonVO<T> vo) {
        if (th.getMessage() == null) {
            vo.setMessage(th.getClass().toGenericString());
        } else {
            vo.setMessage(th.getMessage());
        }
        return vo;
    }

    @Override
    public JsonVO<PageDTO<SampleDTO>> get(Map<String, Object> params) {
        return setMessage(JsonVO.fail(null));
    }

    @Override
    public JsonVO<Long> post(SampleDTO dto) {
        return setMessage(JsonVO.fail(null));
    }

    @Override
    public JsonVO<Long> put(SampleDTO dto) {
        return setMessage(JsonVO.fail(null));
    }

    @Override
    public JsonVO<Long> delete(Integer id) {
        return setMessage(JsonVO.fail(null));
    }
}

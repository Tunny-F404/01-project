#pragma once

#ifndef _OASL_VO_
#define _OASL_VO_

#include "../../GlobalInclude.h"
#include "../../dto/AwaitInspection/OaslDTO.h"
#include OATPP_CODEGEN_BEGIN(DTO)

/**
 * 用于响应给客户端的Json对象
 */
class OaslJsonVO : public JsonVO<OaslDTO::Wrapper> {
public:
    DTO_INIT(OaslJsonVO, JsonVO<OaslDTO::Wrapper>);
};

/**
 * 分页显示JsonVO，用于响应给客户端的Json对象
 */
class OaslPageJsonVO : public JsonVO<OaslPageDTO::Wrapper> {
public:
    DTO_INIT(OaslPageJsonVO, JsonVO<OaslPageDTO::Wrapper>);
};

#include OATPP_CODEGEN_END(DTO)

#endif // !_SAMPLE_VO_

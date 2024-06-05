#pragma once
#ifndef _OASL_DTO_
#define _OASL_DTO_

#include "../../GlobalInclude.h"
#include OATPP_CODEGEN_BEGIN(DTO)

class OaslDTO : public oatpp::DTO
{
	DTO_INIT(OaslDTO, DTO);
	// 添加单据编码、物资名称和检测类型字段
	DTO_FIELD(String, documentCode);
	DTO_FIELD(String, materialName);
	DTO_FIELD(String, detectionType);
};

//分页传输对象
class OaslPageDTO : public PageDTO<OaslDTO::Wrapper>
{
	DTO_INIT(OaslPageDTO, PageDTO<OaslDTO::Wrapper>);
};

#include OATPP_CODEGEN_END(DTO)
#endif // !_OASL_DTO_
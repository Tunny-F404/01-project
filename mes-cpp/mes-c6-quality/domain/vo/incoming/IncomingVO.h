#pragma once

#ifndef _INCOMING_VO_
#define _INCOMING_VO_

#include "../../GlobalInclude.h"
#include"../../dto/incoming/IncomingDTO.h"

#include OATPP_CODEGEN_BEGIN(DTO)

/**
 * 定义一个来料检验单列表显示VO
 */
//class IncomingTableJsonVO : public oatpp::DTO
//{
//	DTO_INIT(, DTO);
//
//};

/**
 * 示例显示JsonVO，用于响应给客户端的Json对象
 */
class IncomingJsonVO : public JsonVO<IncomingDTO::Wrapper> {
	DTO_INIT(IncomingJsonVO, JsonVO<IncomingDTO::Wrapper>);
};

/**
 * 示例分页显示JsonVO，用于响应给客户端的Json对象
 */
class IncomingPageJsonVO : public JsonVO<IncomingPageDTO::Wrapper> {
	DTO_INIT(IncomingPageJsonVO, JsonVO<IncomingPageDTO::Wrapper>);
};

#include OATPP_CODEGEN_END(DTO)
#endif // !_INCOMING_VO_
#pragma once

#ifndef _ADDWORKSTATION_VO_H_
#define _ADDWORKSTATION_VO_H_

#include "../../GlobalInclude.h"
#include "../../dto/AmStation/AddWorkStationDTO.h"

#include OATPP_CODEGEN_BEGIN(DTO)

/**
 * 定义一个用户信息显示JsonVO对象，用于响应给客户端
 */
class AddWorkStationJsonVO : public JsonVO<AddWorkStationDTO::Wrapper>
{
	DTO_INIT(AddWorkStationJsonVO, JsonVO<AddWorkStationDTO::Wrapper>);
};



#include OATPP_CODEGEN_END(DTO)
#endif // _USERVO_H_
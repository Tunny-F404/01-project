#pragma once
#ifndef _PRODWORKORDERBOMLIST_VO_
#define _PRODWORKORDERBOMLIST_VO_

#include "../../GlobalInclude.h"
#include "../../dto/ProdWorkorder/ProdWorkorderBomListDTO.h"

#include OATPP_CODEGEN_BEGIN(DTO)

/**
 * 新增工单显示JsonVO，用于响应给客户端的Json对象
 */
class ProdWorkorderBomListJsonVO : public JsonVO<ProdWorkorderBomListDTO::Wrapper> {
	DTO_INIT(ProdWorkorderBomListJsonVO, JsonVO<ProdWorkorderBomListDTO::Wrapper>);
};


#include OATPP_CODEGEN_END(DTO)

#endif // !_PRODWORKORDERBOMLIST_VO_
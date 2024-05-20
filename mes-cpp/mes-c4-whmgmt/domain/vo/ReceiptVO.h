#pragma once

#ifndef _RECEIPTVO_VO_H
#define _RECEIPTVO_VO_H

#include "../../GlobalInclude.h"

#include OATPP_CODEGEN_BEGIN(DTO)

/**
* 定义一个获取单据列表的显示VO
*/
class ReceiptTreeJsonVO : public JsonVO<List<ReceiptTreeDTO::Wrapper>>
{
	DTO_INIT(ReceiptTreeJsonVO, DTO);

};

#include OATPP_CODEGEN_END(DTO)

#endif // _RECEIPTVO_VO_H
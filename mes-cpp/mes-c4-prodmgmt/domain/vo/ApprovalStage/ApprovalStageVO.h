#pragma once
#ifndef _GETPRODUCTIONREPORTLIST_VO_
#define _GETPRODUCTIONREPORTLIST_VO_

#include "../../GlobalInclude.h"
#include "../../dto/ApprovalStage/AddProdWorkorderDTO.h"

#include OATPP_CODEGEN_BEGIN(DTO)

/**
 * 新增工单显示JsonVO，用于响应给客户端的Json对象
 * GetProductionReportList
 */
class GetProductionReportListJsonVO : public JsonVO<GetProductionReportListDTO::Wrapper> {
	DTO_INIT(GetProductionReportListJsonVO, JsonVO<GetProductionReportListDTO::Wrapper>);
};


#include OATPP_CODEGEN_END(DTO)

#endif // !_GETPRODUCTIONREPORTLIST_VO_
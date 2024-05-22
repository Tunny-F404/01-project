#pragma once
#ifndef _GETPRODUCTIONREPORTLIST_DTO_
#define _GETPRODUCTIONREPORTLIST_DTO_
#include "../../GlobalInclude.h"

#include OATPP_CODEGEN_BEGIN(DTO)

/**
 * 新增生成工单传输对象
 */
class GetProductionReportListDTO : public oatpp::DTO
{
	//报工类型;feedback_type;varchar
	DTO_FIELD(String, feedback_type);
	DTO_FIELD_INFO(feedback_type) {
		info->description = ZH_WORDS_GETTER("Approval.post.remark");
	}
};

#include OATPP_CODEGEN_END(DTO)
#endif // !_GETPRODUCTIONREPORTLIST_DTO_
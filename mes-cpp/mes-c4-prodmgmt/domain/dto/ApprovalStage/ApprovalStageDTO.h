#pragma once
#ifndef _GETPRODUCTIONREPORTLIST_DTO_
#define _GETPRODUCTIONREPORTLIST_DTO_
#include "../../GlobalInclude.h"

#include OATPP_CODEGEN_BEGIN(DTO)

/**
 * 新增生成工单传输对象
 */
class ApprovalStageDTO : public oatpp::DTO
{
	DTO_INIT(ApprovalStageDTO, DTO);
	//记录id/生产工单编号;record_id;bigint
	DTO_FIELD(UInt64, record_id);
	DTO_FIELD_INFO(record_id) {
		info->description = ZH_WORDS_GETTER("Approval.post.id");
	}
	//报工类型;feedback_type;varchar
	DTO_FIELD(String, feedback_type);
	DTO_FIELD_INFO(feedback_type) {
		info->description = ZH_WORDS_GETTER("Approval.post.remark");
	}
};
#include OATPP_CODEGEN_END(DTO)
#endif 
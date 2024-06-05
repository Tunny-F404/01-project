#pragma once
#ifndef _OASL_QUERY_
#define _OASL_QUERY_

#include "../../GlobalInclude.h"
#include "domain/query/PageQuery.h"

#include OATPP_CODEGEN_BEGIN(DTO)
class OaslQuery : public PageQuery
{
	DTO_INIT(OaslQuery, PageQuery);
	//单据编码
	DTO_FIELD(String, code);
	DTO_FIELD_INFO(code) {
		info->description = ZH_WORDS_GETTER("Pending_inspection.fields.code");
	}
	//物资名称
	DTO_FIELD(String, material);
	DTO_FIELD_INFO(material) {
		info->description = ZH_WORDS_GETTER("Pending_inspection.fields.material");
	}
	//检测类型
	DTO_FIELD(String, detectionType);
	DTO_FIELD_INFO(detectionType) {
		info->description = ZH_WORDS_GETTER("Pending_inspection.fields.detectionType");
	}
};

#include OATPP_CODEGEN_END(DTO)
#endif // !_OASL_QUERY_


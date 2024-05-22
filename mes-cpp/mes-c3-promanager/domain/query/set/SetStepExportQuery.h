#pragma once

#ifndef _SETSTEPEXPORT_QUERY_
#define _SETSTEPEXPORT_QUERY_

#include "../../GlobalInclude.h"
#include "domain/query/PageQuery.h"

#include OATPP_CODEGEN_BEGIN(DTO)

/**
 * 工序步骤导出查询对象
 */
class SetStepExportQuery : public PageQuery
{
	DTO_INIT(SetStepExportQuery, PageQuery);
	// 工序步骤ID
	DTO_FIELD(String, SetStepCode);
	DTO_FIELD_INFO(SetStepCode) {
		info->description = ZH_WORDS_GETTER("setstep.field.code");
	}
	// 工序步骤名称
	DTO_FIELD(String, SetStepName);
	DTO_FIELD_INFO(SetStepName) {
		info->description = ZH_WORDS_GETTER("setstep.field.name");
	}
	// 是否启用
	DTO_FIELD(String, enableFlag);
	DTO_FIELD_INFO(enableFlag) {
		info->description = ZH_WORDS_GETTER("setstep.field.flag");
	}
};

#include OATPP_CODEGEN_END(DTO)
#endif // !_SAMPLE_QUERY_

#pragma once
#ifndef _PROCESSLIST_QUERY_
#define _PROCESSLIST_QUERY_

#include "../../GlobalInclude.h"
#include "domain/query/PageQuery.h"

#include OATPP_CODEGEN_BEGIN(DTO)

/**
 * 分页查询工艺列表
 */
class ProcessListQuery : public PageQuery
{
	DTO_INIT(ProcessListQuery, PageQuery);
	// 工艺路线编号
	DTO_FIELD(String, routeCode);
	DTO_FIELD_INFO(routeCode) {
		info->description = ZH_WORDS_GETTER("process.field.routecode");
	}
	// 工艺路线名称
	DTO_FIELD(String, routeName);
	DTO_FIELD_INFO(routeName) {
		info->description = ZH_WORDS_GETTER("process.field.name");
	}
	// 是否启用
	DTO_FIELD(String, enableFlag);
	DTO_FIELD_INFO(enableFlag) {
		info->description = ZH_WORDS_GETTER("process.field.flag");
	}
};

#include OATPP_CODEGEN_END(DTO)
#endif // !_SAMPLE_QUERY_

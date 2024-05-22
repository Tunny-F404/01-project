#pragma once
#ifndef _SINGLE_QUERY_
#define _SINGLE_QUERY_

#include "../../GlobalInclude.h"
#include "domain/query/PageQuery.h"

#include OATPP_CODEGEN_BEGIN(DTO)


class SingleQuery :public PageQuery
{
	DTO_INIT(SingleQuery, PageQuery);

	// ºÏ≤‚œÓID
	API_DTO_FIELD_DEFAULT(UInt64, index_id, ZH_WORDS_GETTER("inspect.single.index_id"));

};

//
#include OATPP_CODEGEN_END(DTO)
#endif // !_SINGLE_QUERY_

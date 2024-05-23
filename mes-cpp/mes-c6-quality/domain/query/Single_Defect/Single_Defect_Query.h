#pragma once
#ifndef Single_Defect_QUERY_
#define Single_Defect_QUERY_

#include "../../GlobalInclude.h"
#include "domain/query/PageQuery.h"

#include OATPP_CODEGEN_BEGIN(DTO)


class SingleQuery :public PageQuery
{
	DTO_INIT(SingleQuery, PageQuery);

	// ºÏ≤‚œÓID
	API_DTO_FIELD_DEFAULT(UInt64, index_id, ZH_WORDS_GETTER("inspect.single.index_id"));

};

class DefectQuery :public PageQuery
{
	DTO_INIT(DefectQuery, PageQuery);

	// ºÏ—Èµ•ID
	API_DTO_FIELD_DEFAULT(UInt64, qc_id, ZH_WORDS_GETTER("inspect.single.qc_id"));

};



//
#include OATPP_CODEGEN_END(DTO)
#endif // !Single_Defect_QUERY_

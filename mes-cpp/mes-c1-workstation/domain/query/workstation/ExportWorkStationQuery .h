#pragma once

#ifndef _EXPORTWORKSTATIONLIST_QUERY_H_
#define _EXPORTWORKSTATIONLIST_QUERY_H_

#include "../../GlobalInclude.h"
#include "domain/query/PageQuery.h"

#include OATPP_CODEGEN_BEGIN(DTO)

/**
 * 导出工作站查询
 */
class ExportWorkStationQuery : public PageQuery
{
	DTO_INIT(ExportWorkStationQuery, PageQuery);
	//工作站编码
	API_DTO_FIELD_DEFAULT(String, workstationCode, ZH_WORDS_GETTER("workstation.fields.workstationCode"));
	//工作站名称
	API_DTO_FIELD_DEFAULT(String, workstationName, ZH_WORDS_GETTER("workstation.fields.workstationName"));
	//所在车间名称
	API_DTO_FIELD_DEFAULT(String, workshopName, ZH_WORDS_GETTER("workstation.fields.workshopName"));
	//所属工序(工序名称)
	API_DTO_FIELD_DEFAULT(String, processName, ZH_WORDS_GETTER("workstation.fields.processName"));
};

#include OATPP_CODEGEN_END(DTO)
#endif // !_SAMPLE_QUERY_
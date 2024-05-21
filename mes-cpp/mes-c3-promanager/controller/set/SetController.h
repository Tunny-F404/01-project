#pragma once
#ifndef _SET_CONTROLLER_
#define _SET_CONTROLLER_

#include "domain/vo/BaseJsonVO.h"
#include "domain/query/set/ProcessExportQuery.h"


#include OATPP_CODEGEN_BEGIN(ApiController) 

/**
 * 工艺流程控制器
 */
class SetController : public oatpp::web::server::api::ApiController 
{

	API_ACCESS_DECLARE(SetController);

public:

// 1 导出文件
	ENDPOINT_INFO(queryProcessExport) {
		API_DEF_ADD_TITLE(ZH_WORDS_GETTER("set.export.summary"));
		API_DEF_ADD_AUTH();
		API_DEF_ADD_RSP_JSON_WRAPPER(StringJsonVO);
		API_DEF_ADD_PAGE_PARAMS();
		API_DEF_ADD_QUERY_PARAMS(String, "processCode", ZH_WORDS_GETTER("set.field.code"), "R1126", false);
		API_DEF_ADD_QUERY_PARAMS(String, "processName", ZH_WORDS_GETTER("set.field.name"), "111", false);
		API_DEF_ADD_QUERY_PARAMS(String, "enableFlag", ZH_WORDS_GETTER("set.field.flag"), "Y", false);
	}
	ENDPOINT(API_M_POST, "/mes/set/export", queryProcessExport, QUERIES(QueryParams, queryParams), API_HANDLER_AUTH_PARAME) {
		API_HANDLER_QUERY_PARAM(Query, ProcessExportQuery, queryParams);
		API_HANDLER_RESP_VO(execQueryProcess(Query));
	}
private:
	// 1 导出文件
	StringJsonVO::Wrapper execQueryProcess(const ProcessExportQuery::Wrapper& query);
};


#include OATPP_CODEGEN_END(ApiController) 
#endif 
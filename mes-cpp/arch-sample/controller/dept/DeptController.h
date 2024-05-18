#pragma once
#ifndef _DEPTCONTROLLER_H_
#define _DEPTCONTROLLER_H_


#include "domain/vo/dept/DeptVO.h"
#include "domain/query/dept/DeptQuery.h"
#include OATPP_CODEGEN_BEGIN(ApiController)

class DeptController : public oatpp::web::server::api::ApiController {
	API_ACCESS_DECLARE(DeptController);
public:
	// 3.1 定义查询接口描述
	ENDPOINT_INFO(queryDeptTable) {
		// 定义接口标题
		API_DEF_ADD_TITLE(ZH_WORDS_GETTER("dept.query.summary"));
		// 定义默认授权参数（可选定义，如果定义了，下面ENDPOINT里面需要加入API_HANDLER_AUTH_PARAME）
		API_DEF_ADD_AUTH();
		// 定义响应参数格式
		API_DEF_ADD_RSP_JSON_WRAPPER(DeptTableJsonVO);
		// 定义其他查询参数描述
		API_DEF_ADD_QUERY_PARAMS(String, "deptName", ZH_WORDS_GETTER("dept.fields.dname"), "li ming", false);
		API_DEF_ADD_QUERY_PARAMS(Int32, "status", ZH_WORDS_GETTER("dept.fields.dstatus"), 0, false);
	}
	// 3.2 定义查询接口处理
	ENDPOINT(API_M_GET, "/dept/query-dept-table", queryDeptTable, QUERIES(QueryParams, queryParams), API_HANDLER_AUTH_PARAME) {
		// 解析查询参数为Query领域模型
		API_HANDLER_QUERY_PARAM(query, DeptQuery, queryParams);
		// 呼叫执行函数响应结果
		API_HANDLER_RESP_VO(execDeptTable(query));
	}

private:
	// 3.3 演示分页查询数据
	DeptTableJsonVO::Wrapper execDeptTable(const DeptQuery::Wrapper& query);
};
#include OATPP_CODEGEN_END(ApiController) //<- End Codegen
#endif
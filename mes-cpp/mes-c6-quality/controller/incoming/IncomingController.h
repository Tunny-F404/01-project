#pragma once

#ifndef _INCOMING_CONTROLLER_
#define _INCOMING_CONTROLLER_

#include"domain/dto/incoming/IncomingDTO.h"
#include"domain/query/incoming/IncomingQuery.h"
#include"domain/vo/incoming/IncomingVO.h"
#include "domain/vo/BaseJsonVO.h"


// 0 定义API控制器使用宏
#include OATPP_CODEGEN_BEGIN(ApiController) //<- Begin Codegen

/**
 * 示例控制器，演示基础接口的使用
 */
class IncomingController : public oatpp::web::server::api::ApiController // 1 继承控制器
{
	// 2 定义控制器访问入口
	API_ACCESS_DECLARE(IncomingController);
public:// 定义接口
	// 定义查询结构描述
	ENDPOINT_INFO(queryIncoming) {
		// 定义接口标题
		API_DEF_ADD_TITLE(ZH_WORDS_GETTER("incoming.get.summary"));
		// 定义默认授权参数（可选定义，如果定义了，下面ENDPOINT里面需要加入API_HANDLER_AUTH_PARAME）
		API_DEF_ADD_AUTH();
		// 定义响应参数格式
		API_DEF_ADD_RSP_JSON_WRAPPER(IncomingPageJsonVO);
		// 定义分页查询参数描述
		API_DEF_ADD_PAGE_PARAMS();
		// 定义其他查询参数描述
		API_DEF_ADD_QUERY_PARAMS(String, "incomingCode", ZH_WORDS_GETTER("incoming.fields.incode"), "110", false);
		API_DEF_ADD_QUERY_PARAMS(String, "vendorCode", ZH_WORDS_GETTER("incoming.fields.vcode"), "110", false);
		API_DEF_ADD_QUERY_PARAMS(String, "vendorName", ZH_WORDS_GETTER("incoming.fields.vname"), "zebul", false);
		API_DEF_ADD_QUERY_PARAMS(String, "vendorBatch", ZH_WORDS_GETTER("incoming.fields.vbatch"), "110", false);
		
	}
	// 定义查询接口处理
	ENDPOINT(API_M_GET, "/incoming", queryIncoming, QUERIES(QueryParams, queryParams), API_HANDLER_AUTH_PARAME)
	{
		// 解析查询参数为Query领域模型
		API_HANDLER_QUERY_PARAM(userQuery, IncomingQuery, queryParams);
		// 呼叫执行函数响应结果
		API_HANDLER_RESP_VO(execQueryIncoming(userQuery, authObject->getPayload()));
	}
private:// 定义接口执行函数
	// 3.3 演示分页查询数据
	IncomingPageJsonVO::Wrapper execQueryIncoming(const IncomingQuery::Wrapper& query, const PayloadDTO& payload);
	// 3.3 演示新增数据
	//Uint64JsonVO::Wrapper execAddSample(const SampleDTO::Wrapper& dto);
	// 3.3 演示修改数据
	//Uint64JsonVO::Wrapper execModifySample(const SampleDTO::Wrapper& dto);
};

// 0 取消API控制器使用宏
#include OATPP_CODEGEN_END(ApiController) //<- End Codegen
#endif // _INCOMING_CONTROLLER_
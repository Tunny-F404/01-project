#pragma once
#ifndef _PROCESS_CONTROLLER_
#define _PROCESS_CONTROLLER_

#include "domain/vo/BaseJsonVO.h"
#include "domain/vo/process/ProcessListVO.h"
#include "domain/query/process/ProcessListQuery.h"
#include "domain/dto/process/ProcessListDTO.h"

#include "domain/vo/process/ProcessDetailVO.h"
#include "domain/query/process/ProcessDetailQuery.h"

// 0 定义API控制器使用宏
#include OATPP_CODEGEN_BEGIN(ApiController) //<- Begin Codegen

/**
 * 生产管理-工艺流程控制器
 */
class ProcessController : public oatpp::web::server::api::ApiController
{

	API_ACCESS_DECLARE(ProcessController);
public:
	// 1 定义查询接口描述-获取工艺列表
	ENDPOINT_INFO(queryProcessList) {
		// 定义接口标题
		API_DEF_ADD_TITLE(ZH_WORDS_GETTER("process.get.summary1"));
		// 定义默认授权参数（可选定义，如果定义了，下面ENDPOINT里面需要加入API_HANDLER_AUTH_PARAME）
		API_DEF_ADD_AUTH();
		// 定义响应参数格式
		API_DEF_ADD_RSP_JSON_WRAPPER(ProcessListJsonVO);
		// 定义分页查询参数描述
		API_DEF_ADD_PAGE_PARAMS();
		// 定义其他查询参数描述
		API_DEF_ADD_QUERY_PARAMS(String, "routeCode", ZH_WORDS_GETTER("process.field.routecode"), "R1126", false);
		API_DEF_ADD_QUERY_PARAMS(String, "routeName", ZH_WORDS_GETTER("process.field.name"), "111", false);
		API_DEF_ADD_QUERY_PARAMS(String, "enableFlag", ZH_WORDS_GETTER("process.field.flag"), "Y", false);
	}
	ENDPOINT(API_M_GET, "/prod-api/mes/pro/proroute/list", queryProcessList, QUERIES(QueryParams, queryParams), API_HANDLER_AUTH_PARAME) {
		// 解析查询参数为Query领域模型
		API_HANDLER_QUERY_PARAM(Query, ProcessListQuery, queryParams);
		// 呼叫执行函数响应结果
		API_HANDLER_RESP_VO(execQueryProcessList(Query));//, authObject->getPayload()
	}

	// 2 定义查询接口-获取工艺详情
	ENDPOINT_INFO(queryProcessDetail) {
		// 定义接口标题
		API_DEF_ADD_TITLE(ZH_WORDS_GETTER("process.get.summary2"));
		// 定义默认授权参数（可选定义，如果定义了，下面ENDPOINT里面需要加入API_HANDLER_AUTH_PARAME）
		API_DEF_ADD_AUTH();
		// 定义响应参数格式
		API_DEF_ADD_RSP_JSON_WRAPPER(ProcessDetailJsonVO);
		// 定义其他查询参数描述
		API_DEF_ADD_QUERY_PARAMS(UInt32, "routeId", ZH_WORDS_GETTER("process.field.id"), 239, true);
	}
	ENDPOINT(API_M_GET, "/prod-api/mes/pro/proroute/detail", queryProcessDetail, QUERIES(QueryParams, queryParams), API_HANDLER_AUTH_PARAME) {
		// 解析查询参数为Query领域模型
		API_HANDLER_QUERY_PARAM(Query, ProcessDetailQuery, queryParams);
		// 呼叫执行函数响应结果
		API_HANDLER_RESP_VO(execQueryProcessDetail(Query));
	}

	// 3 定义新增接口描述-添加工艺流程
	ENDPOINT_INFO(addProcess) {
		// 定义接口标题
		API_DEF_ADD_TITLE(ZH_WORDS_GETTER("process.post.summary1"));
		// 定义默认授权参数（可选定义，如果定义了，下面ENDPOINT里面需要加入API_HANDLER_AUTH_PARAME）
		API_DEF_ADD_AUTH();
		// 定义响应参数格式
		API_DEF_ADD_RSP_JSON_WRAPPER(Uint64JsonVO);
	}
	// 3.2 定义新增接口处理
	ENDPOINT(API_M_POST, "/prod-api/mes/pro/proroute/addProcess", addProcess, BODY_DTO(ProcessDTO::Wrapper, dto), API_HANDLER_AUTH_PARAME) {
		// 呼叫执行函数响应结果
		API_HANDLER_RESP_VO(execAddProcess(dto));
	}


private:
	// 分页查询工艺列表数据
	ProcessListJsonVO::Wrapper execQueryProcessList(const ProcessListQuery::Wrapper& query);
	// 查询工艺详情
	ProcessDetailJsonVO::Wrapper execQueryProcessDetail(const ProcessDetailQuery::Wrapper& query);
	// 新增工艺数据
	Uint64JsonVO::Wrapper execAddProcess(const ProcessDTO::Wrapper& dto);
};

// 0 取消API控制器使用宏
#include OATPP_CODEGEN_END(ApiController) //<- End Codegen
#endif // _SAMPLE_CONTROLLER_



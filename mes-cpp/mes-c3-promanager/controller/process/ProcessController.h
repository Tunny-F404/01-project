#pragma once
#ifndef _PROCESS_CONTROLLER_
#define _PROCESS_CONTROLLER_

#include "domain/vo/BaseJsonVO.h"
#include "domain/vo/process/ProcessListVO.h"
#include "domain/query/process/ProcessListQuery.h"
#include "domain/dto/process/ProcessListDTO.h"

#include "domain/query/process/ProcessProductsQuery.h"
#include "domain/dto/process/ProcessProductsDTO.h"
#include "domain/vo/process/ProcessProductsVO.h"
#include "domain/query/process/ProcessQuery.h"

#include OATPP_CODEGEN_BEGIN(ApiController) //<- Begin Codegen

/**
 * 生产管理-工艺流程控制器
 */
class ProcessController : public oatpp::web::server::api::ApiController
{

	API_ACCESS_DECLARE(ProcessController);

public:
	// 1 获取工艺列表
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
	ENDPOINT(API_M_GET, "/pro/get-list", queryProcessList, QUERIES(QueryParams, queryParams), API_HANDLER_AUTH_PARAME) {
		// 解析查询参数为Query领域模型
		API_HANDLER_QUERY_PARAM(Query, ProcessListQuery, queryParams);
		// 呼叫执行函数响应结果
		API_HANDLER_RESP_VO(execQueryProcessList(Query));//, authObject->getPayload()
	}

	// 2 获取工艺详情
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
	ENDPOINT(API_M_GET, "/pro/get-detail", queryProcessDetail, QUERIES(QueryParams, queryParams), API_HANDLER_AUTH_PARAME) {
		// 解析查询参数为Query领域模型
		API_HANDLER_QUERY_PARAM(Query, ProcessDetailQuery, queryParams);
		// 呼叫执行函数响应结果
		API_HANDLER_RESP_VO(execQueryProcessDetail(Query));
	}

	// 3 添加工艺流程
	ENDPOINT_INFO(addProcess) {
		// 定义接口标题
		API_DEF_ADD_TITLE(ZH_WORDS_GETTER("process.post.summary1"));
		// 定义默认授权参数（可选定义，如果定义了，下面ENDPOINT里面需要加入API_HANDLER_AUTH_PARAME）
		API_DEF_ADD_AUTH();
		// 定义响应参数格式
		API_DEF_ADD_RSP_JSON_WRAPPER(Uint64JsonVO);
	}
	ENDPOINT(API_M_POST, "/pro/add-process", addProcess, BODY_DTO(ProcessAddDTO::Wrapper, dto), API_HANDLER_AUTH_PARAME) {
		// 呼叫执行函数响应结果
		API_HANDLER_RESP_VO(execAddProcess(dto));
	}

	// 4 修改工艺
	API_DEF_ENDPOINT_INFO_AUTH(ZH_WORDS_GETTER("process.put.summary1"), modifyProcess, Uint64JsonVO::Wrapper);
	API_HANDLER_ENDPOINT_AUTH(API_M_PUT, "/pro/modify-process", modifyProcess, BODY_DTO(ProcessAddDTO::Wrapper, dto), execModifyBasicProcess(dto));

	// 5 获取工艺关联产品列表
	ENDPOINT_INFO(queryCorrProduct) {
		// 定义接口标题
		API_DEF_ADD_TITLE(ZH_WORDS_GETTER("process.get.summary3"));
		// 定义默认授权参数（可选定义，如果定义了，下面ENDPOINT里面需要加入API_HANDLER_AUTH_PARAME）
		API_DEF_ADD_AUTH();
		// 定义响应参数格式
		API_DEF_ADD_RSP_JSON_WRAPPER(ProductsPageJsonVO);
		// 定义分页查询参数描述
		API_DEF_ADD_PAGE_PARAMS();
		// 定义其他查询参数描述
		API_DEF_ADD_QUERY_PARAMS(String, "id", ZH_WORDS_GETTER("product.field.id"), "249", false);

	}
	ENDPOINT(API_M_GET, "/pro/get-corrprocess", queryCorrProduct, QUERIES(QueryParams, queryParams), API_HANDLER_AUTH_PARAME) {
		// 解析查询参数为Query领域模型
		API_HANDLER_QUERY_PARAM(userQuery, ProcessProductsQuery, queryParams);
		// 呼叫执行函数响应结果
		API_HANDLER_RESP_VO(execQueryProducts(userQuery));
	}

	// 6 删除组成工序
	ENDPOINT_INFO(removeProcess) {
		// 定义标题和返回类型以及授权支持
		API_DEF_ADD_COMMON_AUTH(ZH_WORDS_GETTER("process.del.summary1"), Uint64JsonVO::Wrapper);
		// 定义其他路径参数说明
	}
	API_HANDLER_ENDPOINT_AUTH(API_M_DEL, "/pro/delete-process/{id}", removeProcess, BODY_DTO(List<UInt64>, id), execRemoveProcess(id));

	// 7 工艺导出
	ENDPOINT_INFO(queryProcess) {
		// 定义接口标题
		API_DEF_ADD_TITLE(ZH_WORDS_GETTER("process.get_field.summary"));
		// 定义默认授权参数（可选定义，如果定义了，下面ENDPOINT里面需要加入API_HANDLER_AUTH_PARAME）
		API_DEF_ADD_AUTH();
		// 定义响应参数格式
		API_DEF_ADD_RSP_JSON_WRAPPER(StringJsonVO);
		// 定义分页查询参数描述
		API_DEF_ADD_PAGE_PARAMS();
		// 定义其他查询参数描述
		API_DEF_ADD_QUERY_PARAMS(String, "route_code", ZH_WORDS_GETTER("process.field.route_code"), "R1121", false);
		API_DEF_ADD_QUERY_PARAMS(String, "route_name", ZH_WORDS_GETTER("process.field.route_name"), ZH_WORDS_GETTER("process.field.example"), false);
		API_DEF_ADD_QUERY_PARAMS(String, "enable_flag", ZH_WORDS_GETTER("process.field.enable_flag"), "Y", false);
	}
	ENDPOINT(API_M_POST, "/set/export-process", queryProcess, QUERIES(QueryParams, queryParams), API_HANDLER_AUTH_PARAME) {
		// 解析查询参数为Query领域模型
		API_HANDLER_QUERY_PARAM(userQuery, ProcessQuery, queryParams);
		// 呼叫执行函数响应结果
		API_HANDLER_RESP_VO(execQueryProcess(userQuery));
	}

private:
	// 1 获取工艺列表数据
	ProcessListJsonVO::Wrapper execQueryProcessList(const ProcessListQuery::Wrapper& query);
	// 2 查询工艺详情
	ProcessDetailJsonVO::Wrapper execQueryProcessDetail(const ProcessDetailQuery::Wrapper& query);
	// 3 添加工艺流程
	Uint64JsonVO::Wrapper execAddProcess(const ProcessAddDTO::Wrapper& dto);
	// 4 修改工艺基础数据
	Uint64JsonVO::Wrapper execModifyBasicProcess(const ProcessAddDTO::Wrapper& dto);
	// 5 获取工艺关联产品列表
	ProductsPageJsonVO::Wrapper execQueryProducts(const ProcessProductsQuery::Wrapper& query);
	// 6 删除组成工序（支持批量删除）
	Uint64JsonVO::Wrapper execRemoveProcess(const List<UInt64>& id);
	// 7 工艺导出
	StringJsonVO::Wrapper execQueryProcess(const ProcessQuery::Wrapper& query);
};

// 0 取消API控制器使用宏
#include OATPP_CODEGEN_END(ApiController) //<- End Codegen
#endif // _SAMPLE_CONTROLLER_



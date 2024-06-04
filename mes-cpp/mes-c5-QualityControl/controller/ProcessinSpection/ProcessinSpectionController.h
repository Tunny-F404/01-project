#pragma once
#ifndef _PROCESSINSPECTION_CONTROLLER_
#define _PROCESSINSPECTION_CONTROLLER_

#include "Macros.h"
#include "domain/vo/BaseJsonVO.h"
#include "../../domain/query/ProcessinSpection/ProcessinSpectionQuery.h"
#include "../../domain/dto/ProcessinSpection/ProcessinSpectionDTO.h"
#include "../../domain/vo/ProcessinSpection/ProcessinSpectionVO.h"

#define TEST_EXCEL_FN "./public/excel/1.xlsx"
#define TEST_EXCEL_SN ZH_WORDS_GETTER("excel.sheet.s1")

// 0 定义API控制器使用宏
#include OATPP_CODEGEN_BEGIN(ApiController) //<- Begin Codegen

/**
 * 获取过程检验列表(条件+分页) 删除过程检验列表(支持批量删除) 余晖
 */
class ProcessinSpectionController : public oatpp::web::server::api::ApiController // 1 继承控制器
{
	// 2 定义控制器访问入口
	API_ACCESS_DECLARE(ProcessinSpectionController);
	// 3 定义接口
public:
	// 3.1 定义查询接口描述
	ENDPOINT_INFO(queryProcessinSpection) {
		// 定义接口标题
		API_DEF_ADD_TITLE(ZH_WORDS_GETTER("processinspection.get.summary"));
		// 定义默认授权参数（可选定义，如果定义了，下面ENDPOINT里面需要加入API_HANDLER_AUTH_PARAME）
		API_DEF_ADD_AUTH();
		// 定义响应参数格式
		API_DEF_ADD_RSP_JSON_WRAPPER(ProcessinSpectionQueryPageJsonVO);
		// 定义分页查询参数描述
		API_DEF_ADD_PAGE_PARAMS();
		// 定义其他查询参数描述
		API_DEF_ADD_QUERY_PARAMS(String, "ipqc_code", ZH_WORDS_GETTER("processinspection.field.ipqc_code"), "", false);
		API_DEF_ADD_QUERY_PARAMS(String, "ipqc_type", ZH_WORDS_GETTER("processinspection.field.ipqc_type"), "", false);
		API_DEF_ADD_QUERY_PARAMS(String, "workorder_code", ZH_WORDS_GETTER("processinspection.field.workorder_code"), "", false);
		API_DEF_ADD_QUERY_PARAMS(String, "item_code", ZH_WORDS_GETTER("processinspection.field.item_code"), "", false);
		API_DEF_ADD_QUERY_PARAMS(String, "item_name", ZH_WORDS_GETTER("processinspection.field.item_name"), "", false);
		API_DEF_ADD_QUERY_PARAMS(String, "check_result", ZH_WORDS_GETTER("processinspection.field.check_result"), "", false);
	}
	// 3.2 定义查询接口处理
	ENDPOINT(API_M_GET, "/process-inspection/query-by-page", queryProcessinSpection, QUERIES(QueryParams, queryParams), API_HANDLER_AUTH_PARAME) {
		// 解析查询参数为Query领域模型
		API_HANDLER_QUERY_PARAM(userQuery, ProcessinSpectionQuery, queryParams);
		// 呼叫执行函数响应结果
		API_HANDLER_RESP_VO(execQueryProcessinSpection(userQuery, authObject->getPayload()));
	}

	// 3.1 定义删除接口描述
	API_DEF_ENDPOINT_INFO_AUTH(ZH_WORDS_GETTER("processinspection.delete.summary"), removeProcessinSpection, Uint64JsonVO::Wrapper);
	// 3.2 定义删除接口处理
	API_HANDLER_ENDPOINT_AUTH(API_M_DEL, "/process-inspection/remove", removeProcessinSpection, BODY_DTO(oatpp::List<UInt64>, ids), execRemoveProcessinSpection(ids));

	// 3.1 定义导出接口描述
	ENDPOINT_INFO(exportProcessinSpection) {
		// 定义接口标题
		API_DEF_ADD_TITLE(ZH_WORDS_GETTER("processinspection.export.summary"));
		// 定义默认授权参数（可选定义，如果定义了，下面ENDPOINT里面需要加入API_HANDLER_AUTH_PARAME）
		API_DEF_ADD_AUTH();
		// 定义响应参数格式
		API_DEF_ADD_RSP_JSON_WRAPPER(StringJsonVO);
		// 定义其他查询参数描述
		API_DEF_ADD_QUERY_PARAMS(String, "ipqc_code", ZH_WORDS_GETTER("processinspection.field.ipqc_code"), "", false);
		API_DEF_ADD_QUERY_PARAMS(String, "ipqc_type", ZH_WORDS_GETTER("processinspection.field.ipqc_type"), "", false);
		API_DEF_ADD_QUERY_PARAMS(String, "workorder_code", ZH_WORDS_GETTER("processinspection.field.workorder_code"), "", false);
		API_DEF_ADD_QUERY_PARAMS(String, "item_code", ZH_WORDS_GETTER("processinspection.field.item_code"), "", false);
		API_DEF_ADD_QUERY_PARAMS(String, "item_name", ZH_WORDS_GETTER("processinspection.field.item_name"), "", false);
		API_DEF_ADD_QUERY_PARAMS(String, "check_result", ZH_WORDS_GETTER("processinspection.field.check_result"), "", false);
	}
	// 3.2 定义查询接口处理
	ENDPOINT(API_M_GET, "/process-inspection/export", exportProcessinSpection, QUERIES(QueryParams, queryParams), API_HANDLER_AUTH_PARAME) {
		// 解析查询参数为Query领域模型
		API_HANDLER_QUERY_PARAM(userQuery, ProcessinSpectionQuery, queryParams);
		// 呼叫执行函数响应结果
		API_HANDLER_RESP_VO(execExportProcessinSpection(userQuery, authObject->getPayload()));
	}

	// 获取过程检验详情	
	ENDPOINT_INFO(queryInspectionDetails) {
		API_DEF_ADD_TITLE(ZH_WORDS_GETTER("processinspection.get.inspection_details"));
		API_DEF_ADD_AUTH();
		API_DEF_ADD_RSP_JSON_WRAPPER(ProcessinSpectionJsonVO);
		//API_DEF_ADD_PAGE_PARAMS();
		API_DEF_ADD_QUERY_PARAMS(String, "ipqc_code", ZH_WORDS_GETTER("processinspection.field.ipqc_code"), "IPQC202310180004", true);	// 只能根据检验单编号查询
	}
	ENDPOINT(API_M_GET, "/qualityctl/query-inspection-details", queryInspectionDetails, QUERIES(QueryParams, queryParams), API_HANDLER_AUTH_PARAME) {
		API_HANDLER_QUERY_PARAM(detailsQuery, ProcessinSpectionQuery, queryParams);
		API_HANDLER_RESP_VO(execQueryInspectionDetails(detailsQuery, authObject->getPayload()));
	}

	// 确认检验单
	API_DEF_ENDPOINT_INFO_AUTH(ZH_WORDS_GETTER("processinspection.modify.confirm_orders"), modifyConfirmOrders, Uint64JsonVO::Wrapper);
	API_HANDLER_ENDPOINT_AUTH(API_M_PUT, "/qualityctl/modify-confirm-orders", modifyConfirmOrders, BODY_DTO(ProcessinSpectionDTO::Wrapper, dto), execModifyConfirmOrders(dto));

	// 完成检验单
	API_DEF_ENDPOINT_INFO_AUTH(ZH_WORDS_GETTER("processinspection.modify.finish_orders"), modifyFinishOrders, Uint64JsonVO::Wrapper);
	API_HANDLER_ENDPOINT_AUTH(API_M_PUT, "/qualityctl/finish-confirm-orders", modifyFinishOrders, BODY_DTO(ProcessinSpectionDTO::Wrapper, dto), execModifyFinishOrders(dto));

	// 定义接口描述
	API_DEF_ENDPOINT_INFO_AUTH(ZH_WORDS_GETTER("processinspection.put.summary"), modifyTheProcessInspection, Uint64JsonVO::Wrapper);

	// 定义修改过程检验接口处理
	API_HANDLER_ENDPOINT_AUTH(API_M_PUT, "/processinspection/modify", modifyTheProcessInspection, BODY_DTO(ProcessinSpectionDTO::Wrapper, dto), execModifyTheProcessInspection(dto));

	//  定义添加过程检验接口描述
	ENDPOINT_INFO(addProcessInspection) {
		// 定义接口标题
		API_DEF_ADD_TITLE(ZH_WORDS_GETTER("processinspection.addProcessInspection.summary"));
		// 定义默认授权参数（可选定义，如果定义了，下面ENDPOINT里面需要加入API_HANDLER_AUTH_PARAME）
		API_DEF_ADD_AUTH();
		// 定义响应参数格式			 
		API_DEF_ADD_RSP_JSON_WRAPPER(Uint64JsonVO);
		// 定义其他查询参数描述
	}
	//  定义添加过程检验接口处理
	ENDPOINT(API_M_POST, "/processinspection", addProcessInspection, BODY_DTO(ProcessinSpectionDTO::Wrapper, dto), API_HANDLER_AUTH_PARAME) {
		//// 解析查询参数为Query领域模型
		//API_HANDLER_QUERY_PARAM(userQuery, ProcessinSpectionQuery, queryParams);
		// 呼叫执行函数响应结果
		API_HANDLER_RESP_VO(execAddProcessInspection(dto));
	}

private:
	// 3.3 演示分页查询数据
	ProcessinSpectionQueryPageJsonVO::Wrapper execQueryProcessinSpection(const ProcessinSpectionQuery::Wrapper& query, const PayloadDTO& payload);
	
	Uint64JsonVO::Wrapper execRemoveProcessinSpection(const oatpp::List<UInt64>& ids);

	StringJsonVO::Wrapper execExportProcessinSpection(const ProcessinSpectionQuery::Wrapper& query, const PayloadDTO& payload);

	ProcessinSpectionJsonVO::Wrapper execQueryInspectionDetails(const ProcessinSpectionQuery::Wrapper& query, const PayloadDTO& payload);

	Uint64JsonVO::Wrapper execModifyTheProcessInspection(const ProcessinSpectionDTO::Wrapper& dto);
	//  添加过程检验
	Uint64JsonVO::Wrapper execAddProcessInspection(const ProcessinSpectionDTO::Wrapper& dto);
	//确认订单
	Uint64JsonVO::Wrapper execModifyConfirmOrders(const ProcessinSpectionDTO::Wrapper& dto);
	//完成订单
	Uint64JsonVO::Wrapper execModifyFinishOrders(const ProcessinSpectionDTO::Wrapper& dto);
};

// 0 取消API控制器使用宏
#include OATPP_CODEGEN_END(ApiController) //<- End Codegen
#endif // _PROCESSINSPECTION_CONTROLLER_
#pragma once
#ifndef _INSPECT_CONTROLLER_
#define _INSPECT_CONTROLLER_

#include "domain/vo/BaseJsonVO.h"
#include "domain/query/LaiLiaoInspect/InspectQuery.h"
#include "domain/dto/LaiLiaoInspect/InspectDTO.h"
#include "domain/vo/LaiLiaoInspect/InspectVO.h"

// 0 定义API控制器使用宏
#include OATPP_CODEGEN_BEGIN(ApiController) //<- Begin Codegen

/**
 * 来料检验单信息接口的使用
 */
class InspectController : public oatpp::web::server::api::ApiController // 1 继承控制器
{
	// 2 定义控制器访问入口
	API_ACCESS_DECLARE(InspectController);
	// 3 定义接口
public:
	// 3.1 定义查询检验单列表接口描述
	ENDPOINT_INFO(queryInspect) {
		// 定义接口标题
		API_DEF_ADD_TITLE(ZH_WORDS_GETTER("inspect.get.summary"));
		// 定义默认授权参数（可选定义，如果定义了，下面ENDPOINT里面需要加入API_HANDLER_AUTH_PARAME）
		API_DEF_ADD_AUTH();
		// 定义响应参数格式
		API_DEF_ADD_RSP_JSON_WRAPPER(InspectPageJsonVO);
		// 定义分页查询参数描述
		API_DEF_ADD_PAGE_PARAMS();
		// 定义其他查询参数描述
		API_DEF_ADD_QUERY_PARAMS(String, "code", ZH_WORDS_GETTER("inspect.code"),"",false);

		API_DEF_ADD_QUERY_PARAMS(String, "vendor_code", ZH_WORDS_GETTER("inspect.vendor_code"), "", false);

		API_DEF_ADD_QUERY_PARAMS(String, "vendor_name", ZH_WORDS_GETTER("inspect.vendor_name"), "", false);

		API_DEF_ADD_QUERY_PARAMS(String, "vd_batch", ZH_WORDS_GETTER("inspect.vd_batch"), "", false);

		API_DEF_ADD_QUERY_PARAMS(String, "item_code", ZH_WORDS_GETTER("inspect.item_code"), "", false);

		API_DEF_ADD_QUERY_PARAMS(String, "item_name", ZH_WORDS_GETTER("inspect.item_name"), "", false);

		API_DEF_ADD_QUERY_PARAMS(String, "check_result", ZH_WORDS_GETTER("inspect.check_result"), "", false);

		API_DEF_ADD_QUERY_PARAMS(String, "recive_date", ZH_WORDS_GETTER("inspect.recive_date"), "", false);

		API_DEF_ADD_QUERY_PARAMS(String, "inspect_date", ZH_WORDS_GETTER("inspect.inspect_date"), "", false);

		API_DEF_ADD_QUERY_PARAMS(String, "inspector", ZH_WORDS_GETTER("inspect.inspector"), "", false);
	}
	// 3.2 定义查询接口处理
	ENDPOINT(API_M_GET, "/inspect/search_all", queryInspect, QUERIES(QueryParams, queryParams), API_HANDLER_AUTH_PARAME) {
		// 解析查询参数为Query领域模型
		API_HANDLER_QUERY_PARAM(userQuery, InspectQuery, queryParams);
		// 呼叫执行函数响应结果
		API_HANDLER_RESP_VO(execQueryInspect(userQuery, authObject->getPayload()));
	}

	//3.1 定义查询检验单详情接口描述
	ENDPOINT_INFO(queryInspect_detail) {
	// 定义接口标题
	API_DEF_ADD_TITLE(ZH_WORDS_GETTER("inspect.detail.summary"));
	// 定义默认授权参数（可选定义，如果定义了，下面ENDPOINT里面需要加入API_HANDLER_AUTH_PARAME）
	API_DEF_ADD_AUTH();
	// 定义响应参数格式
	API_DEF_ADD_RSP_JSON_WRAPPER(Inspect_detailPageJsonVO);
	// 定义分页查询参数描述
	API_DEF_ADD_PAGE_PARAMS();
	// 定义其他查询参数描述
	API_DEF_ADD_QUERY_PARAMS(UInt64, "line_id", ZH_WORDS_GETTER("inspect.line_id"), 1, false);
	}
	// 3.2 定义查询来料检验详情接口处理
	ENDPOINT(API_M_GET, "/Inspect/detail", queryInspect_detail, QUERIES(QueryParams, queryParams), API_HANDLER_AUTH_PARAME) {
		// 解析查询参数为Query领域模型
		API_HANDLER_QUERY_PARAM(userQuery, Inspect_detailQuery, queryParams);
		// 呼叫执行函数响应结果
		API_HANDLER_RESP_VO(execQueryInspect_detail(userQuery, authObject->getPayload()));
	}

	////3.1 定义查看报表接口描述
	//ENDPOINT_INFO(queryInspect_table) {
	//	// 定义接口标题
	//	API_DEF_ADD_TITLE(ZH_WORDS_GETTER("inspect.table.summary"));
	//	// 定义默认授权参数（可选定义，如果定义了，下面ENDPOINT里面需要加入API_HANDLER_AUTH_PARAME）
	//	API_DEF_ADD_AUTH();
	//	// 定义响应参数格式
	//	API_DEF_ADD_RSP_JSON_WRAPPER(Inspect_tableJsonVO);
	//	// 定义分页查询参数描述
	//	API_DEF_ADD_PAGE_PARAMS();
	//	// 定义其他查询参数描述
	//	API_DEF_ADD_QUERY_PARAMS(UInt64, "line_id", ZH_WORDS_GETTER("inspect.line_id"), 1, false);
	//}
	//// 3.2 定义查看报表接口处理
	//ENDPOINT(API_M_GET, "/Inspect/table", queryInspect_table, QUERIES(QueryParams, queryParams), API_HANDLER_AUTH_PARAME) {
	//	// 解析查询参数为Query领域模型
	//	API_HANDLER_QUERY_PARAM(userQuery, Inspect_tableQuery, queryParams);
	//	// 呼叫执行函数响应结果
	//	API_HANDLER_RESP_VO(execQueryInspect_table(userQuery, authObject->getPayload()));
	//}

	// 3.1 定义新增接口描述
	ENDPOINT_INFO(addInspect) {
		// 定义接口标题
		API_DEF_ADD_TITLE(ZH_WORDS_GETTER("inspect.add.summary"));
		// 定义默认授权参数（可选定义，如果定义了，下面ENDPOINT里面需要加入API_HANDLER_AUTH_PARAME）
		API_DEF_ADD_AUTH();
		// 定义响应参数格式
		API_DEF_ADD_RSP_JSON_WRAPPER(Uint64JsonVO);
	}
	// 3.2 定义新增接口处理
	ENDPOINT(API_M_POST, "/inspect/add", addInspect, BODY_DTO(InspectDTO::Wrapper, dto), API_HANDLER_AUTH_PARAME) {
		// 呼叫执行函数响应结果
		API_HANDLER_RESP_VO(execAddInspect(dto));
	}

	// 3.1 定义修改接口描述
	API_DEF_ENDPOINT_INFO_AUTH(ZH_WORDS_GETTER("inspect.change.summary"), modifyInspect, Uint64JsonVO::Wrapper);
	// 3.2 定义修改接口处理
	API_HANDLER_ENDPOINT_AUTH(API_M_PUT, "/inspect/change", modifyInspect, BODY_DTO(InspectDTO::Wrapper, dto), execModifyInspect(dto));

	// 3.1 定义删除接口描述
	ENDPOINT_INFO(removeInspect) {
		// 定义标题和返回类型以及授权支持
		API_DEF_ADD_COMMON_AUTH(ZH_WORDS_GETTER("inspect.delete.summary"), Uint64JsonVO::Wrapper);
		// 定义其他路径参数说明
		API_DEF_ADD_PATH_PARAMS(UInt64, "line_id", ZH_WORDS_GETTER("Inspect.line_id"), 1, true);
	}
	// 3.2 定义删除接口处理
	API_HANDLER_ENDPOINT_AUTH(API_M_DEL, "/inspect/delete/{line_id}", removeInspect, PATH(UInt64, line_id), execRemoveInspect(line_id));

	// 3.1 定义导出接口描述
	API_DEF_ENDPOINT_INFO_AUTH(ZH_WORDS_GETTER("inspect.export.summary"), exportInspect, StringJsonVO::Wrapper);
	// 3.2 定义导出接口处理
	API_HANDLER_ENDPOINT_AUTH(API_M_POST, "/inspect/export", exportInspect, BODY_DTO(oatpp::List<UInt64>, ids), execExportInspect(ids));

	//// 查看报表的接口可能是这个
	//// 定义描述
	//ENDPOINT_INFO(downloadFile) {
	//	API_DEF_ADD_COMMON(ZH_WORDS_GETTER("file.download.summary"), Void);
	//	API_DEF_ADD_QUERY_PARAMS(String, "filename", ZH_WORDS_GETTER("file.field.filename"), "file/test.jpg", true);
	//}
	//// 定义端点
	//ENDPOINT(API_M_GET, "/file/download", downloadFile, QUERY(String, filename)) {
	//	return execDownloadFile(filename);
	//}

	// 3.1 定义确认检验单接口描述
	API_DEF_ENDPOINT_INFO_AUTH(ZH_WORDS_GETTER("inspect.is_ok.summary"), Is_OkInspect, Uint64JsonVO::Wrapper);
	// 3.2 定义确认检验单接口处理
	API_HANDLER_ENDPOINT_AUTH(API_M_PUT, "/inspect/is_ok", Is_OkInspect, BODY_DTO(Item_idDTO::Wrapper, dto), execIs_OkInspect(dto));

	// 3.1 定义完成检验单接口描述
	API_DEF_ENDPOINT_INFO_AUTH(ZH_WORDS_GETTER("inspect.finished.summary"), Is_FinishedInspect, Uint64JsonVO::Wrapper);
	// 3.2 定义完成检验单接口处理
	API_HANDLER_ENDPOINT_AUTH(API_M_PUT, "/inspect/finished", Is_FinishedInspect, BODY_DTO(Item_idDTO::Wrapper, dto), execIs_FinishedInspect(dto));


private:
	// 3.3 分页查询来料列表数据
	InspectPageJsonVO::Wrapper execQueryInspect(const InspectQuery::Wrapper& query, const PayloadDTO& payload);
	//3.3 分页查询来料检验表详情
	Inspect_detailPageJsonVO::Wrapper execQueryInspect_detail(const Inspect_detailQuery::Wrapper& query, const PayloadDTO& payload);
	//3.3查看报表
	Inspect_detailJsonVO::Wrapper execQueryInspect_table(const Inspect_tableQuery::Wrapper& query, const PayloadDTO& payload);
	// 3.3 新增数据
	Uint64JsonVO::Wrapper execAddInspect(const InspectDTO::Wrapper& dto);
	// 3.3 修改数据
	Uint64JsonVO::Wrapper execModifyInspect(const InspectDTO::Wrapper& dto);
	// 3.3 删除数据
	Uint64JsonVO::Wrapper execRemoveInspect(const UInt64& id);
	// 3.3导出数据
	StringJsonVO::Wrapper execExportInspect(const oatpp::List<UInt64>& ids);
	//3.3确认检验单(检验单状态置为草稿状态)
	Uint64JsonVO::Wrapper execIs_OkInspect(const Item_idDTO::Wrapper& dto);
	//3.3完成检验单(检验单状态置为已确认状态)
	Uint64JsonVO::Wrapper execIs_FinishedInspect(const Item_idDTO::Wrapper& dto);
};

// 0 取消API控制器使用宏
#include OATPP_CODEGEN_END(ApiController) //<- End Codegen
#endif // _INSPECT_CONTROLLER_
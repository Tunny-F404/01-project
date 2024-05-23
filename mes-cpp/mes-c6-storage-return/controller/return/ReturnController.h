#pragma once

#ifndef _RCONTROLLER_H_
#define _RCONTROLLER_H_
#include "oatpp-swagger/Types.hpp"
#include "../../domain/query/return/ReturnQuery.h"
#include "domain/vo/BaseJsonVO.h"
#include "domain/vo/return/ReturnVO.h"
#include "ApiHelper.h"

using namespace oatpp;

#include OATPP_CODEGEN_BEGIN(ApiController) //<- Begin Codegen

class ReturnController : public oatpp::web::server::api::ApiController
{
	// 添加访问定义
	API_ACCESS_DECLARE(ReturnController);
public:
	// 定义查询所有单据信息接口端点描述
	ENDPOINT_INFO(queryAllReturn) {
		// 定义接口通用信息
		API_DEF_ADD_COMMON_AUTH(ZH_WORDS_GETTER("return.query-all.summary"), ReturnPageJsonVO::Wrapper);
		// 定义分页查询参数描述
		API_DEF_ADD_PAGE_PARAMS();
		// 定义其他查询参数描述
		API_DEF_ADD_QUERY_PARAMS(String, "returnName", ZH_WORDS_GETTER("return.fields.rtname"), "01star", true);
	}
	// 定义查询所有单据信息接口端点处理
	API_HANDLER_ENDPOINT_QUERY_AUTH(API_M_GET, "/return/query-all", queryAllReturn, ReturnQuery, executeQueryAll(query));


	// 定义修改单据接口描述
	API_DEF_ENDPOINT_INFO_AUTH(ZH_WORDS_GETTER("return.modify-return.summary"), modifyReturn, Uint64JsonVO::Wrapper);
	// 定义修改单据接口处理
	API_HANDLER_ENDPOINT_AUTH(API_M_PUT, "/return/modify-return", modifyReturn, BODY_DTO(ReturnDTO::Wrapper, dto), executeModifyReturn(dto));

	// 定义执行退货接口描述
	API_DEF_ENDPOINT_INFO_AUTH(ZH_WORDS_GETTER("return.execute-return.summary"), executeReturn, Uint64JsonVO::Wrapper);
	// 定义执行退货接口处理 "/return/{returnId}"必须对应
	API_HANDLER_ENDPOINT_AUTH(API_M_DEL, "/return/{returnIdexec}", executeReturn, PATH(UInt64, returnIdexec), executeExecuteReturn(returnIdexec));

	// 定义删除单据接口描述
	API_DEF_ENDPOINT_INFO_AUTH(ZH_WORDS_GETTER("return.remove-return.summary"), removeReturn, Uint64JsonVO::Wrapper);
	// 定义删除单据接口处理 "/return/{returnId}"必须对应
	API_HANDLER_ENDPOINT_AUTH(API_M_DEL, "/return/{returnIdremo}", removeReturn, PATH(UInt64, returnIdremo), executeRemoveReturn(returnIdremo));

	// 定义导出单据接口描述
	ENDPOINT_INFO(downloadFile) {
		API_DEF_ADD_COMMON(ZH_WORDS_GETTER("return.download-return.summary"), Void);
		API_DEF_ADD_QUERY_PARAMS(String, "filename", ZH_WORDS_GETTER("return.fields.filename"), "file/C6RyanTest.jpg", true);
	}
	// 定义导出单据接口处理
	ENDPOINT(API_M_GET, "/return/download", downloadFile, QUERY(String, filename)) {
		return executeDownloadFile(filename);
	}
private:
	// 查询所有单据信息
	ReturnPageJsonVO::Wrapper executeQueryAll(const ReturnQuery::Wrapper& returnQuery);
	// 修改单据
	Uint64JsonVO::Wrapper executeModifyReturn(const ReturnDTO::Wrapper& dto);
	// 执行单据
	Uint64JsonVO::Wrapper executeExecuteReturn(const UInt64& id);
	// 删除单据
	Uint64JsonVO::Wrapper executeRemoveReturn(const UInt64& id);
	// 导出单据
	std::shared_ptr<OutgoingResponse> executeDownloadFile(const String& filename);
};

#include OATPP_CODEGEN_END(ApiController) //<- End Codegen

#endif // _RCONTROLLER_H_
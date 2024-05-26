#pragma once
/*
 Copyright Zero One Star. All rights reserved.

 @Author: awei
 @Date: 2022/12/01 17:39:36

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

	  https://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
*/
#ifndef _RETURNCONTROLLER_H_
#define _RETURNCONTROLLER_H_
#include "oatpp-swagger/Types.hpp"
#include "domain/query/return/ReturnQuery.h"
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
	// 3.1 定义查询接口描述
	ENDPOINT_INFO(queryAllReturn) {
		// 定义接口标题
		API_DEF_ADD_TITLE(ZH_WORDS_GETTER("return.query-all.summary"));
		// 定义默认授权参数（可选定义，如果定义了，下面ENDPOINT里面需要加入API_HANDLER_AUTH_PARAME）
		API_DEF_ADD_AUTH();
		// 定义响应参数格式
		API_DEF_ADD_RSP_JSON_WRAPPER(ReturnPageJsonVO);
		// 定义分页查询参数描述
		API_DEF_ADD_PAGE_PARAMS();
		// 定义其他查询参数描述
		// 退货单名称
		API_DEF_ADD_QUERY_PARAMS(String, "returnName", ZH_WORDS_GETTER("return.fields.rtname"), "01star", false);
		// 退货单编号
		API_DEF_ADD_QUERY_PARAMS(String, "returnId", ZH_WORDS_GETTER("return.fields.rtid"), "RTV123456", false);
		// 采购单编号
		API_DEF_ADD_QUERY_PARAMS(String, "purchaseId", ZH_WORDS_GETTER("return.fields.puid"), "null", false);
		// 供应商名称
		API_DEF_ADD_QUERY_PARAMS(String, "vendorName", ZH_WORDS_GETTER("return.fields.vename"), "01star", false);
	}
	// 3.2 定义查询接口处理
	ENDPOINT(API_M_GET, "/return/query-all", queryAllReturn, QUERIES(QueryParams, queryParams), API_HANDLER_AUTH_PARAME) {
		// 解析查询参数为Query领域模型
		API_HANDLER_QUERY_PARAM(query, ReturnQuery, queryParams);
		// 呼叫执行函数响应结果
		API_HANDLER_RESP_VO(executeQueryAll(query, authObject->getPayload()));
	}

	// 定义查询单个单据详细信息接口描述
	ENDPOINT_INFO(queryReturnDetail) {
		// 定义接口标题
		API_DEF_ADD_TITLE(ZH_WORDS_GETTER("return.query-detail.summary"));
		// 定义响应参数格式
		API_DEF_ADD_RSP_JSON_WRAPPER(ReturnDetailJsonVO);
		// 定义默认授权参数
		API_DEF_ADD_AUTH();
		// 定义其他查询参数描述
		// 退货单编号
		API_DEF_ADD_QUERY_PARAMS(String, "returnId", ZH_WORDS_GETTER("return.fields.rtid"), "RTV123456", true);
	}
	// 定义查询单据详细信息接口端点处理
	ENDPOINT(API_M_GET, "/return/query-detail", queryReturnDetail, QUERIES(QueryParams, queryParams), API_HANDLER_AUTH_PARAME) {
		// 解析查询参数为Query领域模型
		API_HANDLER_QUERY_PARAM(query, ReturnDetailQuery, queryParams);
		// 呼叫执行函数响应结果
		API_HANDLER_RESP_VO(executeQueryDetail(query));
	}

	// 定义添加新单据信息接口描述
	ENDPOINT_INFO(addReturnDetail) {
		// 定义接口标题
		API_DEF_ADD_TITLE(ZH_WORDS_GETTER("return.add-detail.summary"));
		// 定义响应参数格式
		API_DEF_ADD_RSP_JSON_WRAPPER(Uint64JsonVO);
		// 定义默认授权参数
		API_DEF_ADD_AUTH();
		// 定义其他查询参数描述
		// 退货单编号
		API_DEF_ADD_QUERY_PARAMS(String, "returnCode", ZH_WORDS_GETTER("return.fields.rtcode"), "RTV123", true);
		// 退货单名称
		API_DEF_ADD_QUERY_PARAMS(String, "returnName", ZH_WORDS_GETTER("return.fields.rtname"), "01star", true);
		// 采购单编号
		API_DEF_ADD_QUERY_PARAMS(String, "purchaseCode", ZH_WORDS_GETTER("return.fields.pucode"), "null", false);
		// 供应商名称
		API_DEF_ADD_QUERY_PARAMS(String, "vendorName", ZH_WORDS_GETTER("return.fields.vename"), "01star", true);
		// 批次号
		API_DEF_ADD_QUERY_PARAMS(String, "batchCode", ZH_WORDS_GETTER("return.fields.batchcode"), "null", false);
		// 退货日期
		API_DEF_ADD_QUERY_PARAMS(String, "returndate", ZH_WORDS_GETTER("return.fields.rtdate"), "2024-5-21", true);
		// 单据状态
		API_DEF_ADD_QUERY_PARAMS(String, "status", ZH_WORDS_GETTER("return.fields.status"), "PREPARE", true);
		// 备注
		API_DEF_ADD_QUERY_PARAMS(String, "remark", ZH_WORDS_GETTER("return.fields.remark"), " ", false);
	}
	// 定义新增单据详细信息接口端点处理
	ENDPOINT(API_M_POST, "/return/add-detail", addReturnDetail, BODY_DTO(ReturnAdd::Wrapper, dto), API_HANDLER_AUTH_PARAME) {
		// 呼叫执行函数响应结果
		API_HANDLER_RESP_VO(execAddDetail(dto));
	}
	// 定义修改单据接口描述
	API_DEF_ENDPOINT_INFO_AUTH(ZH_WORDS_GETTER("return.modify-return.summary"), modifyReturn, Uint64JsonVO::Wrapper);
	// 定义修改单据接口处理
	API_HANDLER_ENDPOINT_AUTH(API_M_PUT, "/return/modify-return", modifyReturn, BODY_DTO(ReturnDTO::Wrapper, dto), execModifyReturn(dto));

	// 定义执行退货接口描述
	API_DEF_ENDPOINT_INFO_AUTH(ZH_WORDS_GETTER("return.execute-return.summary"), executeReturn, Uint64JsonVO::Wrapper);
	// 定义执行退货接口处理 "/return/{returnId}"必须对应
	API_HANDLER_ENDPOINT_AUTH(API_M_DEL, "/return/{returnCodeexec}", executeReturn, PATH(String, returnCodeexec), execExecuteReturn(returnCodeexec));

	// 定义删除单据接口描述
	API_DEF_ENDPOINT_INFO_AUTH(ZH_WORDS_GETTER("return.remove-return.summary"), removeReturn, Uint64JsonVO::Wrapper);
	// 定义删除单据接口处理 "/return/{returnId}"必须对应
	API_HANDLER_ENDPOINT_AUTH(API_M_DEL, "/return/{returnCoderemo}", removeReturn, PATH(String, returnCoderemo), execRemoveReturn(returnCoderemo));

	// 定义导出单据接口描述
	ENDPOINT_INFO(downloadFile) {
		API_DEF_ADD_COMMON(ZH_WORDS_GETTER("return.download-return.summary"), Void);
		API_DEF_ADD_QUERY_PARAMS(String, "code", ZH_WORDS_GETTER("return.fields.filename"), "1", true);
	}
	// 定义导出单据接口处理
	ENDPOINT(API_M_GET, "/return/download", downloadFile, QUERY(String, code)) {
		return execDownloadFile(code);
	}

private:
	// 查询所有单据信息
	ReturnPageJsonVO::Wrapper executeQueryAll(const ReturnQuery::Wrapper& returnQuery, const PayloadDTO& payload);
	// 查询单一单据详细信息
	ReturnDetailJsonVO::Wrapper executeQueryDetail(const ReturnDetailQuery::Wrapper& returnDetailQuery);
	// 添加新单据详细信息
	Uint64JsonVO::Wrapper execAddDetail(const ReturnAdd::Wrapper& returnAdd);
	// 修改单据
	Uint64JsonVO::Wrapper execModifyReturn(const ReturnDTO::Wrapper& dto);
	// 执行单据
	Uint64JsonVO::Wrapper execExecuteReturn(const String& code);
	// 删除单据
	Uint64JsonVO::Wrapper execRemoveReturn(const String& code);
	// 导出单据
	std::shared_ptr<OutgoingResponse> execDownloadFile(const String& code);

};

#include OATPP_CODEGEN_END(ApiController) //<- End Codegen

#endif // _RETURNCONTROLLER_H_
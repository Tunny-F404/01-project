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
#include "../../domain/query/return/ReturnQuery.h"
#include "domain/vo/BaseJsonVO.h"
#include "domain/vo/return/ReturnVO.h"

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

	// 定义修改单据信息端点描述
	ENDPOINT_INFO(modifyReturn) {
		// 定义接口通用信息
		API_DEF_ADD_COMMON_AUTH(ZH_WORDS_GETTER("return.modify-return.summary"), StringJsonVO::Wrapper);
		// 定义修改查询参数描述
		API_DEF_ADD_QUERY_PARAMS(Int32, "age", ZH_WORDS_GETTER("return.field.age"), 100, false);
		API_DEF_ADD_QUERY_PARAMS(String, "nickname", ZH_WORDS_GETTER("return.field.nickname"), "feifei", false);
		// 定义二进制流请求方式，用于选择上传文件
		info->addConsumes<oatpp::swagger::Binary>("application/octet-stream");
	}
	// 定义修改单据信息端点处理（注意：此方式只支持单文件上传，并且更新字段不是很多的场景使用）
	ENDPOINT(API_M_POST, "/return/modify-return", modifyReturn, BODY_STRING(String, fileBody), QUERIES(QueryParams, qps), API_HANDLER_AUTH_PARAME) {
		// 解析查询参数
		API_HANDLER_QUERY_PARAM(dto, ReturnDTO, qps);
		// 执行文件保存逻辑
		API_HANDLER_RESP_VO(executeModifyReturn(fileBody, dto));
	}
private:
	// 查询所有单据信息
	ReturnPageJsonVO::Wrapper executeQueryAll(const ReturnQuery::Wrapper& returnQuery);
	// 修改单据信息
	StringJsonVO::Wrapper executeModifyReturn(const String& fileBody, const ReturnDTO::Wrapper& dto);

};

#include OATPP_CODEGEN_END(ApiController) //<- End Codegen

#endif // _RETURNCONTROLLER_H_
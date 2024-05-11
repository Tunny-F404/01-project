#pragma once
/*
 Copyright Zero One Star. All rights reserved.

 @Author: awei
 @Date: 2024/05/11 21:16:11

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
#ifndef _TESTCONTROLLER_H_
#define _TESTCONTROLLER_H_

#include "ApiHelper.h"
#include "ServerInfo.h"
#include "domain/vo/BaseJsonVO.h"
#include "domain/query/PageQuery.h"

#include OATPP_CODEGEN_BEGIN(ApiController)

class TestContrller : public oatpp::web::server::api::ApiController
{
	// 定义控制器访问入口
	API_ACCESS_DECLARE(TestContrller);
public: // 定义接口
	// path请求
	ENDPOINT_INFO(getUserById) {
		API_DEF_ADD_TITLE(ZH_WORDS_GETTER("sample.get.summary"));
		API_DEF_ADD_PATH_PARAMS(Int64, "userId",
			ZH_WORDS_GETTER("sample.get.fields.uid.desc"),
			1,
			true);
	}
	ENDPOINT(API_M_GET, "/users/{userId}", getUserById, PATH(Int64, userId))
	{
		OATPP_LOGD("Test", "userId=%d", userId.getValue(0));
		return createResponse(Status::CODE_200, "OK");
	}
	
	// 查询请求
	ENDPOINT_INFO(getUsers) {
		API_DEF_ADD_TITLE(ZH_WORDS_GETTER("sample.get1.summary"));
		API_DEF_ADD_QUERY_PARAMS(Int32, "age",
			ZH_WORDS_GETTER("sample.get1.fields.age.desc"),
			100,
			true);
	}
	ENDPOINT(API_M_GET, "/users", getUsers, QUERY(Int32, age))
	{
		OATPP_LOGD("Test", "age=%d", age.getValue(0));
		return createResponse(Status::CODE_200, "OK");
	}

	// 响应对象
	ENDPOINT_INFO(getPage) {
		API_DEF_ADD_TITLE(ZH_WORDS_GETTER("sample.get2.summary"));
		// 定义分页描述
		API_DEF_ADD_PAGE_PARAMS();
		// 定义响应描述
		API_DEF_ADD_RSP_JSON_WRAPPER(StringJsonVO);
		//API_DEF_ADD_RSP_JSON(StringJsonVO::Wrapper);
	}
	ENDPOINT(API_M_GET, "/users1/page", getPage, QUERIES(QueryParams, params)) {
		// 解析查询参数
		API_HANDLER_QUERY_PARAM(query, PageQuery, params);
		// 响应结果
		API_HANDLER_RESP_VO(executeGetPage(query));
	}
private: // 定义接口执行函数
	StringJsonVO::Wrapper executeGetPage(const PageQuery::Wrapper& query);
};

#include OATPP_CODEGEN_END(ApiController)

#endif // !_TESTCONTROLLER_H_
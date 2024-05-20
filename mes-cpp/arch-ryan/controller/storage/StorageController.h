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
#ifndef _STORAGECONTROLLER_H_
#define _STORAGECONTROLLER_H_
#include "oatpp-swagger/Types.hpp"
#include "../../domain/vo/storage/StorageVO.h"
#include "../../domain/query/storage/StorageQuery.h"
using namespace oatpp;

#include OATPP_CODEGEN_BEGIN(ApiController) //<- Begin Codegen

/*
* 仓库管理控制器
*/
class StorageController : public oatpp::web::server::api::ApiController
{
	// 添加访问定义
	API_ACCESS_DECLARE(StorageController);
public:
	// 定义查询所有用户信息接口端点描述
	ENDPOINT_INFO(queryStorageTable) {
		// 定义接口通用信息
		API_DEF_ADD_TITLE(ZH_WORDS_GETTER("storage.query.summary"));
		API_DEF_ADD_AUTH();
		API_DEF_ADD_RSP_JSON_WRAPPER(StorageTableJsonVO);
		// 定义其他查询参数描述
		API_DEF_ADD_QUERY_PARAMS(String, "returnName", ZH_WORDS_GETTER("storage.fields.rtname"), "li ming", false);
	}
	// 定义查询所有用户信息接口端点处理
	ENDPOINT(API_M_GET, "/storage/query-storage-table", queryStorageTable, QUERIES(QueryParams, queryParams), API_HANDLER_AUTH_PARAME)
	{
		API_HANDLER_QUERY_PARAM(query, StorageQuery, queryParams);
		API_HANDLER_RESP_VO(execqueryStorageTable(query));
	}

private:
	StorageTableJsonVO::Wrapper execqueryStorageTable(const StorageQuery::Wrapper& query);

	
};

#include OATPP_CODEGEN_END(ApiController) //<- End Codegen

#endif // _USERCONTROLLER_H_
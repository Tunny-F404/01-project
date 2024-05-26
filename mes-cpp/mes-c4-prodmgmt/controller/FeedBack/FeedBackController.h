#pragma once

/*
 Copyright Zero One Star. All rights reserved.

 @Author: awei
 @Date: 2022/10/25 0:27:04

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
#ifndef _FEEDBACKCONTROLLER_
#define _FEEDBACKCONTROLLER_

#include "domain/vo/BaseJsonVO.h"
#include "domain/query/FeedBack/FeedBackQuery.h"
#include "domain/dto/FeedBack/FeedBackDTO.h"
#include "domain/vo/FeedBack/FeedBackVO.h"

// 0 定义API控制器使用宏
#include OATPP_CODEGEN_BEGIN(ApiController) //<- Begin Codegen

/*
*
* 报工控制器
* 
*/

class FeedBackController : public oatpp::web::server::api::ApiController // 1 继承控制器
{
	// 2 定义控制器访问入口
	API_ACCESS_DECLARE(FeedBackController);
	// 3 定义接口
public:
	// 3.1 定义查询接口描述
	ENDPOINT_INFO(queryFeedBackTable) {
		// 定义接口标题
		API_DEF_ADD_TITLE(ZH_WORDS_GETTER("prod.get.summary"));
		// 定义默认授权参数（可选定义，如果定义了，下面ENDPOINT里面需要加入API_HANDLER_AUTH_PARAME）
		API_DEF_ADD_AUTH();
		// 定义响应参数格式
		API_DEF_ADD_RSP_JSON_WRAPPER(FeedBackPageJsonVO);
		// 定义分页查询参数描述
		API_DEF_ADD_PAGE_PARAMS();
		// 定义其他查Q
		API_DEF_ADD_QUERY_PARAMS(String, "feedbackType", ZH_WORDS_GETTER("prod.field.feedback_type"), "N", false);
		API_DEF_ADD_QUERY_PARAMS(String, "workstationName", ZH_WORDS_GETTER("prod.field.workstation_name"), "N", false);
		API_DEF_ADD_QUERY_PARAMS(String, "workorderCode", ZH_WORDS_GETTER("prod.field.workorder_code"), "N", false);
		API_DEF_ADD_QUERY_PARAMS(String, "itemCode", ZH_WORDS_GETTER("prod.field.item_code"), "N", false);
		API_DEF_ADD_QUERY_PARAMS(String, "itemName", ZH_WORDS_GETTER("prod.field.item_name"), "N", false);
		API_DEF_ADD_QUERY_PARAMS(String, "specification", ZH_WORDS_GETTER("prod.field.specification"), "N", false);
		API_DEF_ADD_QUERY_PARAMS(Int32, "feedbackQuantity", ZH_WORDS_GETTER("prod.field.quantity_feedback"), 0, false);
		API_DEF_ADD_QUERY_PARAMS(String, "userName", ZH_WORDS_GETTER("prod.field.user_name"), "N", false);
		API_DEF_ADD_QUERY_PARAMS(String, "feedbackTime", ZH_WORDS_GETTER("prod.field.feedback_time"), "N", false);
		API_DEF_ADD_QUERY_PARAMS(String, "recordUser", ZH_WORDS_GETTER("prod.field.record_user"), "N", false);
		API_DEF_ADD_QUERY_PARAMS(String, "status", ZH_WORDS_GETTER("prod.field.status"), "N", false);

	}
	// 3.2 定义查询接口处理
	ENDPOINT(API_M_GET, "/query-feedback-table", queryFeedBackTable, QUERIES(QueryParams, queryParams), API_HANDLER_AUTH_PARAME) {
		// 解析查询参数为Query领域模型
		API_HANDLER_QUERY_PARAM(query, FeedBackQuery, queryParams);
		// 呼叫执行函数响应结果
		API_HANDLER_RESP_VO(execQueryFeedBack(query));
	}
	/*
	// 3.1 定义新增接口描述
	ENDPOINT_INFO(addSample) {
		// 定义接口标题
		API_DEF_ADD_TITLE(ZH_WORDS_GETTER("sample.post.summary"));
		// 定义默认授权参数（可选定义，如果定义了，下面ENDPOINT里面需要加入API_HANDLER_AUTH_PARAME）
		API_DEF_ADD_AUTH();
		// 定义响应参数格式
		API_DEF_ADD_RSP_JSON_WRAPPER(Uint64JsonVO);
	}
	// 3.2 定义新增接口处理
	ENDPOINT(API_M_POST, "/sample", addSample, BODY_DTO(SampleDTO::Wrapper, dto), API_HANDLER_AUTH_PARAME) {
		// 呼叫执行函数响应结果
		API_HANDLER_RESP_VO(execAddSample(dto));
	}

	// 3.1 定义修改接口描述
	API_DEF_ENDPOINT_INFO_AUTH(ZH_WORDS_GETTER("sample.put.summary"), modifySample, Uint64JsonVO::Wrapper);
	// 3.2 定义修改接口处理
	API_HANDLER_ENDPOINT_AUTH(API_M_PUT, "/sample", modifySample, BODY_DTO(SampleDTO::Wrapper, dto), execModifySample(dto));

	// 3.1 定义删除接口描述
	ENDPOINT_INFO(removeSample) {
		// 定义标题和返回类型以及授权支持
		API_DEF_ADD_COMMON_AUTH(ZH_WORDS_GETTER("sample.delete.summary"), Uint64JsonVO::Wrapper);
		// 定义其他路径参数说明
		API_DEF_ADD_PATH_PARAMS(UInt64, "id", ZH_WORDS_GETTER("sample.field.id"), 1, true);
	}
	// 3.2 定义删除接口处理
	API_HANDLER_ENDPOINT_AUTH(API_M_DEL, "/sample/{id}", removeSample, PATH(UInt64, id), execRemoveSample(id));

	// 3.1 定义测试声明式服务调用的接口1描述
	ENDPOINT_INFO(queryOne) {
		// 定义标题和返回类型以及授权支持
		API_DEF_ADD_COMMON_AUTH(ZH_WORDS_GETTER("sample.query-one.summary"), SampleJsonVO::Wrapper);
		// 定义其他路径参数说明
		API_DEF_ADD_QUERY_PARAMS(UInt64, "id", ZH_WORDS_GETTER("sample.field.id"), 1, true);
	}
	// 3.2 定义测试声明式服务调用的接口1处理
	API_HANDLER_ENDPOINT_AUTH(API_M_GET, "/sample/query-one", queryOne, QUERY(UInt64, id), execQueryOne(id, authObject->getPayload()));

	// 3.1 定义测试声明式服务调用的接口2描述
	ENDPOINT_INFO(queryAll) {
		// 定义标题和返回类型以及授权支持
		API_DEF_ADD_COMMON_AUTH(ZH_WORDS_GETTER("sample.query-all.summary"), SamplePageJsonVO::Wrapper);
		// 定义分页查询参数描述
		API_DEF_ADD_PAGE_PARAMS();
		// 定义其他查询参数描述
		API_DEF_ADD_QUERY_PARAMS(String, "name", ZH_WORDS_GETTER("sample.field.name"), "li ming", false);
	}
	// 3.2 定义测试声明式服务调用的接口1处理
	API_HANDLER_ENDPOINT_QUERY_AUTH(API_M_GET, "/sample/query-all", queryAll, SampleQuery, execQueryAll(query, authObject->getPayload()));
	*/
private:
	// 3.3 演示分页查询数据
	FeedBackPageJsonVO::Wrapper execQueryFeedBack(const FeedBackQuery::Wrapper& query);

};

// 0 取消API控制器使用宏
#include OATPP_CODEGEN_END(ApiController) //<- End Codegen
#endif // _FEEDBACKCONTROLLER_
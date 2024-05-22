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
#ifndef _PRODORDER_CONTROLLER_
#define _PRODORDER_CONTROLLER_

#include "domain/vo/BaseJsonVO.h"
#include "domain/query/ProdOrder/ProdOrderQuery.h"
#include "domain/dto/ProdOrder/ProdOrderDTO.h"
#include "domain/vo/ProdOrder/ProdOrderVO.h"

// 0 定义API控制器使用宏
#include OATPP_CODEGEN_BEGIN(ApiController) //<- Begin Codegen

/**
 * 生产任务查询控制器，基础接口的使用
 */
class ProdOrderController : public oatpp::web::server::api::ApiController // 1 继承控制器
{
	// 2 定义控制器访问入口
	API_ACCESS_DECLARE(ProdOrderController);

	// 3 定义接口

public:
	// 3.1 定义查询接口描述
	ENDPOINT_INFO(queryProdOrder) {
		// 定义接口标题
		API_DEF_ADD_TITLE(ZH_WORDS_GETTER("prod.get.summary"));
		// 定义默认授权参数（可选定义，如果定义了，下面ENDPOINT里面需要加入API_HANDLER_AUTH_PARAME）
		API_DEF_ADD_AUTH();
		// 定义响应参数格式
		API_DEF_ADD_RSP_JSON_WRAPPER(ProdOrderPageJsonVO);
		// 定义分页查询参数描述
		API_DEF_ADD_PAGE_PARAMS();
		// 定义其他查询参数描述
		API_DEF_ADD_QUERY_PARAMS(String, "task_name", ZH_WORDS_GETTER("prod.field.taskName"), "N", false);
		API_DEF_ADD_QUERY_PARAMS(String, "workstation_name", ZH_WORDS_GETTER("prod.field.workstationName"), "N", false);
		API_DEF_ADD_QUERY_PARAMS(String, "process_name", ZH_WORDS_GETTER("prod.field.processName"), "N", false);
		API_DEF_ADD_QUERY_PARAMS(String, "start_time", ZH_WORDS_GETTER("prod.field.startTime"), "N", false);
		API_DEF_ADD_QUERY_PARAMS(String, "end_time", ZH_WORDS_GETTER("prod.field.endTime"), "N", false);
	}
	// 3.2 定义查询接口处理
	ENDPOINT(API_M_GET, "/prodOrder/query", queryProdOrder, QUERIES(QueryParams, queryParams), API_HANDLER_AUTH_PARAME) {
		// 解析查询参数为Query领域模型
		API_HANDLER_QUERY_PARAM(userQuery, ProdOrderQuery, queryParams);
		// 呼叫执行函数响应结果
		API_HANDLER_RESP_VO(execQueryProdOrder(userQuery, authObject->getPayload()));
	}

	// 3.1 定义新增接口描述
	ENDPOINT_INFO(addProdOrder) {
		// 定义接口标题
		API_DEF_ADD_TITLE(ZH_WORDS_GETTER("prod.post.summary"));
		// 定义默认授权参数（可选定义，如果定义了，下面ENDPOINT里面需要加入API_HANDLER_AUTH_PARAME）
		API_DEF_ADD_AUTH();
		// 定义响应参数格式
		API_DEF_ADD_RSP_JSON_WRAPPER(Uint64JsonVO);
	}
	// 3.2 定义新增接口处理
	ENDPOINT(API_M_POST, "/ProdOrder/add", addProdOrder, BODY_DTO(ProdOrderDTO::Wrapper, dto), API_HANDLER_AUTH_PARAME) {
		// 呼叫执行函数响应结果
		API_HANDLER_RESP_VO(execAddProdOrder(dto));
	}

	// 3.1 定义修改接口描述
	API_DEF_ENDPOINT_INFO_AUTH(ZH_WORDS_GETTER("prod.put.summary"), modifyProdOrder, Uint64JsonVO::Wrapper);
	// 3.2 定义修改接口处理
	API_HANDLER_ENDPOINT_AUTH(API_M_PUT, "/ProdOrder/put", modifyProdOrder, BODY_DTO(ProdOrderDTO::Wrapper, dto), execModifyProdOrder(dto));

	// 3.1 定义删除接口描述
	ENDPOINT_INFO(removeProdOrder) {
		// 定义标题和返回类型以及授权支持
		API_DEF_ADD_COMMON_AUTH(ZH_WORDS_GETTER("prod.delete.summary"), Uint64JsonVO::Wrapper);
		// 定义其他路径参数说明
		API_DEF_ADD_PATH_PARAMS(UInt64, "id", ZH_WORDS_GETTER("sample.field.task_name"), 1, true);
	}
	// 3.2 定义删除接口处理
	API_HANDLER_ENDPOINT_AUTH(API_M_DEL, "/ProdOrder/del", removeProdOrder, PATH(UInt64, id), execRemoveProdOrder(id));

	// 3.1 定义测试声明式服务调用的接口1描述
	ENDPOINT_INFO(queryOne) {
		// 定义标题和返回类型以及授权支持
		API_DEF_ADD_COMMON_AUTH(ZH_WORDS_GETTER("prod.query-one.summary"), ProdOrderJsonVO::Wrapper);
		// 定义其他路径参数说明
		API_DEF_ADD_QUERY_PARAMS(UInt64, "id", ZH_WORDS_GETTER("sample.field.task_name"), 1, true);
	}
	// 3.2 定义测试声明式服务调用的接口1处理
	API_HANDLER_ENDPOINT_AUTH(API_M_GET, "/ProdOrder/query-one", queryOne, QUERY(UInt64, id), execQueryOne(id, authObject->getPayload()));

	// 3.1 定义测试声明式服务调用的接口2描述
	ENDPOINT_INFO(queryAll) {
		// 定义标题和返回类型以及授权支持
		API_DEF_ADD_COMMON_AUTH(ZH_WORDS_GETTER("prod.query-all.summary"), ProdOrderPageJsonVO::Wrapper);
		// 定义分页查询参数描述
		API_DEF_ADD_PAGE_PARAMS();
		// 定义其他查询参数描述
		API_DEF_ADD_QUERY_PARAMS(String, "name", ZH_WORDS_GETTER("prod.field.task_name"), "li ming", false);
	}
	// 3.2 定义测试声明式服务调用的接口1处理
	API_HANDLER_ENDPOINT_QUERY_AUTH(API_M_GET, "/ProdOrder/query-all", queryAll, ProdOrderQuery, execQueryAll(query, authObject->getPayload()));

private:
	// 3.3 演示分页查询数据
	ProdOrderPageJsonVO::Wrapper execQueryProdOrder(const ProdOrderQuery::Wrapper& query, const PayloadDTO& payload);
	// 3.3 演示新增数据
	Uint64JsonVO::Wrapper execAddProdOrder(const ProdOrderDTO::Wrapper& dto);
	// 3.3 演示修改数据
	Uint64JsonVO::Wrapper execModifyProdOrder(const ProdOrderDTO::Wrapper& dto);
	// 3.3 演示删除数据
	Uint64JsonVO::Wrapper execRemoveProdOrder(const UInt64& id);
	// 3.3 测试声明式服务调用1
	ProdOrderJsonVO::Wrapper execQueryOne(const UInt64& id, const PayloadDTO& payload);
	// 3.3 测试声明式服务调用2
	ProdOrderPageJsonVO::Wrapper execQueryAll(const ProdOrderQuery::Wrapper& query, const PayloadDTO& payload);
};

// 0 取消API控制器使用宏
#include OATPP_CODEGEN_END(ApiController) //<- End Codegen
#endif // _PRODORDER_CONTROLLER_
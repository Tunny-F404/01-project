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
#ifndef _PRODUCT_RECPT_CONTROLLER_
#define _PRODUCT_RECPT_CONTROLLER_

#include "domain/vo/BaseJsonVO.h"
#include "domain/query/item-information/ProductRecptQuery.h"
#include "domain/dto/item-information/ProductRecptDTO.h"
#include "domain/vo/item-information/ProductRecptVO.h"

// 0 定义API控制器使用宏
#include OATPP_CODEGEN_BEGIN(ApiController) //<- Begin Codegen

/**
 * 库区管理控制器
 */
class ProductRecptController : public oatpp::web::server::api::ApiController //继承控制器
{
	//定义控制器访问入口
	API_ACCESS_DECLARE(ProductRecptController);
	//定义接口
public:
	// 1.1 定义分页查询接口描述,接口名为queryProductRecpt
	ENDPOINT_INFO(queryProductRecpt) {
		//定义接口标题
		API_DEF_ADD_TITLE(ZH_WORDS_GETTER("product-recpt.query.summary")); //分页查询产品入库数据
		//定义需要授权
		API_DEF_ADD_AUTH();
		//定义参数返回类型
		API_DEF_ADD_RSP_JSON_WRAPPER(ProductRecptPageJsonVO);
		//定义分页查询参数
		API_DEF_ADD_PAGE_PARAMS();
		//定义其他参数
		API_DEF_ADD_QUERY_PARAMS(String, "recpt_code", ZH_WORDS_GETTER("product_recpt.field.recpt_code"), "recpt_code", false);//入库单编号,输入可以为空
		API_DEF_ADD_QUERY_PARAMS(String, "recpt_name", ZH_WORDS_GETTER("product_recpt.field.recpt_name"), "recpt_name", false);
		API_DEF_ADD_QUERY_PARAMS(String, "workorder_code", ZH_WORDS_GETTER("product_recpt.field.workorder_code"), "workorder_code", false);
		API_DEF_ADD_QUERY_PARAMS(String, "warehouse_name", ZH_WORDS_GETTER("product_recpt.field.warehouse_name"), "warehouse_name", false);
	}
	//1.2定义查询接口处理
	ENDPOINT(API_M_GET, "/ProductRecpt/query-ProductRecpt", queryProductRecpt, QUERIES(QueryParams, queryParams), API_HANDLER_AUTH_PARAME) {
		// 解析查询参数为ProductRecptQuery领域模型
		API_HANDLER_QUERY_PARAM(query, ProductRecptQuery, queryParams);
		// 呼叫执行函数响应结果
		API_HANDLER_RESP_VO(execQueryProductRecpt(query));
	}

private:
	// 1.3 分页查询产品入库
	ProductRecptPageJsonVO::Wrapper execQueryProductRecpt(const ProductRecptQuery::Wrapper& query);
};

// 0 取消API控制器使用宏
#include OATPP_CODEGEN_END(ApiController) //<- End Codegen
#endif // !_PRODUCT_RECPT_CONTROLLER_
#pragma once
#ifndef _PRODUCTCONTROLLER_H_
#define _PRODUCTCONTROLLER_H_

#include "domain/vo/BaseJsonVO.h"
#include "domain/vo/product/ProductVO.h"
#include "domain/dto/product/ProductDTO.h"
#include "domain/query/product/ProductQuery.h"

#include OATPP_CODEGEN_BEGIN(ApiController)

class ProductController : public oatpp::web::server::api::ApiController {
	API_ACCESS_DECLARE(ProductController);
public:
	// 3.1 定义查询接口描述
	ENDPOINT_INFO(queryProductTable) {
		// 定义接口标题
		API_DEF_ADD_TITLE(ZH_WORDS_GETTER("product.summary"));
		// 定义默认授权参数（可选定义，如果定义了，下面ENDPOINT里面需要加入API_HANDLER_AUTH_PARAME）
		API_DEF_ADD_AUTH();
		// 定义响应参数格式
		API_DEF_ADD_RSP_JSON_WRAPPER(ProductTableJsonVO);
		// 定义其他查询参数描述
		API_DEF_ADD_QUERY_PARAMS(String, "pnum", ZH_WORDS_GETTER("product.fields.pnum"), "ISSUE20221115004", false);
		API_DEF_ADD_QUERY_PARAMS(String, "pname", ZH_WORDS_GETTER("product.fields.pname"), "钢筋生产领出", false);
		API_DEF_ADD_QUERY_PARAMS(String, "prname", ZH_WORDS_GETTER("product.fields.prname"), "原料仓", false);
		API_DEF_ADD_QUERY_PARAMS(String, "pdate", ZH_WORDS_GETTER("product.fields.pdate"), "2022-11-15 00:00:00", false);
		API_DEF_ADD_QUERY_PARAMS(String, "pstatus", ZH_WORDS_GETTER("product.fields.pstatus"), "FINISHED", false);

	}
	// 3.2 定义查询接口处理
	ENDPOINT(API_M_GET, "/product/query-product-table", queryProductTable, QUERIES(QueryParams, queryParams), API_HANDLER_AUTH_PARAME) {
		// 解析查询参数为Query领域模型
		API_HANDLER_QUERY_PARAM(query, ProductQuery, queryParams);
		// 呼叫执行函数响应结果
		API_HANDLER_RESP_VO(execProductTable(query));
	}

private:
	// 查询数据
	ProductTableJsonVO::Wrapper execProductTable(const ProductQuery::Wrapper& query);
};
#include OATPP_CODEGEN_END(ApiController) //<- End Codegen
#endif
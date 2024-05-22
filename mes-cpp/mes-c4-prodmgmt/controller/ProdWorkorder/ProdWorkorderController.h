#pragma once
#ifndef _ADDPRODWORKORDER_CONTROLLER_
#define _ADDPRODWORKORDER_CONTROLLER_

#include "domain/vo/BaseJsonVO.h"
#include "../mes-c4-prodmgmt/domain/do/ProdWorkorder/AddProdWorkorderDO.h"
#include "../mes-c4-prodmgmt/domain/dto/ProdWorkorder/AddProdWorkorderDTO.h"
#include "../mes-c4-prodmgmt/domain/vo/ProdWorkorder/AddProdWorkorderVO.h"

#include "../mes-c4-prodmgmt/domain/vo/ProdWorkorder/GetProdWorkorderListVO.h"
#include "../mes-c4-prodmgmt/domain/query/ProdWorkorder/GetProdWorkorderListQuery.h"
#include "../mes-c4-prodmgmt/domain/do/ProdWorkorder/GetProdWorkorderListDO.h"
#include "../mes-c4-prodmgmt/domain/dto/ProdWorkorder/GetProdWorkorderListDTO.h"

#include "../mes-c4-prodmgmt/domain/vo/ProdWorkorder/ProdWorkorderInfoVO.h"
#include "../mes-c4-prodmgmt/domain/dto/ProdWorkorder/ProdWorkorderInfoDTO.h"

// 0 定义API控制器使用宏
#include OATPP_CODEGEN_BEGIN(ApiController) //<- Begin Codegen

/**
 * 新增工单控制器
 */
class ProdWorkorderController : public oatpp::web::server::api::ApiController {// 1 继承控制器
	// 2 定义控制器访问入口
	API_ACCESS_DECLARE(ProdWorkorderController);
	// 3 定义接口
public:

	// 3.1 定义新增接口描述
	ENDPOINT_INFO(addProdWorkorder) {
		// 定义接口标题
		API_DEF_ADD_TITLE(ZH_WORDS_GETTER("addprodworkorder.post.summary"));
		// 定义默认授权参数（可选定义，如果定义了，下面ENDPOINT里面需要加入API_HANDLER_AUTH_PARAME）
		API_DEF_ADD_AUTH();
		// 定义响应参数格式
		API_DEF_ADD_RSP_JSON_WRAPPER(AddProdWorkorderJsonVO);
	}
	// 3.2 定义新增接口处理
	ENDPOINT(API_M_POST, "/ProdWorkorder", addProdWorkorder, BODY_DTO(AddProdWorkorderDTO::Wrapper, dto), API_HANDLER_AUTH_PARAME) {
		// 呼叫执行函数响应结果
		API_HANDLER_RESP_VO(execAddProdWorkorder(dto));
	}
	



	// 3.1 定义查询接口描述
	ENDPOINT_INFO(queryGetProdWorkorderList) {
		// 定义接口标题
		API_DEF_ADD_TITLE(ZH_WORDS_GETTER("getprodworkorderlist.get.summary"));
		// 定义默认授权参数（可选定义，如果定义了，下面ENDPOINT里面需要加入API_HANDLER_AUTH_PARAME）
		API_DEF_ADD_AUTH();
		// 定义响应参数格式
		API_DEF_ADD_RSP_JSON_WRAPPER(GetProdWorkorderListPageJsonVO);
		// 定义分页查询参数描述
		API_DEF_ADD_PAGE_PARAMS();
		// 定义其他查询参数描述
		API_DEF_ADD_QUERY_PARAMS(UInt64, "workorder_id", ZH_WORDS_GETTER("addprodworkorder.workorder.workorder_id"), 9999, false);
		API_DEF_ADD_QUERY_PARAMS(String, "workorder_code", ZH_WORDS_GETTER("addprodworkorder.workorder.workorder_code"), "8888", false);
		API_DEF_ADD_QUERY_PARAMS(String, "workorder_name", ZH_WORDS_GETTER("addprodworkorder.workorder.workorder_name"), "7777", false);
		API_DEF_ADD_QUERY_PARAMS(String, "source_code", ZH_WORDS_GETTER("addprodworkorder.workorder.source_code"), "6666", false);
		API_DEF_ADD_QUERY_PARAMS(String, "product_code", ZH_WORDS_GETTER("addprodworkorder.workorder.product_code"), "5555", false);
		API_DEF_ADD_QUERY_PARAMS(String, "product_name", ZH_WORDS_GETTER("addprodworkorder.workorder.product_name"), "4444", false);
		API_DEF_ADD_QUERY_PARAMS(String, "client_code", ZH_WORDS_GETTER("addprodworkorder.workorder.client_code"), "3333", false);
		API_DEF_ADD_QUERY_PARAMS(String, "client_name", ZH_WORDS_GETTER("addprodworkorder.workorder.client_name"), "2222", false);
		API_DEF_ADD_QUERY_PARAMS(String, "workorder_type", ZH_WORDS_GETTER("addprodworkorder.workorder.workorder_type"), "1111", false);
		API_DEF_ADD_QUERY_PARAMS(String, "request_date", ZH_WORDS_GETTER("addprodworkorder.workorder.request_date"), "0000", false);
	}
	// 3.2 定义查询接口处理
	ENDPOINT(API_M_GET, "/getProdWorkorderList", queryGetProdWorkorderList, QUERIES(QueryParams, queryParams), API_HANDLER_AUTH_PARAME) {
		// 解析查询参数为Query领域模型
		API_HANDLER_QUERY_PARAM(userQuery, GetProdWorkorderListQuery, queryParams);
		// 呼叫执行函数响应结果
		API_HANDLER_RESP_VO(execQueryGetProdWorkorderList(userQuery, authObject->getPayload()));
	}


	// 3.1 定义获取生产工单详情接口描述
	ENDPOINT_INFO(prodWorkorderInfo) {
		// 定义接口标题
		API_DEF_ADD_TITLE(ZH_WORDS_GETTER("prodworkorderinfo.get.summary"));
		// 定义默认授权参数（可选定义，如果定义了，下面ENDPOINT里面需要加入API_HANDLER_AUTH_PARAME）
		API_DEF_ADD_AUTH();
		// 定义响应参数格式
		API_DEF_ADD_RSP_JSON_WRAPPER(ProdWorkorderInfoJsonVO);
	}
	// 3.2 定义获取生产工单详情接口处理
	ENDPOINT(API_M_GET, "/ProdWorkorder/GetDetailInfo", prodWorkorderInfo, BODY_DTO(ProdWorkorderInfoDTO::Wrapper, dto), API_HANDLER_AUTH_PARAME) {
		// 呼叫执行函数响应结果
		API_HANDLER_RESP_VO(execGetProdWorkorderInfo(dto));
	}

	// 3.3 演示新增数据
	AddProdWorkorderJsonVO::Wrapper execAddProdWorkorder(const AddProdWorkorderDTO::Wrapper& dto);
	// 3.3 演示分页查询数据
	GetProdWorkorderListPageJsonVO::Wrapper execQueryGetProdWorkorderList(const GetProdWorkorderListQuery::Wrapper& query, const PayloadDTO& payload);
	// 3.3 演示新增数据
	ProdWorkorderInfoJsonVO::Wrapper execGetProdWorkorderInfo(const ProdWorkorderInfoDTO::Wrapper& dto);
};
// 0 取消API控制器使用宏
#include OATPP_CODEGEN_END(ApiController) //<- End Codegen
#endif // _ADDPRODWORKORDER_CONTROLLER_
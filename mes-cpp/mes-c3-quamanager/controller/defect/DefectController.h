#pragma once
#ifndef _DEFECT_CONTROLLER_
#define _DEFECT_CONTROLLER_

#include "domain/vo/BaseJsonVO.h"
#include "domain/query/defect/DefectQuery.h"
#include "domain/dto/defect/DefectDTO.h"
#include "domain/vo/defect/DefectVO.h"
// 0 定义API控制器使用宏
#include OATPP_CODEGEN_BEGIN(ApiController) //<- Begin Codegen

/**
 * 示例控制器，演示基础接口的使用
 */
class DefectController : public oatpp::web::server::api::ApiController // 1 继承控制器
{
	// 2 定义控制器访问入口
	API_ACCESS_DECLARE(DefectController);
	// 3 定义接口
public:
	// 3.1 定义查询接口描述
	ENDPOINT_INFO(queryDefect) {
		// 定义接口标题
		API_DEF_ADD_TITLE(ZH_WORDS_GETTER("defect.get.summary"));
		// 定义默认授权参数（可选定义，如果定义了，下面ENDPOINT里面需要加入API_HANDLER_AUTH_PARAME）
		API_DEF_ADD_AUTH();
		// 定义响应参数格式
		API_DEF_ADD_RSP_JSON_WRAPPER(DefectPageJsonVO);
		// 定义分页查询参数描述
		API_DEF_ADD_PAGE_PARAMS();
		// 定义其他查询参数描述
		API_DEF_ADD_QUERY_PARAMS(String, "defect_name", ZH_WORDS_GETTER("defect.field.defect_name"), "", false);
		API_DEF_ADD_QUERY_PARAMS(String, "index_type", ZH_WORDS_GETTER("defect.field.index_type"), "APPEARANCE", false);
		API_DEF_ADD_QUERY_PARAMS(String, "defect_level", ZH_WORDS_GETTER("defect.field.defect_level"), "MIN", false);
	}
	// 3.2 定义查询接口处理
	ENDPOINT(API_M_GET, "/defect", queryDefect, QUERIES(QueryParams, queryParams), API_HANDLER_AUTH_PARAME) {
		// 解析查询参数为Query领域模型
		API_HANDLER_QUERY_PARAM(userQuery, DefectQuery, queryParams);
		// 呼叫执行函数响应结果
		API_HANDLER_RESP_VO(execQueryDefect(userQuery, authObject->getPayload()));
	}

	// 3.1 定义新增接口描述
	ENDPOINT_INFO(addDefect) {
		// 定义接口标题
		API_DEF_ADD_TITLE(ZH_WORDS_GETTER("defect.post.summary"));
		// 定义默认授权参数（可选定义，如果定义了，下面ENDPOINT里面需要加入API_HANDLER_AUTH_PARAME）
		API_DEF_ADD_AUTH();
		// 定义响应参数格式
		API_DEF_ADD_RSP_JSON_WRAPPER(Uint64JsonVO);
	}
	// 3.2 定义新增接口处理
	ENDPOINT(API_M_POST, "/defect", addDefect, BODY_DTO(DefectDTO::Wrapper, dto), API_HANDLER_AUTH_PARAME) {
		// 呼叫执行函数响应结果
		API_HANDLER_RESP_VO(execAddDefect(dto));
	}

private:
	// 3.3 分页查询数据
	DefectPageJsonVO::Wrapper execQueryDefect(const DefectQuery::Wrapper& query, const PayloadDTO& payload);
	// 3.3 新增数据
	Uint64JsonVO::Wrapper execAddDefect(const DefectDTO::Wrapper& dto);
		
};

// 0 取消API控制器使用宏
#include OATPP_CODEGEN_END(ApiController) //<- End Codegen
#endif // _SAMPLE_CONTROLLER_
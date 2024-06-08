#pragma once
/*

 @Author: Croissant
 @Date: 2024/5/18

*/
#ifndef _WORKFIXTURETYPECONTROLLER_H_
#define _WORKFIXTURETYPECONTROLLER_H_

#include "../ApiDeclarativeServicesHelper.h"

#include "../../domain/query/WorkFixture/WorkFixtureTypeListQuery.h"
#include "../../domain/dto/WorkFixture/WorkFixtureTypeListDTO.h"
#include "../../domain/vo/WorkFixture/WorkFixtureTypeListVO.h"

#include "../../domain/query/WorkFixture/WorkFixtureTypeNameListQuery.h"
#include "../../domain/dto/WorkFixture/WorkFixtureTypeNameListDTO.h"
#include "../../domain/vo/WorkFixture/WorkFixtureTypeNameListVO.h"

#include OATPP_CODEGEN_BEGIN(ApiController) //<- Begin Codegen

/**
 * 工装夹具 获取类型列表 控制器
 */
class WorkFixtureTypeController : public oatpp::web::server::api::ApiController // 1 继承控制器
{
	// 2 定义控制器访问入口
	API_ACCESS_DECLARE(WorkFixtureTypeController);
	// 3 定义接口
public:
	// 3.1 定义Type查询接口描述
	ENDPOINT_INFO(queryWorkFixtureType) {
		// 定义接口标题
		API_DEF_ADD_TITLE(ZH_WORDS_GETTER("workfixture.type.query.summaryT"));
		// 定义响应参数格式
		API_DEF_ADD_RSP_JSON_WRAPPER(WorkFixtureTypeListPageJsonVO);
		// 定义分页查询参数描述
		API_DEF_ADD_PAGE_PARAMS();
		// 定义其他查询参数描述
		//唯一标识
		//API_DEF_ADD_QUERY_PARAMS(UInt64, "toolTypeID", ZH_WORDS_GETTER("workfixture.type.fields.id"), 1, true);
		//类型编码
		API_DEF_ADD_QUERY_PARAMS(String, "toolTypeCode", ZH_WORDS_GETTER("workfixture.type.fields.code"),"TT001",true);
		//类型名称
		API_DEF_ADD_QUERY_PARAMS(String, "toolTypeName", ZH_WORDS_GETTER("workfixture.type.fields.name"),"NULL",true);
		//是否编码管理N/Y
		//API_DEF_ADD_QUERY_PARAMS(String, "codeFlag", ZH_WORDS_GETTER("workfixture.type.fields.codeflag"),"Y",false);
		//保养维护类型 REGULAR USAGE
		API_DEF_ADD_QUERY_PARAMS(String, "maintenType", ZH_WORDS_GETTER("workfixture.type.fields.mtype"), "NULL",false );
		//保养周期
		//API_DEF_ADD_QUERY_PARAMS(Int32, "maintenPriod", ZH_WORDS_GETTER("workfixture.type.fields.mpriod"), 0, false);
		//备注
		//API_DEF_ADD_QUERY_PARAMS(String, "remark", ZH_WORDS_GETTER("workfixture.type.fields.remark"), "", false);
		// 定义默认授权参数（可选定义，如果定义了，下面ENDPOINT里面需要加入API_HANDLER_AUTH_PARAME）
		API_DEF_ADD_AUTH();
	}
	// 3.2 定义Type查询接口处理
	ENDPOINT(API_M_GET, "/workfixture/type/query/list", queryWorkFixtureType, QUERIES(QueryParams, queryParams), API_HANDLER_AUTH_PARAME) {
		// 解析查询参数为Query领域模型
		API_HANDLER_QUERY_PARAM(query, WorkFixtureTypeListQuery, queryParams);
		// 呼叫执行函数响应结果
		API_HANDLER_RESP_VO(execType(query));
	}
	
	// 3.1 定义TypeName查询接口描述
	ENDPOINT_INFO(queryWorkFixtureTypeName) {
		// 定义接口标题
		API_DEF_ADD_TITLE(ZH_WORDS_GETTER("workfixture.type.query.summaryTN"));
		// 定义默认授权参数（可选定义，如果定义了，下面ENDPOINT里面需要加入API_HANDLER_AUTH_PARAME）
		API_DEF_ADD_AUTH();
	}
	// 3.2 定义TypeName查询接口处理
	ENDPOINT(API_M_GET, "/workfixture/type/query/name-list", queryWorkFixtureTypeName, QUERIES(QueryParams, queryParams), API_HANDLER_AUTH_PARAME) {
		// 解析查询参数为Query领域模型
		API_HANDLER_QUERY_PARAM(query, WorkFixtureTypeNameListQuery, queryParams);
		// 呼叫执行函数响应结果
		API_HANDLER_RESP_VO(execTypeName(query));
	}

	// 3.3 演示Type分页查询数据
	WorkFixtureTypeListPageJsonVO::Wrapper execType(const WorkFixtureTypeListQuery::Wrapper& query);
	// 3.3 演示TypeName分页查询数据
	WorkFixtureTypeNameListJsonVO::Wrapper execTypeName(const WorkFixtureTypeNameListQuery::Wrapper& query);
};

// 0 取消API控制器使用宏
#include OATPP_CODEGEN_END(ApiController) //<- End Codegen
#endif // _WORKFIXTURETYPECONTROLLER_H_
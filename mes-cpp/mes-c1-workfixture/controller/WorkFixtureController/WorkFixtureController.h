#pragma once
#include "domain/vo/BaseJsonVO.h"
#include "domain/query/WorkFixtureQuery/WorkFixtureQuery.h"
#include "domain/dto/WorkFixtureDTO/WorkFixtureDTO.h"
#include "domain/vo/WorkFixtureVO/WorkFixtureVO.h"

#include OATPP_CODEGEN_BEGIN(ApiController)

/**
 * 工装夹具列表管理控制器
*/
class WorkFixtureController : public oatpp::web::server::api::ApiController
{
	API_ACCESS_DECLARE(WorkFixtureController);
public:
	// 1. 定义列表查询接口描述
	ENDPOINT_INFO(queryWorkFixtureTable) {
		// 定义接口标题
		API_DEF_ADD_TITLE(ZH_WORDS_GETTER("workfixture.query.summary"));
		// 定义默认授权参数（可选定义，如果定义了，下面ENDPOINT里面需要加入API_HANDLER_AUTH_PARAME）
		API_DEF_ADD_AUTH();
		// 定义响应参数格式
		API_DEF_ADD_RSP_JSON_WRAPPER(WorkFixtureJsonVO);
		// 定义分页查询参数描述
		API_DEF_ADD_PAGE_PARAMS();
		// 定义其他查询参数描述
		API_DEF_ADD_QUERY_PARAMS(String, "toolCode", ZH_WORDS_GETTER("workfixture.fields.code"), "", false);
		API_DEF_ADD_QUERY_PARAMS(String, "toolName", ZH_WORDS_GETTER("workfixture.fields.name"), "", false);
		API_DEF_ADD_QUERY_PARAMS(String, "toolType", ZH_WORDS_GETTER("workfixture.fields.type"), "", false);
		API_DEF_ADD_QUERY_PARAMS(String, "brand", ZH_WORDS_GETTER("workfixture.fields.brand"), "", false);
		API_DEF_ADD_QUERY_PARAMS(String, "spec", ZH_WORDS_GETTER("workfixture.fields.spec"), "", false);
		API_DEF_ADD_QUERY_PARAMS(String, "status", ZH_WORDS_GETTER("workfixture.fields.status"), "", false);
	}
	// 定义查询接口处理
	ENDPOINT(API_M_GET, "/workfixture/query", queryWorkFixtureTable, QUERIES(QueryParams, queryParams), API_HANDLER_AUTH_PARAME) {
		// 解析查询参数为Query领域模型
		API_HANDLER_QUERY_PARAM(query, WorkFixtureQuery, queryParams);
		// 呼叫执行函数响应结果
		API_HANDLER_RESP_VO(execQueryWorkFixtureTable(query));
	}
	// 1.1 工装夹具详情查询接口
	ENDPOINT_INFO(queryWorkFixtureTable) {
		// 定义接口标题
		API_DEF_ADD_TITLE(ZH_WORDS_GETTER("workfixture.query.detail"));
		// 定义默认授权参数（可选定义，如果定义了，下面ENDPOINT里面需要加入API_HANDLER_AUTH_PARAME）
		API_DEF_ADD_AUTH();
		// 定义响应参数格式
		API_DEF_ADD_RSP_JSON_WRAPPER(WorkFixtureDetailJsonVO);
		// 定义分页查询参数描述
		API_DEF_ADD_PAGE_PARAMS();
		// 定义其他查询参数描述
		API_DEF_ADD_QUERY_PARAMS(UInt64, "toolId", ZH_WORDS_GETTER("workfixture.fields.id"), 1, true);
	}
	// 定义查询接口处理
	ENDPOINT(API_M_GET, "/workfixture/query/detail", queryWorkFixtureDetail, QUERIES(QueryParams, queryParams), API_HANDLER_AUTH_PARAME) {
		// 解析查询参数为Query领域模型
		API_HANDLER_QUERY_PARAM(query, Uint64JsonVO, queryParams);
		API_HANDLER_RESP_VO(execQueryWorkFixtureDetail(query));
	}

	// 2. 定义新增接口描述
	ENDPOINT_INFO(addWorkFixture) {
		// 定义接口标题
		API_DEF_ADD_TITLE(ZH_WORDS_GETTER("workfixture.add.summary"));
		// 定义默认授权参数（可选定义，如果定义了，下面ENDPOINT里面需要加入API_HANDLER_AUTH_PARAME）
		API_DEF_ADD_AUTH();
		// 定义响应参数格式
		API_DEF_ADD_RSP_JSON_WRAPPER(Uint64JsonVO);
	}
	// 定义新增接口处理
	ENDPOINT(API_M_POST, "/workfixture/add", addWorkFixture, BODY_DTO(WorkFixtureDetailDTO::Wrapper, dto), API_HANDLER_AUTH_PARAME) {
		// 呼叫执行函数响应结果
		API_HANDLER_RESP_VO(execAddWorkFixture(dto));
	}

	// 3 定义修改接口描述
	API_DEF_ENDPOINT_INFO_AUTH(ZH_WORDS_GETTER("workfixture.modify.summary"), modifyWorkFixture, Uint64JsonVO::Wrapper);
	// 定义修改接口处理
	API_HANDLER_ENDPOINT_AUTH(API_M_PUT, "/workfixture/modify", modifyWorkFixture, BODY_DTO(WorkFixtureDetailDTO::Wrapper, dto), execModifyWorkFixture(dto));
private:
	// 查询工装夹具列表功能实现
	// 问题：详细信息的查询返回如何实现（在业务参考系统中点击列表中的蓝体名称和修改选项会显示工装夹具的详细信息）？
	WorkFixtureJsonVO::Wrapper execQueryWorkFixtureTable(const WorkFixtureQuery::Wrapper &query);
	WorkFixtureDetailJsonVO::Wrapper execQueryWorkFixtureDetail(const Uint64JsonVO::Wrapper &queryid);
	// 添加工装夹具功能实现
	Uint64JsonVO::Wrapper execAddWorkFixture(const WorkFixtureDetailDTO::Wrapper &dto);
	// 修改工装夹具信息功能实现
	Uint64JsonVO::Wrapper execModifyWorkFixture(const WorkFixtureDetailDTO::Wrapper &dto);
};

#include OATPP_CODEGEN_END(ApiController)
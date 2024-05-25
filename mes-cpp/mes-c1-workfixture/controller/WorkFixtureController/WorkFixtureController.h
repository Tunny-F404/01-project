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
		API_DEF_ADD_QUERY_PARAMS(Int64, "toolTypeId", ZH_WORDS_GETTER("workfixture.fields.type.id"), 1, false);
		API_DEF_ADD_QUERY_PARAMS(String, "toolTypeCode", ZH_WORDS_GETTER("workfixture.fields.type.code"), "", false);
		API_DEF_ADD_QUERY_PARAMS(String, "toolTypeName", ZH_WORDS_GETTER("workfixture.fields.type.name"), "", false);
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
	// 1.1 定义工装夹具详情获取接口描述和接口处理
	ENDPOINT_INFO(queryWorkFixtureDetail) {
		// 定义标题和返回类型以及授权支持
		API_DEF_ADD_COMMON_AUTH(ZH_WORDS_GETTER("workfixture.query.detail"), WorkFixtureDetailDTO::Wrapper);
		// 定义其他路径参数说明
		API_DEF_ADD_PATH_PARAMS(UInt64, "toolId", ZH_WORDS_GETTER("workfixture.field.id"), 1, true);
	}
	API_HANDLER_ENDPOINT_AUTH(API_M_GET, "/workfixture/query/detail", queryWorkFixtureDetail, BODY_DTO(UInt64, id), execQueryWorkFixtureDetail(id));

	// 2. 定义新增接口描述
	ENDPOINT_INFO(addWorkFixture) {
		// 定义接口标题
		API_DEF_ADD_TITLE(ZH_WORDS_GETTER("workfixture.add.summary"));
		// 定义默认授权参数（可选定义，如果定义了，下面ENDPOINT里面需要加入API_HANDLER_AUTH_PARAME）
		API_DEF_ADD_AUTH();
		// 定义响应参数格式
		API_DEF_ADD_RSP_JSON_WRAPPER(Uint64JsonVO);
		API_DEF_ADD_PATH_PARAMS(String, "toolCode", ZH_WORDS_GETTER("workfixture.fields.code"), "", false);
		API_DEF_ADD_PATH_PARAMS(String, "toolName", ZH_WORDS_GETTER("workfixture.fields.name"), "", false);
		API_DEF_ADD_PATH_PARAMS(Int64, "toolTypeId", ZH_WORDS_GETTER("workfixture.fields.type.id"), 1, false);
		API_DEF_ADD_PATH_PARAMS(String, "toolTypeCode", ZH_WORDS_GETTER("workfixture.fields.type.code"), "", false);
		API_DEF_ADD_PATH_PARAMS(String, "toolTypeName", ZH_WORDS_GETTER("workfixture.fields.type.name"), "", false);
		API_DEF_ADD_PATH_PARAMS(String, "brand", ZH_WORDS_GETTER("workfixture.fields.brand"), "", false);
		API_DEF_ADD_PATH_PARAMS(String, "spec", ZH_WORDS_GETTER("workfixture.fields.spec"), "", false);
		API_DEF_ADD_PATH_PARAMS(String, "status", ZH_WORDS_GETTER("workfixture.fields.status"), "", false);
		API_DEF_ADD_PATH_PARAMS(Int32, "availCount", ZH_WORDS_GETTER("workfixture.fields.aquantity"), 0, false);
		API_DEF_ADD_PATH_PARAMS(String, "maintenType", ZH_WORDS_GETTER("workfixture.fields.mtype"), "", false);
		API_DEF_ADD_PATH_PARAMS(Int32, "nextMaintenPeriod", ZH_WORDS_GETTER("workfixture.fields.mperiod"), 0, false);
		API_DEF_ADD_PATH_PARAMS(String, "nextMaintenDate", ZH_WORDS_GETTER("workfixture.fields.mdate"), "", false);
		API_DEF_ADD_PATH_PARAMS(String, "remark", ZH_WORDS_GETTER("workfixture.fields.remark"), "", false);
	}
	// 定义新增接口处理
	ENDPOINT(API_M_POST, "/workfixture/add", addWorkFixture, BODY_DTO(WorkFixtureDetailDTO::Wrapper, dto), API_HANDLER_AUTH_PARAME) {
		// 呼叫执行函数响应结果
		API_HANDLER_RESP_VO(execAddWorkFixture(dto));
	}

	// 3 定义修改接口描述和处理
	ENDPOINT_INFO(modifyWorkFixture) {
		// 定义标题和返回类型以及授权支持
		API_DEF_ADD_COMMON_AUTH(ZH_WORDS_GETTER("workfixture.modify.summary"), Uint64JsonVO::Wrapper);
		// 定义其他路径参数说明
		API_DEF_ADD_RSP_JSON_WRAPPER(Uint64JsonVO);
		API_DEF_ADD_PATH_PARAMS(String, "toolCode", ZH_WORDS_GETTER("workfixture.fields.code"), "", false);
		API_DEF_ADD_PATH_PARAMS(String, "toolName", ZH_WORDS_GETTER("workfixture.fields.name"), "", false);
		API_DEF_ADD_PATH_PARAMS(Int64, "toolTypeId", ZH_WORDS_GETTER("workfixture.fields.type.id"), 1, false);
		API_DEF_ADD_PATH_PARAMS(String, "toolTypeCode", ZH_WORDS_GETTER("workfixture.fields.type.code"), "", false);
		API_DEF_ADD_PATH_PARAMS(String, "toolTypeName", ZH_WORDS_GETTER("workfixture.fields.type.name"), "", false);
		API_DEF_ADD_PATH_PARAMS(String, "brand", ZH_WORDS_GETTER("workfixture.fields.brand"), "", false);
		API_DEF_ADD_PATH_PARAMS(String, "spec", ZH_WORDS_GETTER("workfixture.fields.spec"), "", false);
		API_DEF_ADD_PATH_PARAMS(String, "status", ZH_WORDS_GETTER("workfixture.fields.status"), "", false);
		API_DEF_ADD_PATH_PARAMS(Int32, "availCount", ZH_WORDS_GETTER("workfixture.fields.aquantity"), 0, false);
		API_DEF_ADD_PATH_PARAMS(String, "maintenType", ZH_WORDS_GETTER("workfixture.fields.mtype"), "", false);
		API_DEF_ADD_PATH_PARAMS(Int32, "nextMaintenPeriod", ZH_WORDS_GETTER("workfixture.fields.mperiod"), 0, false);
		API_DEF_ADD_PATH_PARAMS(String, "nextMaintenDate", ZH_WORDS_GETTER("workfixture.fields.mdate"), "", false);
		API_DEF_ADD_PATH_PARAMS(String, "remark", ZH_WORDS_GETTER("workfixture.fields.remark"), "", false);
	}
	API_HANDLER_ENDPOINT_AUTH(API_M_PUT, "/workfixture/modify", modifyWorkFixture, BODY_DTO(WorkFixtureDetailDTO::Wrapper, dto), execModifyWorkFixture(dto));

	// 4 定义删除接口描述和处理
	ENDPOINT_INFO(removeWorkFixture) {
		// 定义标题和返回类型以及授权支持
		API_DEF_ADD_COMMON_AUTH(ZH_WORDS_GETTER("workfixture.remove.summary"), Uint64JsonVO::Wrapper);
	}
	API_HANDLER_ENDPOINT_AUTH(API_M_DEL, "/workfixture/remove", removeWorkFixture, PATH(List<UInt64>, id), execRemoveWorkFixture(id));

	// 5. 定义工装夹具导出接口描述和处理
	ENDPOINT_INFO(exportWorkFixture) {
		// 定义接口标题
		API_DEF_ADD_TITLE(ZH_WORDS_GETTER("workfixture.export.summary"));
		// 定义默认授权参数（可选定义，如果定义了，下面ENDPOINT里面需要加入API_HANDLER_AUTH_PARAME）
		API_DEF_ADD_AUTH();
		// 定义响应参数格式
		API_DEF_ADD_RSP_JSON_WRAPPER(StringJsonVO);
		// 定义其他查询参数描述
		API_DEF_ADD_PATH_PARAMS(String, "toolCode", ZH_WORDS_GETTER("workfixture.fields.code"), "", false);
		API_DEF_ADD_PATH_PARAMS(String, "toolName", ZH_WORDS_GETTER("workfixture.fields.name"), "", false);
		API_DEF_ADD_PATH_PARAMS(Int64, "toolTypeId", ZH_WORDS_GETTER("workfixture.fields.type.id"), 1, false);
		API_DEF_ADD_PATH_PARAMS(String, "toolTypeCode", ZH_WORDS_GETTER("workfixture.fields.type.code"), "", false);
		API_DEF_ADD_PATH_PARAMS(String, "toolTypeName", ZH_WORDS_GETTER("workfixture.fields.type.name"), "", false);
		API_DEF_ADD_PATH_PARAMS(String, "brand", ZH_WORDS_GETTER("workfixture.fields.brand"), "", false);
		API_DEF_ADD_PATH_PARAMS(String, "spec", ZH_WORDS_GETTER("workfixture.fields.spec"), "", false);
		API_DEF_ADD_PATH_PARAMS(String, "status", ZH_WORDS_GETTER("workfixture.fields.status"), "", false);
	}
	ENDPOINT(API_M_POST, "/workfixture/export", exportWorkFixture, QUERIES(QueryParams, queryParams), API_HANDLER_AUTH_PARAME) {
		// 解析查询参数为Query领域模型
		API_HANDLER_QUERY_PARAM(query, WorkFixtureQuery, queryParams);
		// 呼叫执行函数响应结果
		API_HANDLER_RESP_VO(execExportWorkFixture(query));
	}
private:
	// 查询工装夹具列表功能实现
	WorkFixtureJsonVO::Wrapper execQueryWorkFixtureTable(const WorkFixtureQuery::Wrapper &query);
	WorkFixtureDetailJsonVO::Wrapper execQueryWorkFixtureDetail(const UInt64 id);
	// 添加工装夹具功能实现
	Uint64JsonVO::Wrapper execAddWorkFixture(const WorkFixtureDetailDTO::Wrapper &dto);
	// 修改工装夹具信息功能实现
	Uint64JsonVO::Wrapper execModifyWorkFixture(const WorkFixtureDetailDTO::Wrapper &dto);
	// 删除工装夹具功能实现
	Uint64JsonVO::Wrapper execRemoveWorkFixture(const List<UInt64> &id);
	// 导出工装夹具功能实现
	StringJsonVO::Wrapper execExportWorkFixture(const WorkFixtureQuery::Wrapper &query);
};

#include OATPP_CODEGEN_END(ApiController)
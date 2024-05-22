#pragma once

#ifndef _GETWORKSTATIONLIST_CONTROLLER_H_
#define _GETWORKSTATIONLIST_CONTROLLER_H_

#include "domain/vo/BaseJsonVO.h"
#include "domain/GlobalInclude.h"
#include "domain/query/GetList/GetWorkStationListQuery.h"
#include "domain/dto/GetList/GetWorkStationListDTO.h"
#include "domain/dto/GetList/RemoveWorkStationDTO.h"
#include "domain/vo/GetList/GetWorkStationListVO.h"
#include "domain/vo/GetList/RemoveWorkStationVO.h"

// 0 定义API控制器使用宏
#include OATPP_CODEGEN_BEGIN(ApiController) //<- Begin Codegen

/**
 * 示例控制器，演示基础接口的使用
 */
class GetWorkStationListController : public oatpp::web::server::api::ApiController // 1 继承控制器
{
	// 2 定义控制器访问入口
	API_ACCESS_DECLARE(GetWorkStationListController);
	// 3 定义接口
public:
	// 3.1 定义查询接口描述
	ENDPOINT_INFO(queryWorkStationList) {
		// 定义接口标题
		API_DEF_ADD_TITLE(ZH_WORDS_GETTER("getlist.get.summary"));
		// 定义默认授权参数（可选定义，如果定义了，下面ENDPOINT里面需要加入API_HANDLER_AUTH_PARAME）
		API_DEF_ADD_AUTH();
		// 定义响应参数格式
		API_DEF_ADD_RSP_JSON_WRAPPER(GetWorkStationListPageJsonVO);
		// 定义分页查询参数描述
		API_DEF_ADD_PAGE_PARAMS();
		// 定义其他查询参数描述
		//工作站编码
		API_DEF_ADD_QUERY_PARAMS(String, "workstationCode", ZH_WORDS_GETTER("getlist.fields.workstationCode"), "WS0124", false);
		//工作站名称
		API_DEF_ADD_QUERY_PARAMS(String, "workstationName", ZH_WORDS_GETTER("getlist.fields.workstationName"), "zhusu", false);
		//所在车间名称
		API_DEF_ADD_QUERY_PARAMS(String, "workshopName", ZH_WORDS_GETTER("getlist.fields.workshopName"), "car", false);
		//所属工序(工序名称)
		API_DEF_ADD_QUERY_PARAMS(String, "processName", ZH_WORDS_GETTER("getlist.fields.processName"), "QCC", false);
	}
	// 3.2 定义查询接口处理
	ENDPOINT(API_M_GET, "/ws/query-ws-list", queryWorkStationList, QUERIES(QueryParams, queryParams), API_HANDLER_AUTH_PARAME) {
		// 解析查询参数为Query领域模型
		API_HANDLER_QUERY_PARAM(query, GetWorkStationListQuery, queryParams);
		// 呼叫执行函数响应结果
		API_HANDLER_RESP_VO(execWorkStationList(query));
	}

	// 3.1 定义删除接口描述
	ENDPOINT_INFO(removeWorkStation) {
		// 定义标题和返回类型以及授权支持
		API_DEF_ADD_COMMON_AUTH(ZH_WORDS_GETTER("getlist.delete.summary"), oatpp::List<UInt64>);
		// 定义其他路径参数说明
		API_DEF_ADD_PATH_PARAMS(List<UInt64>, "workstationId", ZH_WORDS_GETTER("getlist.fields.workstationId"), {1}, true);
	}
	// 3.2 定义删除接口处理
	API_HANDLER_ENDPOINT_AUTH(API_M_DEL, "/ws/remove-ws", removeWorkStation, BODY_DTO(oatpp::List<UInt64>, workstationId), execRemoveWorkStation(workstationId));

private:
	// 3.3 分页查询数据
	GetWorkStationListPageJsonVO::Wrapper execWorkStationList(const GetWorkStationListQuery::Wrapper& query);
	// 3.3 演示删除数据
	oatpp::List<UInt64> execRemoveWorkStation(const List<UInt64>& workstationId);
};

// 0 取消API控制器使用宏
#include OATPP_CODEGEN_END(ApiController) //<- End Codegen
#endif // _SAMPLE_CONTROLLER_
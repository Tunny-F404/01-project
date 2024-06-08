#pragma once

#ifndef _EXPORTWORKSTATIONLIST_CONTROLLER_H_
#define _EXPORTWORKSTATIONLIST_CONTROLLER_H_

#include "domain/vo/BaseJsonVO.h"
#include "domain/GlobalInclude.h"
#include "domain/query/WorkStation/ExportWorkStationQuery .h"


// 0 定义API控制器使用宏
#include OATPP_CODEGEN_BEGIN(ApiController) //<- Begin Codegen

/**
 * 示例控制器，演示基础接口的使用
 */
class ExportWorkStationController : public oatpp::web::server::api::ApiController // 1 继承控制器
{
	// 2 定义控制器访问入口
	API_ACCESS_DECLARE(ExportWorkStationController);
	// 3 定义接口
public:
	// 3.1 定义查询接口描述
	ENDPOINT_INFO(exportWorkStation) {
		// 定义接口标题
		API_DEF_ADD_TITLE(ZH_WORDS_GETTER("workstation.export.summary"));
		// 定义默认授权参数（可选定义，如果定义了，下面ENDPOINT里面需要加入API_HANDLER_AUTH_PARAME）
		API_DEF_ADD_AUTH();
		// 定义响应参数格式
		API_DEF_ADD_RSP_JSON_WRAPPER(StringJsonVO);
		//定义分页查询参数描述
		API_DEF_ADD_PAGE_PARAMS();
		// 定义其他查询参数描述
		//工作站编码
		API_DEF_ADD_QUERY_PARAMS(String, "workstationCode", ZH_WORDS_GETTER("workstation.fields.workstationCode"), "WS0124", false);
		//工作站名称
		API_DEF_ADD_QUERY_PARAMS(String, "workstationName", ZH_WORDS_GETTER("workstation.fields.workstationName"), "zhusu", false);
		//所在车间名称
		API_DEF_ADD_QUERY_PARAMS(String, "workshopName", ZH_WORDS_GETTER("workstation.fields.workshopName"), "car", false);
		//所属工序(工序名称)
		API_DEF_ADD_QUERY_PARAMS(String, "processName", ZH_WORDS_GETTER("workstation.fields.processName"), "QCC", false);
	}
	// 3.2 定义查询接口处理
	ENDPOINT(API_M_GET, "/ws/export-ws", exportWorkStation, QUERIES(QueryParams, queryParams), API_HANDLER_AUTH_PARAME) {
		// 解析查询参数为Query领域模型
		API_HANDLER_QUERY_PARAM(query, ExportWorkStationQuery, queryParams);
		// 呼叫执行函数响应结果
		API_HANDLER_RESP_VO(execWorkStation(query));
	}

private:
	// 导出工作站
	StringJsonVO::Wrapper execWorkStation(const ExportWorkStationQuery::Wrapper& query);

};

// 0 取消API控制器使用宏
#include OATPP_CODEGEN_END(ApiController) //<- End Codegen
#endif // _SAMPLE_CONTROLLER_
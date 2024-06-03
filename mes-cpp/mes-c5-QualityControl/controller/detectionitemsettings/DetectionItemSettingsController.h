#pragma once
#ifndef _DETECTIONITEMSETTINGS_CONTROLLER_
#define _DETECTIONITEMSETTINGS_CONTROLLER_

#include "domain/vo/BaseJsonVO.h"
#include "domain/query/detectionitemsettings/DetectionItemSettingsQuery.h"
#include "domain/dto/detectionitemsettings/DetectionItemSettingsDTO.h"
#include "domain/vo/detectionitemsettings/DetectionItemSettingsJsonVO.h"
#include OATPP_CODEGEN_BEGIN(ApiController)

class DetectionItemSettingsController : public oatpp::web::server::api::ApiController
{
	API_ACCESS_DECLARE(DetectionItemSettingsController);
public:
	//分页查询接口
	ENDPOINT_INFO(QueryqcSettings) {
		API_DEF_ADD_TITLE(ZH_WORDS_GETTER("qualitycontrol.detectionitemsettings.controller.query.summary"));
		API_DEF_ADD_AUTH();
		API_DEF_ADD_RSP_JSON_WRAPPER(DetectionItemSettingsPageJsonVO);
		API_DEF_ADD_PAGE_PARAMS();
		API_DEF_ADD_QUERY_PARAMS(String, "code", ZH_WORDS_GETTER("qualitycontrol.detectionitemsettings.controller.query.code"), "", false);
		API_DEF_ADD_QUERY_PARAMS(String, "name", ZH_WORDS_GETTER("qualitycontrol.detectionitemsettings.controller.query.name"), "", false);
		API_DEF_ADD_QUERY_PARAMS(String, "type", ZH_WORDS_GETTER("qualitycontrol.detectionitemsettings.controller.query.type"), "", false);
	}
	ENDPOINT(API_M_GET, "/query-qcsettings", QueryqcSettings, QUERIES(QueryParams, queryParams), API_HANDLER_AUTH_PARAME) {
		API_HANDLER_QUERY_PARAM(qcsettingsQuery, DetectionItemSettingsQuery, queryParams);
		//API_HANDLER_RESP_VO(execQueryqc(qcsettingsQuery,authObject->getPayload()));
		API_HANDLER_RESP_VO(execQueryqc(qcsettingsQuery));
	}

	//添加检测项接口
	ENDPOINT_INFO(addDetectionItemSettings) {
		API_DEF_ADD_TITLE(ZH_WORDS_GETTER("qualitycontrol.detectionitemsettings.controller.add.summary"));
		API_DEF_ADD_AUTH();
		API_DEF_ADD_RSP_JSON_WRAPPER(Uint64JsonVO);
	}
	ENDPOINT(API_M_POST, "/add-qcsettings", addDetectionItemSettings, BODY_DTO(DetectionItemSettingsDTO::Wrapper, dto), API_HANDLER_AUTH_PARAME) {
		// 呼叫执行函数响应结果
		API_HANDLER_RESP_VO(execAddqc(dto));
	}

	//修改检测项接口
	API_DEF_ENDPOINT_INFO_AUTH(ZH_WORDS_GETTER("qualitycontrol.detectionitemsettings.controller.modify.summary"), modifyDetectionItemSettings, Uint64JsonVO::Wrapper);
	API_HANDLER_ENDPOINT_AUTH(API_M_PUT, "/modify-qcsettings", modifyDetectionItemSettings, BODY_DTO(DetectionItemSettingsDTO::Wrapper, dto), execModifyqc(dto));

	ENDPOINT_INFO(removeTheDetection) {
		// 定义标题和返回类型以及授权支持
		API_DEF_ADD_COMMON_AUTH(ZH_WORDS_GETTER("detectionitemsettings.delete.summary"), Uint64JsonVO::Wrapper);
		// 定义其他路径参数说明
		//API_DEF_ADD_PATH_PARAMS(UInt64, "id", ZH_WORDS_GETTER("detectionitemsettings.field.id"), 1, true);
	}
	API_HANDLER_ENDPOINT_AUTH(API_M_DEL, "/detectionitemsettings/del-code", removeTheDetection, BODY_DTO(oatpp::List<UInt64>, id), execRemoveTheDetection(id));

	// 3.1 定义导出接口描述
	API_DEF_ENDPOINT_INFO_AUTH(ZH_WORDS_GETTER("detectionitemsettings.export.summary"), exportDetectionItemSettings, StringJsonVO::Wrapper);
	// 3.2 定义导出接口处理
	API_HANDLER_ENDPOINT_AUTH(API_M_POST, "/detectionitemsettings/export", exportDetectionItemSettings, BODY_DTO(oatpp::List<UInt64>, id), execExportDetectionItemSettings(id));
private:
	//DetectionItemSettingsPageJsonVO::Wrapper execQueryqc(const DetectionItemSettingsQuery::Wrapper& query, const PayloadDTO& payload);
	DetectionItemSettingsPageJsonVO::Wrapper execQueryqc(const DetectionItemSettingsQuery::Wrapper& query);
	Uint64JsonVO::Wrapper execAddqc(const DetectionItemSettingsDTO::Wrapper& dto);
	Uint64JsonVO::Wrapper execModifyqc(const DetectionItemSettingsDTO::Wrapper& dto);
	Uint64JsonVO::Wrapper execRemoveTheDetection(const oatpp::List<UInt64>& id);
	// 执行文件下载处理
	StringJsonVO::Wrapper execExportDetectionItemSettings(const oatpp::List<UInt64>& id);
};

#include OATPP_CODEGEN_END(ApiController)

#endif // !_DETECTIONITEMSETTINGS_CONTROLLER_
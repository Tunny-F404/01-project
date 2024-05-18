#pragma once

#ifndef _MODIFYWORKSTATION_CONTROLLER_H_
#define _MODIFYWORKSTATION_CONTROLLER_H_

#include "domain/vo/BaseJsonVO.h"
#include "domain/GlobalInclude.h"
#include "domain/dto/AmStation/AddWorkStationDTO.h"
#include "domain/vo/AmStation/AddWorkStationVO.h"

// 0 定义API控制器使用宏
#include OATPP_CODEGEN_BEGIN(ApiController) //<- Begin Codegen

/**
 * 示例控制器，演示基础接口的使用
 */
class ModifyWorkStationController : public oatpp::web::server::api::ApiController // 1 继承控制器
{
	// 2 定义控制器访问入口
	API_ACCESS_DECLARE(ModifyWorkStationController);
	// 3 定义接口
public:
	// 3.1 定义修改接口描述
	API_DEF_ENDPOINT_INFO_AUTH(ZH_WORDS_GETTER("amstation.modify.summary"), modifyWorkStation, Uint64JsonVO::Wrapper);
	// 3.2 定义修改接口处理
	API_HANDLER_ENDPOINT_AUTH(API_M_PUT, "/AmStation/modify-workstation", modifyWorkStation, BODY_DTO(AddWorkStationDTO::Wrapper, dto), execModifyWorkStation(dto));

private:
	// 3.3 修改工作站
	Uint64JsonVO::Wrapper execModifyWorkStation(const AddWorkStationDTO::Wrapper& dto);
};

// 0 取消API控制器使用宏
#include OATPP_CODEGEN_END(ApiController) //<- End Codegen
#endif // _SAMPLE_CONTROLLER_
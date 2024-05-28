pragma once
/*
 Copyright Zero One Star. All rights reserved.

 @Author: awei
 @Date: 2022/10/25 0:27:04

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

	  https://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
*/
#ifndef _DEVICE_RESOURCE_CONTROLLER_
#define _DEVICE_RESOURCE_CONTROLLER_

#include "ApiHelper.h"
#include "ServerInfo.h"
#include "../../domain/vo/equipment/EquipmentTypeTreeVO.h"
#include "../../domain/query/equipment/EquipmentQuery.h"
#include "../../domain/vo/deviceResource/DeviceResourcetVO.h"


// 0 定义API控制器使用宏
#include OATPP_CODEGEN_BEGIN(ApiController) //<- Begin Codegen

/**
 * 示例控制器，演示基础接口的使用
 */
	class DeviceResourceController : public oatpp::web::server::api::ApiController // 1 继承控制器
{
	// 2 定义控制器访问入口
	API_ACCESS_DECLARE(DeviceResourceController);
	// 3 定义接口
public:
	//获取设备列表(条件 + 分页)
		// 3.1 定义查询接口描述
	ENDPOINT_INFO(getDeviceResourcetList) {
		// 定义接口标题
		API_DEF_ADD_TITLE(ZH_WORDS_GETTER("deviceResource.getDeviceResourcetList.summary"));
		// 定义默认授权参数（可选定义，如果定义了，下面ENDPOINT里面需要加入API_HANDLER_AUTH_PARAME）
		API_DEF_ADD_AUTH();
		// 定义响应参数格式
		API_DEF_ADD_RSP_JSON_WRAPPER(DeviceResourcePageVO);
		// 定义分页查询参数描述
		API_DEF_ADD_PAGE_PARAMS();
		// 定义其他查询参数描述
		//API_DEF_ADD_QUERY_PARAMS(String, "equimentCode", ZH_WORDS_GETTER("equipmentQuery.equimentCode"), "M0024", false);
		//API_DEF_ADD_QUERY_PARAMS(String, "equimentName", ZH_WORDS_GETTER("equipmentQuery.equimentName"), "测试人员", false);
	}
	// 3.2 定义查询接口处理
	ENDPOINT(API_M_GET, "/deviceResource/getDeviceResourcetList", getDeviceResourcetList, null, API_HANDLER_AUTH_PARAME) {
		// 解析查询参数为Query领域模型
		//API_HANDLER_QUERY_PARAM(equipmentQuery, EquipmentQuery, queryParams);
		// 呼叫执行函数响应结果
		API_HANDLER_RESP_VO(executGetDeviceResourcetList(null, authObject->getPayload()));
	}

private:
	// 3.3 设备资源分页查询数据
	DeviceResourcePageVO::Wrapper executGetDeviceResourcetList( const PayloadDTO& payload);
};

// 0 取消API控制器使用宏
#include OATPP_CODEGEN_END(ApiController) //<- End Codegen
#endif // EquipmentController
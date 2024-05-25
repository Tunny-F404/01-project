#pragma once
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
#ifndef _EQUIPMENTCONTROLLER_
#define _EQUIPMENTCONTROLLER_

#include "ApiHelper.h"
#include "ServerInfo.h"
#include "../../domain/vo/EquipmentTypeTreeVO.h"


// 0 定义API控制器使用宏
#include OATPP_CODEGEN_BEGIN(ApiController) //<- Begin Codegen

/**
 * 示例控制器，演示基础接口的使用
 */
class EquipmentController : public oatpp::web::server::api::ApiController // 1 继承控制器
{
	// 2 定义控制器访问入口
	API_ACCESS_DECLARE(EquipmentController);
	// 3 定义接口
public:
	//查询请求(Path传参)
	// 	// 3.1 定义查询接口描述
	ENDPOINT_INFO(getEquipmentById) {
		auto udef =
			//定义接口标题
			API_DEF_ADD_TITLE(ZH_WORDS_GETTER("equipment.getEquipmentById.summary"));
		//定义接口参数
		API_DEF_ADD_PATH_PARAMS(
			Int64,
			"equipmentId", ZH_WORDS_GETTER("equipment.params.equipmentId.desc"),
			1,
			true);
	}
	// 3.2 定义查询接口处理
	ENDPOINT("GET", "/equipment/{equipmentId}", getEquipmentById,PATH(Int64, equipmentId))
	{
		OATPP_LOGD("测试打印", "equipmentId=%d", equipmentId.getValue(0));
		return createResponse(Status::CODE_200, "OK");
	}

	//查询请求(Query传参)
	// 3.1 定义查询接口描述
	ENDPOINT_INFO(getEquipment) {
		auto udef =
			//定义接口标题
			API_DEF_ADD_TITLE(ZH_WORDS_GETTER("equipment.getEquipment.summary"));
		//定义接口参数
		API_DEF_ADD_QUERY_PARAMS(
			Int32,
			"equipmentId", ZH_WORDS_GETTER("equipment.params.equipmentId.desc"),
			1,
			true);
	}
	ENDPOINT("GET", "/equipment/getEquipment", getEquipment, QUERY(Int32, equipmentId))
	{
		OATPP_LOGD("测试打印", "equipmentId=%d", equipmentId.getValue(0));
		return createResponse(Status::CODE_200, "OK");
	}
	
	// 定义查询设备类型名称列表接口端点描述
	API_DEF_ENDPOINT_INFO_AUTH(ZH_WORDS_GETTER("equipment.getEquipmentTypeTree.summary"), getEquipmentTypeTree, EquipmentTypeTreeVO::Wrapper);
	// 定义查询设备类型名称列表接口端点处理
	API_HANDLER_ENDPOINT_NOPARAM_AUTH(API_M_GET, "/equipment/getEquipmentTypeTree", getEquipmentTypeTree, executeGetEquipmentTypeTree(authObject->getPayload()))

private:
	//StringJsonVO::Wrapper execteGetEquipmentPage(const PageQuery::Wrapper& query)
	//获取设备类型名称树
	EquipmentTypeTreeVO::Wrapper executeGetEquipmentTypeTree(const PayloadDTO& payload);
};

// 0 取消API控制器使用宏
#include OATPP_CODEGEN_END(ApiController) //<- End Codegen
#endif // EquipmentController
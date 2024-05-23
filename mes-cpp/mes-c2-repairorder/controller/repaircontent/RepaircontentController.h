#pragma once
/*
 Copyright Zero One Star. All rights reserved.

 @Author: hejianwei
 @Date: 2024/5/18/21:38

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
#ifndef _REPAIRCONTENT_CONTROLLER_
#define _REPAIRCONTENT_CONTROLLER_

#include "ApiHelper.h"
#include "ServerInfo.h"

#include "domain/vo/BaseJsonVO.h"
#include "domain/query/repaircontent/RepaircontentQuery.h"
#include "domain/dto/repaircontent/RepaircontentDTO.h"
#include "domain/dto/repaircontent/DeleteMultiRepaircontentDTO.h"
#include "domain/vo/repaircontent/RepaircontentVO.h"

// 0 定义API控制器使用宏
#include OATPP_CODEGEN_BEGIN(ApiController) //<- Begin Codegen

/**
 * 维修单内容控制器，演示基础接口的使用
 */
class RepaircontentController : public oatpp::web::server::api::ApiController // 1 继承控制器
{
	// 2 定义控制器访问入口
	API_ACCESS_DECLARE(RepaircontentController);
	// 3 定义接口
public:
	//维修单内容查询 接口描述
	ENDPOINT_INFO(queryRepaircontent) {
		API_DEF_ADD_TITLE(ZH_WORDS_GETTER("repaircontent.get.query_repaircontent"));
		// 定义默认授权参数（可选定义，如果定义了，下面ENDPOINT里面需要加入API_HANDLER_AUTH_PARAME）
		API_DEF_ADD_AUTH();
		// 定义响应参数格式
		API_DEF_ADD_RSP_JSON_WRAPPER(RepaircontentPageJsonVO);
		// 定义分页查询参数描述
		API_DEF_ADD_PAGE_PARAMS();
		// 定义其他查询参数描述
		API_DEF_ADD_QUERY_PARAMS(UInt64, "repair_id", ZH_WORDS_GETTER("repaircontent.get.repair_id"), , false);
		API_DEF_ADD_QUERY_PARAMS(String, "subject_name", ZH_WORDS_GETTER("repaircontent.get.repair_name")," ", false);
	}
	//维修单内容查询 接口处理
	ENDPOINT(API_M_GET, "/repaircontent/query-repaircontent", queryRepaircontent, QUERIES(QueryParams, queryParams), API_HANDLER_AUTH_PARAME) {
		// 解析查询参数为Query领域模型
		API_HANDLER_QUERY_PARAM(repair_id, RepaircontentQuery, queryParams);
		// 呼叫执行函数响应结果
		API_HANDLER_RESP_VO(execQueryRepaircontent(repair_id));
	}


	//// 维修单内容详情 接口描述
	//ENDPOINT_INFO(detailsRepaircontent) {
	//	// 定义接口标题
	//	API_DEF_ADD_TITLE(ZH_WORDS_GETTER("repaircontent.get.summary"));
	//	// 定义默认授权参数（可选定义，如果定义了，下面ENDPOINT里面需要加入API_HANDLER_AUTH_PARAME）
	//	API_DEF_ADD_AUTH();
	//	// 定义响应参数格式
	//	API_DEF_ADD_RSP_JSON_WRAPPER(RepaircontentPageJsonVO);
	//	// 定义分页查询参数描述
	//	API_DEF_ADD_PAGE_PARAMS();
	//	// 定义其他查询参数描述
	//	API_DEF_ADD_QUERY_PARAMS(String, "repairContent", ZH_WORDS_GETTER("repaircontent.get.summary"), "", false);


	//}
	//// 3.2 维修单内容 接口处理
	//ENDPOINT(API_M_GET, "/repaircontent", detailsRepaircontent, QUERIES(QueryParams, queryParams), API_HANDLER_AUTH_PARAME) {
	//	// 解析查询参数为Query领域模型
	//	API_HANDLER_QUERY_PARAM(repairId, RepaircontentDetailsQuery, queryParams);
	//	// 呼叫执行函数响应结果
	//	API_HANDLER_RESP_VO(execDetailsRepaircontent(repairId));
	//}

	// 添加设备维修单行 接口描述
	ENDPOINT_INFO(addRepaircontent) {
		// 定义接口标题
		API_DEF_ADD_TITLE(ZH_WORDS_GETTER("repaircontent.get.add_repaircontent"));
		// 定义默认授权参数（可选定义，如果定义了，下面ENDPOINT里面需要加入API_HANDLER_AUTH_PARAME）
		API_DEF_ADD_AUTH();
		// 定义响应参数格式
		API_DEF_ADD_RSP_JSON_WRAPPER(Uint64JsonVO);
	}
	// 添加维修单 接口处理
	ENDPOINT(API_M_POST, "/repaircontent/add-repaircontent", addRepaircontent, BODY_DTO(RepaircontentDTO::Wrapper, dto), API_HANDLER_AUTH_PARAME) {
		// 呼叫执行函数响应结果
		API_HANDLER_RESP_VO(execAddRepaircontent(dto));
	}

	// 修改维修单 接口描述
	ENDPOINT_INFO(modifyRepaircontent) {
		// 定义接口标题
		API_DEF_ADD_TITLE(ZH_WORDS_GETTER("repaircontent.get.modify_repaircontent"));
		// 定义默认授权参数（可选定义，如果定义了，下面ENDPOINT里面需要加入API_HANDLER_AUTH_PARAME）
		API_DEF_ADD_AUTH();
		// 定义响应参数格式
		API_DEF_ADD_RSP_JSON_WRAPPER(Uint64JsonVO);
	}
	// 修改维修单 接口处理
	ENDPOINT(API_M_PUT, "/repaircontent/modify-repaircontent", modifyRepaircontent, BODY_DTO(RepaircontentDTO::Wrapper, dto), API_HANDLER_AUTH_PARAME) {
		// 呼叫执行函数响应结果
		API_HANDLER_RESP_VO(execModifyRepaircontent(dto));
	}

	// 删除维修单 接口描述
	ENDPOINT_INFO(removeRepaircontent) {
		// 定义接口标题
		// 定义标题和返回类型以及授权支持
		API_DEF_ADD_COMMON_AUTH(ZH_WORDS_GETTER("repaircontent.get.remove_repaircontent"), StringJsonVO::Wrapper);

		// 定义默认授权参数（可选定义，如果定义了，下面ENDPOINT里面需要加入API_HANDLER_AUTH_PARAME）
		API_DEF_ADD_AUTH();
	}
	// 删除维修单 接口处理
	ENDPOINT(API_M_DEL, "/repaircontent/remove-repaircontent", removeRepaircontent, BODY_DTO(DeleteMultiRepaircontentDTO::Wrapper, subject_nameList), API_HANDLER_AUTH_PARAME) {
		// 呼叫执行函数响应结果
		API_HANDLER_RESP_VO(execRemoveRepaircontent(subject_nameList));
	}

	
private:
	//维修单内容查询
	 RepaircontentJsonVO::Wrapper execQueryRepaircontent(const RepaircontentQuery::Wrapper& id);	

	// 3.3 维修单内容详情数据
	RepaircontentJsonVO::Wrapper execDetailsRepaircontent(const RepaircontentQuery::Wrapper& id);	
	// 3.3 添加维修单内容
	Uint64JsonVO::Wrapper execAddRepaircontent(const RepaircontentDTO::Wrapper& dto);
	// 3.3 修改维修单内容
	Uint64JsonVO::Wrapper execModifyRepaircontent(const RepaircontentDTO::Wrapper& dto);
	// 3.3 删除维修单内容
	StringJsonVO::Wrapper execRemoveRepaircontent(const DeleteMultiRepaircontentDTO::Wrapper& subject_nameList);
};

// 0 取消API控制器使用宏
#include OATPP_CODEGEN_END(ApiController) //<- End Codegen
#endif // _REPAIRCONTENT_CONTROLLER_
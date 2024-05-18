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
//#include "domain/dto/sample/SampleDTO.h"
#include "domain/vo/repaircontent/RepaircontentVO.h"

// 0 定义API控制器使用宏
#include OATPP_CODEGEN_BEGIN(ApiController) //<- Begin Codegen

/**
 * 示例控制器，演示基础接口的使用
 */
class RepaircontentController : public oatpp::web::server::api::ApiController // 1 继承控制器
{
	// 2 定义控制器访问入口
	API_ACCESS_DECLARE(RepaircontentController);
	// 3 定义接口
public:
	// 维修单内容详情 接口描述
	ENDPOINT_INFO(queryRepaircontent) {
		// 定义接口标题
		API_DEF_ADD_TITLE(ZH_WORDS_GETTER("repaircontent.get.summary"));
		// 定义默认授权参数（可选定义，如果定义了，下面ENDPOINT里面需要加入API_HANDLER_AUTH_PARAME）
		API_DEF_ADD_AUTH();
		// 定义响应参数格式
		API_DEF_ADD_RSP_JSON_WRAPPER(RepaircontentPageJsonVO);
		// 定义分页查询参数描述
		API_DEF_ADD_PAGE_PARAMS();
		// 定义其他查询参数描述
		API_DEF_ADD_QUERY_PARAMS(String, "repairContent", ZH_WORDS_GETTER("repaircontent.get.summary"), "", false);


	}
	// 3.2 维修单内容 接口处理
	ENDPOINT(API_M_GET, "/repaircontent", queryRepaircontent, QUERIES(QueryParams, queryParams), API_HANDLER_AUTH_PARAME) {
		// 解析查询参数为Query领域模型
		API_HANDLER_QUERY_PARAM(repairId, RepaircontentQuery, queryParams);
		// 呼叫执行函数响应结果
		API_HANDLER_RESP_VO(execQueryRepaircontent(repairId));
	}

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
	ENDPOINT(API_M_POST, "/repaircontent/add-repairorder", addRepaircontent, BODY_DTO(RepaircontentDTO::Wrapper, dto), API_HANDLER_AUTH_PARAME) {
		// 呼叫执行函数响应结果
		API_HANDLER_RESP_VO(execAddRepaircontent(dto));
	}

	// 修改维修单 接口描述
	ENDPOINT_INFO(modifyRepaircontent) {
		// 定义接口标题
		API_DEF_ADD_TITLE(ZH_WORDS_GETTER("repaircontent.get.modify_repairorder"));
		// 定义默认授权参数（可选定义，如果定义了，下面ENDPOINT里面需要加入API_HANDLER_AUTH_PARAME）
		API_DEF_ADD_AUTH();
		// 定义响应参数格式
		API_DEF_ADD_RSP_JSON_WRAPPER(Uint64JsonVO);
	}
	// 修改维修单 接口处理
	ENDPOINT(API_M_PUT, "/repaircontent/modify-repairorder", modifyRepaircontent, BODY_DTO(RepaircontentDTO::Wrapper, dto), API_HANDLER_AUTH_PARAME) {
		// 呼叫执行函数响应结果
		API_HANDLER_RESP_VO(execModifyRepaircontent(dto));
	}

	// 删除维修单 接口描述
	ENDPOINT_INFO(removeRepaircontent) {
		// 定义接口标题
		API_DEF_ADD_TITLE(ZH_WORDS_GETTER("repaircontent.get.remove_repairorder"));
		// 定义默认授权参数（可选定义，如果定义了，下面ENDPOINT里面需要加入API_HANDLER_AUTH_PARAME）
		API_DEF_ADD_AUTH();
		// 定义响应参数格式
		API_DEF_ADD_RSP_JSON_WRAPPER(Uint64JsonVO);
	}
	// 删除维修单 接口处理
	ENDPOINT(API_M_PUT, "/repaircontent/modify-repairorder", removeRepaircontent, BODY_DTO(RepaircontentDTO::Wrapper, dto), API_HANDLER_AUTH_PARAME) {
		// 呼叫执行函数响应结果
		API_HANDLER_RESP_VO(execRemoveRepaircontent(dto));
	}

	
private:
	// 3.3 维修单内容详情数据
	RepaircontentJsonVO::Wrapper execQueryRepaircontent(const RepaircontentQuery::Wrapper& id);	
	// 3.3 添加维修单内容
	Uint64JsonVO::Wrapper execAddRepaircontent(const RepaircontentDTO::Wrapper& dto);
	// 3.3 修改维修单内容
	Uint64JsonVO::Wrapper execModifyRepaircontent(const RepaircontentDTO::Wrapper& dto);
	// 3.3 删除维修单内容
	Uint64JsonVO::Wrapper execRemoveRepaircontent(const RepaircontentDTO::Wrapper& dto);
};

// 0 取消API控制器使用宏
#include OATPP_CODEGEN_END(ApiController) //<- End Codegen
#endif // _REPAIRCONTENT_CONTROLLER_
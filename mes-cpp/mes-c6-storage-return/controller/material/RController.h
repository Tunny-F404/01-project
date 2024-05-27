#pragma once
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
#ifndef _GETRETURNLISTCONTROLLER_H_
#define _GETRETURNLISTCONTROLLER_H_

#include "domain/vo/BaseJsonVO.h"
#include "domain/query/material/GetReturnListQuery.h"
#include "domain/dto/material/GetReturnListDTO.h"
#include "domain/vo/material/GetReturnListVO.h"

#include "domain/dto/material/AddReturnDTO.h"

// 0 定义API控制器使用宏
#include OATPP_CODEGEN_BEGIN(ApiController) //<- Begin Codegen

/**
 * 供应商退货行列表控制器，
 */
class RController : public oatpp::web::server::api::ApiController // 1 继承控制器
{
	// 2 定义控制器访问入口
	API_ACCESS_DECLARE(RController);
	// 3 定义接口
public:
	// 3.1 定义查询接口描述
	ENDPOINT_INFO(returnlist) {
		// 定义接口标题
		API_DEF_ADD_TITLE(ZH_WORDS_GETTER("material.get.summary"));
		// 定义默认授权参数（可选定义，如果定义了，下面ENDPOINT里面需要加入API_HANDLER_AUTH_PARAME）
		API_DEF_ADD_AUTH();
		// 定义响应参数格式
		API_DEF_ADD_RSP_JSON_WRAPPER(GetReturnListPageJsonVO);
		// 定义分页查询参数描述
		API_DEF_ADD_PAGE_PARAMS();
		// 定义其他查询参数描述
		API_DEF_ADD_QUERY_PARAMS(String, "rtcode", ZH_WORDS_GETTER("material.rtcode"), "", false);
		API_DEF_ADD_QUERY_PARAMS(String, "rtname", ZH_WORDS_GETTER("material.rtname"), "", false);
		API_DEF_ADD_QUERY_PARAMS(String, "pocode", ZH_WORDS_GETTER("material.pocode"), "", false);
		API_DEF_ADD_QUERY_PARAMS(String, "vendorname", ZH_WORDS_GETTER("material.vendorname"), "", false);
	}
	// 3.2 定义查询接口处理
	ENDPOINT(API_M_GET, "/get/returnlist", returnlist, QUERIES(QueryParams, queryParams), API_HANDLER_AUTH_PARAME) {
		// 解析查询参数为Query领域模型
		API_HANDLER_QUERY_PARAM(Query, GetReturnListQuery, queryParams);
		// 呼叫执行函数响应结果
		API_HANDLER_RESP_VO(execQueryList(Query));
	}

	// 3.1 定义新增接口描述
	ENDPOINT_INFO(addreturnline) {
		// 定义接口标题
		API_DEF_ADD_TITLE(ZH_WORDS_GETTER("material.add.summary"));
		// 定义默认授权参数（可选定义，如果定义了，下面ENDPOINT里面需要加入API_HANDLER_AUTH_PARAME）
		API_DEF_ADD_AUTH();
		// 定义响应参数格式
		API_DEF_ADD_RSP_JSON_WRAPPER(Uint64JsonVO);
	}
	// 3.2 定义新增接口处理
	ENDPOINT(API_M_POST, "/add/returnline", addreturnline, BODY_DTO(AddReturnDTO::Wrapper, dto), API_HANDLER_AUTH_PARAME) {
		// 呼叫执行函数响应结果
		API_HANDLER_RESP_VO(execAddReturnLine(dto));
	}

	// 3.1 定义修改接口描述
	API_DEF_ENDPOINT_INFO_AUTH(ZH_WORDS_GETTER("material.alter.summary"), modifyReturnline, Uint64JsonVO::Wrapper);
	// 3.2 定义修改接口处理
	API_HANDLER_ENDPOINT_AUTH(API_M_PUT, "/alter/returnline", modifyReturnline, BODY_DTO(ModifyReturnDTO::Wrapper, dto), execModifyReturnline(dto));

	// 3.1 定义删除接口描述
	ENDPOINT_INFO(removeReturnline) {
		// 定义标题和返回类型以及授权支持
		API_DEF_ADD_COMMON_AUTH(ZH_WORDS_GETTER("material.delete.summary"), Uint64JsonVO::Wrapper);
		// 定义其他路径参数说明
		API_DEF_ADD_PATH_PARAMS(UInt64, "lineid", ZH_WORDS_GETTER("material.lineid"), 1, true);
	}
	// 3.2 定义删除接口处理
	API_HANDLER_ENDPOINT_AUTH(API_M_DEL, "/delete/{id}", removeReturnline, PATH(UInt64, lineid), execRemoveReturnline(lineid));
	
private:
	GetReturnListPageJsonVO::Wrapper execQueryList(const GetReturnListQuery::Wrapper& query);
	Uint64JsonVO::Wrapper execAddReturnLine(const AddReturnDTO::Wrapper& dto);
	Uint64JsonVO::Wrapper execModifyReturnline(const ModifyReturnDTO::Wrapper& dto);
	Uint64JsonVO::Wrapper execRemoveReturnline(const UInt64& lineid);
};

// 0 取消API控制器使用宏
#include OATPP_CODEGEN_END(ApiController) //<- End Codegen
#endif // _GETRETURNLISTCONTROLLER_H_
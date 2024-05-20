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
#ifndef _HUMANRESOURCELISTCONTROLLER_
#define _HUMANRESOURCELISTCONTROLLER_

#include "domain/vo/BaseJsonVO.h"
//#include "domain/query/sample/SampleQuery.h"
//#include "domain/dto/sample/SampleDTO.h"
#include "domain/vo/humanresource/HumanresourceListVO.h"

// 0 定义API控制器使用宏
#include OATPP_CODEGEN_BEGIN(ApiController)

/**
 * 人力资源控制器
 */
class HumanResourceListController : public oatpp::web::server::api::ApiController // 1 继承控制器
{
	// 2 定义控制器访问入口
	API_ACCESS_DECLARE(HumanResourceListController);
	// 3 定义接口
public:

	// 3.1 定义新增接口描述
	ENDPOINT_INFO(addHumanResource) {
		// 定义接口标题
		API_DEF_ADD_TITLE(ZH_WORDS_GETTER("post.add.summary"));
		// 定义默认授权参数（可选定义，如果定义了，下面ENDPOINT里面需要加入API_HANDLER_AUTH_PARAME）
		API_DEF_ADD_AUTH();
		// 定义响应参数格式
		API_DEF_ADD_RSP_JSON_WRAPPER(Uint64JsonVO);
	}
	// 3.2 定义新增接口处理
	ENDPOINT(API_M_POST, "/humanresource/add-hunmanresource-list", addHumanResource, BODY_DTO(HumanResourceListDTO::Wrapper, dto), API_HANDLER_AUTH_PARAME) {
		// 呼叫执行函数响应结果
		API_HANDLER_RESP_VO(execAddHumanResourceList(dto));
	}


private:
	// 3.3 演示分页查询数据
	//SamplePageJsonVO::Wrapper execQuerySample(const SampleQuery::Wrapper& query, const PayloadDTO& payload);
	// 3.3 演示新增数据
	Uint64JsonVO::Wrapper execAddHumanResourceList(const HumanResourceListDTO::Wrapper& dto);


};

// 0 取消API控制器使用宏
#include OATPP_CODEGEN_END(ApiController) //<- End Codegen
#endif // _SAMPLE_CONTROLLER_
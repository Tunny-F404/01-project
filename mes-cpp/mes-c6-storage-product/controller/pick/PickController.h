#pragma once

#ifndef _PICK_CONTROLLER_
#define _PICK_CONTROLLER_

#include "domain/vo/BaseJsonVO.h"
#include "domain/query/pick/PickQuery.h"
#include "domain/dto/pick/PickDTO.h"
#include "domain/vo/pick/PickVO.h"

// 0 定义API控制器使用宏
#include OATPP_CODEGEN_BEGIN(ApiController) //<- Begin Codegen

/**
 * 示例控制器，演示基础接口的使用
 */
class PickController : public oatpp::web::server::api::ApiController // 1 继承控制器
{
	// 2 定义控制器访问入口
	API_ACCESS_DECLARE(PickController);
	// 3 定义接口
public:

	// 3.1 定义新增接口描述
	ENDPOINT_INFO(addPick) {
		// 定义接口标题
		API_DEF_ADD_TITLE(ZH_WORDS_GETTER("pick.post.summary"));
		// 定义默认授权参数（可选定义，如果定义了，下面ENDPOINT里面需要加入API_HANDLER_AUTH_PARAME）
		API_DEF_ADD_AUTH();
		// 定义响应参数格式
		API_DEF_ADD_RSP_JSON_WRAPPER(Uint64JsonVO);
	}
	// 3.2 定义新增接口处理
	ENDPOINT(API_M_POST, "/pick", addPick, BODY_DTO(PickDTO::Wrapper, dto), API_HANDLER_AUTH_PARAME) {
		// 呼叫执行函数响应结果
		API_HANDLER_RESP_VO(execAddPick(dto));
	}

	// 3.1 定义修改接口描述
	API_DEF_ENDPOINT_INFO_AUTH(ZH_WORDS_GETTER("pick.put.summary"), modifyPick, Uint64JsonVO::Wrapper);
	// 3.2 定义修改接口处理
	API_HANDLER_ENDPOINT_AUTH(API_M_PUT, "/pick", modifyPick, BODY_DTO(PickDTO::Wrapper, dto), execModifyPick(dto));
private:
	// 3.3 演示新增数据
	Uint64JsonVO::Wrapper execAddPick(const PickDTO::Wrapper& dto);
	// 3.3 演示修改数据
	Uint64JsonVO::Wrapper execModifyPick(const PickDTO::Wrapper& dto);

};

// 0 取消API控制器使用宏
#include OATPP_CODEGEN_END(ApiController) //<- End Codegen
#endif // _PICK_CONTROLLER_
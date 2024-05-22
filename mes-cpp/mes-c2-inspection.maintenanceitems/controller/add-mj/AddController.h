#pragma once
#ifndef _ADD_CONTROLLER_H_
#define _ADD_CONTROLLER_H_

#include "domain/vo/BaseJsonVO.h"
#include "../../domain/vo/add-mj/AddVO.h"


#include OATPP_CODEGEN_BEGIN(ApiController)

/**
 * 项目计划控制器
 */
class AddController : public oatpp::web::server::api::ApiController
{
	// 定义控制器访问入口
	API_ACCESS_DECLARE(AddController);
public:
	
	// 3.1 定义新增接口描述
	ENDPOINT_INFO(addTable) {
		// 定义接口标题
		API_DEF_ADD_TITLE(ZH_WORDS_GETTER("add-mj.add.summary"));
		// 定义默认授权参数（可选定义，如果定义了，下面ENDPOINT里面需要加入API_HANDLER_AUTH_PARAME）
		API_DEF_ADD_AUTH();
		// 定义响应参数格式
		API_DEF_ADD_RSP_JSON_WRAPPER(Uint64JsonVO);
	}
	// 3.2 定义新增接口处理
	ENDPOINT(API_M_POST, "/inspection-maintenanceitems/add-item", addTable, BODY_DTO(AddDTO::Wrapper, dto), API_HANDLER_AUTH_PARAME) {
		// 呼叫执行函数响应结果
		API_HANDLER_RESP_VO(execAddSample(dto));
	}
private: // 定义接口执行函数
	// 3.3 演示新增数据
	Uint64JsonVO::Wrapper execAddSample(const AddDTO::Wrapper& dto);
};

#include OATPP_CODEGEN_END(ApiController)

#endif // !_FILECONTROLLER_H_
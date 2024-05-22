#pragma once
#ifndef _ADDPRODWORKORDER_CONTROLLER_
#define _ADDPRODWORKORDER_CONTROLLER_

#include "domain/vo/BaseJsonVO.h"
#include "../mes-c4-prodmgmt/domain/do/ApprovalStage/ApprovalStageDO.h"
#include "../mes-c4-prodmgmt/domain/dto/ApprovalStage/ApprovalStageDTO.h"
#include "../mes-c4-prodmgmt/domain/vo/ApprovalStage/ApprovalStageVO.h"

// 0 定义API控制器使用宏
#include OATPP_CODEGEN_BEGIN(ApiController) //<- Begin Codegen

/**
 * 新增工单控制器
 */
class ApprovalStage : public oatpp::web::server::api::ApiController {// 1 继承控制器
	// 2 定义控制器访问入口
	API_ACCESS_DECLARE(ApprovalStage);
	// 3 定义接口
public:

	// 3.1 定义新增接口描述
	ENDPOINT_INFO(submitForApproval) {
		// 定义接口标题
		API_DEF_ADD_TITLE(ZH_WORDS_GETTER("Approval.post.submi"));
		// 定义默认授权参数（可选定义，如果定义了，下面ENDPOINT里面需要加入API_HANDLER_AUTH_PARAME）
		API_DEF_ADD_AUTH();
		// 定义响应参数格式
		API_DEF_ADD_RSP_JSON_WRAPPER(Uint64JsonVO);
	}

	// 3.2 定义新增接口处理
	ENDPOINT(API_M_POST, "/ProdWorkorder", submitForApproval, BODY_DTO(submitForApprovalrDTO::Wrapper, dto), API_HANDLER_AUTH_PARAME) {
		// 呼叫执行函数响应结果
		API_HANDLER_RESP_VO(execsubmitForApproval(dto));
	}

	// 3.3 演示新增数据
	Uint64JsonVO::Wrapper execsubmitForApproval(const submitForApprovalDTO::Wrapper& dto);

};
// 0 取消API控制器使用宏
#include OATPP_CODEGEN_END(ApiController) //<- End Codegen
#endif // _ADDPRODWORKORDER_CONTROLLER_
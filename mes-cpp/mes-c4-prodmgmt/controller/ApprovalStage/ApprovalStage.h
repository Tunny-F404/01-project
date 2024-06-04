#pragma once
#ifndef _APPROVALSTAGE_CONTROLLER_
#define _APPROVALSTAGE_CONTROLLER_
#include "domain/vo/BaseJsonVO.h"
#include "../mes-c4-prodmgmt/domain/vo/ApprovalStage/ApprovalStageVO.h"
#include "../mes-c4-prodmgmt/domain/dto/ApprovalStage/ApprovalStageDTO.h"

// 0 定义API控制器使用宏
#include OATPP_CODEGEN_BEGIN(ApiController) //<- Begin Codegen

/**
 * 生产报工
 */
class ApprovalStage : public oatpp::web::server::api::ApiController // 1 继承控制器
{
	// 2 定义控制器访问入口
	API_ACCESS_DECLARE(ApprovalStage);
	// 3 定义接口
public:
	// 3.1 定义修改接口描述
	API_DEF_ENDPOINT_INFO_AUTH(ZH_WORDS_GETTER("Approval.post.name"), modifyApprovalStage, ApprovalStageVO::Wrapper);
	// 3.2 定义修改接口处理
	API_HANDLER_ENDPOINT_AUTH(API_M_PUT, "/sample", modifyApprovalStage, BODY_DTO(ApprovalStageDTO::Wrapper, dto), execModifyApprovalStage(dto));

private:
	// 3.3 演示修改数据
	Uint64JsonVO::Wrapper execModifyApprovalStage(const ApprovalStageDTO::Wrapper& dto);
};

// 0 取消API控制器使用宏
#include OATPP_CODEGEN_END(ApiController) //<- End Codegen
#endif // _PROWORKORDER_CONTROLLER_
#pragma once
#ifndef _APPROVALSTAGEDTO_SERVICE_
#define _APPROVALSTAGEDTO_SERVICE_
#include <list>
#include "domain/vo/ApprovalStage/ApprovalStageVO.h"
#include "domain/dto/ApprovalStage/ApprovalStageDTO.h"

/**
	修改审批状态服务实现
 */
class ApprovalStageService
{
public:
	// 修改数据
	bool updateData(const ApprovalStageDTO::Wrapper& dto);
};

#endif // !_APPROVALSTAGEDTO_SERVICE_



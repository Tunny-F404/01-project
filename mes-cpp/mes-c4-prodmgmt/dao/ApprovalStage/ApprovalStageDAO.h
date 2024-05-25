#pragma once
#ifndef _APPROVALSTAGEDTO_DAO_
#define _APPROVALSTAGEDTO_DAO_
#include "BaseDAO.h"
#include "../../domain/do/ApprovalStage/ApprovalStageDO.h"

/**
 * 示例表数据库操作实现
 */
class ApprovalStageDAO : public BaseDAO
{
public:
	// 修改数据
	int update(const ApprovalStageDO& uObj);
};
#endif // !_APPROVALSTAGEDTO_DAO_


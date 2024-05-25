#pragma once
#ifndef _APPROVALSTAGEDTO_DO_
#define _APPROVALSTAGEDTO_DO_
#include "../DoInclude.h"

/**
 * 获取生产报工列表数据库实体类
 */
class ApprovalStageDO
{
	//记录id/生产工单编号;record_id;bigint
	CC_SYNTHESIZE(uint64_t, record_id, record_id);
	//报工状态;status;varchar
	CC_SYNTHESIZE(string, status, status);
public:
	ApprovalStageDO() {
		record_id = 0;
		status = "";
	}
};


#endif // !_GETPRODUCTIONREPORTLIST_DO_
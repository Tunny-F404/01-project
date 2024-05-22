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
	CC_SYNTHESIZE(int, record_id, record_id);
	//报工类型;feedback_type;varchar
	CC_SYNTHESIZE(string, feedback_type, feedback_type);
public:
	ApprovalStageDO() {
		workorder_id = 0;
		feedback_type = "";
	}
};


#endif // !_GETPRODUCTIONREPORTLIST_DO_
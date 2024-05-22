#pragma once
#ifndef _GETPRODUCTIONREPORTLIST_DO_
#define _GETPRODUCTIONREPORTLIST_DO_
#include "../DoInclude.h"

/**
 * 获取生产报工列表数据库实体类
 */
class GetProductionReportListDO
{
	//报工类型;feedback_type;varchar
	CC_SYNTHESIZE(string, feedback_type, feedback_type);
public:
	GetProductionReportListDO() {
		//0草稿，1待审批，2审批通过，3审批不通过
		feedback_type = "0";
	}
};


#endif // !_GETPRODUCTIONREPORTLIST_DO_
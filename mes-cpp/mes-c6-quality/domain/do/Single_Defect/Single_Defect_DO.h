#pragma once
#ifndef _SINGLE_DO_
#define _SINGLE_DO_
#include "../DoInclude.h"

class SingleDO
{
	CC_SYNTHESIZE(UInt64, index_id, Index_id);
	CC_SYNTHESIZE(String, index_code, Index_code);
	CC_SYNTHESIZE(String, index_name, Index_name);
	CC_SYNTHESIZE(String, index_type, Index_type);
	CC_SYNTHESIZE(String, qc_tool, Qc_tool);
	CC_SYNTHESIZE(String, check_method, Check_method);
	CC_SYNTHESIZE(Float64, stander_val, Stander_val);
	CC_SYNTHESIZE(String, unit_of_measure, Unit_of_measure);
	CC_SYNTHESIZE(Float64, threshold_max, Threshold_max);
	CC_SYNTHESIZE(Float64, threshold_min, Threshold_min);
	CC_SYNTHESIZE(Int64, cr_quantity, Cr_quantity);
	CC_SYNTHESIZE(Int64, maj_quantity, Maj_quantity);
	CC_SYNTHESIZE(Int64, min_quantity, Min_quantity);
	CC_SYNTHESIZE(String, index_remark, Index_remark);

public:
	SingleDO() {
		line_id = 0;
		index_code = "";
		index_name = "";
		index_type = "";
		qc_tool = "";
		check_method = "";
		unit_of_measure = "";
		index_remark = "";
		stander_val = 0;
		threshold_max = 0;
		threshold_min = 0;
		cr_quantity = 0;
		maj_quantity = 0;
		min_quantity = 0;
	}
};


#endif // !_SINGLE_DO_

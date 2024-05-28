#pragma once
#ifndef _SINGLE_DO_
#define _SINGLE_DO_
#include "../DoInclude.h"

class IndexDO
{
	//记录ID
	CC_SYNTHESIZE(int64_t, line_id, Line_id);
	//检验单ID
	CC_SYNTHESIZE(int64_t, iqc_id, iqc_id);
	//检测项ID
	CC_SYNTHESIZE(int64_t, index_id, Index_id);
	//检测项编码
	CC_SYNTHESIZE(string, index_code, Index_code);
	//检测项名称
	CC_SYNTHESIZE(string, index_name, Index_name);
	//检测项类型
	CC_SYNTHESIZE(string, index_type, Index_type);
	//检测工具
	CC_SYNTHESIZE(string, qc_tool, Qc_tool);
	//检测方法
	CC_SYNTHESIZE(string, check_method, Check_method);
	//标准值
	CC_SYNTHESIZE(double, stander_val, Stander_val);
	//单位
	CC_SYNTHESIZE(string, unit_of_measure, Unit_of_measure);
	//误差上限
	CC_SYNTHESIZE(double, threshold_max, Threshold_max);
	//误差下限
	CC_SYNTHESIZE(double, threshold_min, Threshold_min);
	//致命缺陷数量
	CC_SYNTHESIZE(int, cr_quantity, Cr_quantity);
	//严重缺陷数量
	CC_SYNTHESIZE(int, maj_quantity, Maj_quantity);
	//轻微缺陷数量
	CC_SYNTHESIZE(int, min_quantity, Min_quantity);
	//备注
	CC_SYNTHESIZE(String, remark, Remark);
	//预留字段1
	CC_SYNTHESIZE(String, attr1, Attr1);
	//预留字段2
	CC_SYNTHESIZE(String, attr2, Attr2);
	//预留字段3
	CC_SYNTHESIZE(int, attr3, Attr3);
	//预留字段4
	CC_SYNTHESIZE(int, attr4, Attr4);
	//创建者
	CC_SYNTHESIZE(string, create_by, Create_by);
	//创建时间
	CC_SYNTHESIZE(string, create_time, Create_time);
	//更新者
	CC_SYNTHESIZE(string, update_by, Update_by);
	//更新时间
	CC_SYNTHESIZE(string, update_time, Update_time);
public:
	IndexDO() {
		line_id = -1;
		iqc_id = -1;
		index_id = -1;
		index_code = "";
		index_name = "";
		index_type = "";
		qc_tool = "";
		check_method = "";
		stander_va=0;
		unit_of_measure = "";
		index_remark = "";
		stander_val = 0;
		threshold_max = 0;
		threshold_min = 0;
		cr_quantity = 0;
		maj_quantity = 0;
		min_quantity = 0;
		remark = "";
		attr1 = "";
		attr2 = "";
		attr3 = 0;
		attr4 = 0;
		create_by = "";
		create_time = "";
		update_by = "";
		update_time = "";
	}
};


#endif // !_SINGLE_DO_

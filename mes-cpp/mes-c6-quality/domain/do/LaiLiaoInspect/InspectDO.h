#pragma once
#ifndef _INSPECT_DO_
#define _INSPECT_DO_
#include "../DoInclude.h"

/**
 * 来料检验列表数据库实体类
 */
class InspectDO
{
	// 数据库表行id
	CC_SYNTHESIZE(uint64_t, line_id, Line_id);
	// 来料检验单编号
	CC_SYNTHESIZE(string, code, Code);
	// 来料检验单名称
	CC_SYNTHESIZE(string, name, Name);
	//检验模板ID
	CC_SYNTHESIZE(uint64_t, template_id, Template_id);
	//供应商ID
	CC_SYNTHESIZE(uint64_t, vendor_id, Vendor_id);
	//供应商编码
	CC_SYNTHESIZE(string, vendor_code, Vendor_code);
	//供应商名称
	CC_SYNTHESIZE(string, vendor_name, Vendor_name);
	// 供应商简称
	CC_SYNTHESIZE(string, vd_nick, Vd_nick);
	//供应商批次号
	CC_SYNTHESIZE(string, vd_batch, Vd_batch);
	//产品物料编码
	CC_SYNTHESIZE(string, item_code, Item_code);
	//产品物料名称
	CC_SYNTHESIZE(string, item_name, Item_name);
	//接收数量
	CC_SYNTHESIZE(long long, quantity_recived, Quantity_recived);
	//检测数量
	CC_SYNTHESIZE(long long, quantity_check, Quantity_check);
	//不合格数
	CC_SYNTHESIZE(long long, quantity_unqualified, Quantity_unqualified);
	//检测结果
	CC_SYNTHESIZE(string, check_result, Check_result);
	//来料日期
	CC_SYNTHESIZE(string, recive_date, Recive_date);
	//检测日期
	CC_SYNTHESIZE(string, inspect_date, Inspect_date);
	//检测人员
	CC_SYNTHESIZE(string, inspector, Inspector);
	//单据状态
	CC_SYNTHESIZE(string, list_status, List_status);

public:
	InspectDO() {
		line_id = 0;
		code = "";
		name = "";
		template_id = 0;
		vendor_id = 0;
		vendor_code = "";
		vendor_name = "";
		vd_nick = "";
		vd_batch = "";
		item_code = "";
		item_name = "";
		quantity_recived = 0;
		quantity_check = 0;
		quantity_unqualified = 0;
		check_result = "";
		recive_date = "";
		inspect_date = "";
		inspector = "";
		list_status = "";
	}
};


/**
 * 来料检验详情数据库实体类
 */
class Inspect_detailDO :public InspectDO
{
	//单位
	CC_SYNTHESIZE(string, unit_of_measure, Unit_of_measure);
	//致命缺陷率
	CC_SYNTHESIZE(double, maj_rate, Maj_rate);
	//严重缺陷率
	CC_SYNTHESIZE(double, cr_rate, Cr_rate);
	//轻微缺陷率
	CC_SYNTHESIZE(double, min_rate, Min_rate);
	//致命缺陷数量
	CC_SYNTHESIZE(long long, cr_quantity, Cr_quantity);
	//严重缺陷数量
	CC_SYNTHESIZE(long long, maj_quantity, Maj_quantity);
	//轻微缺陷数量
	CC_SYNTHESIZE(long long, min_quantity, Min_quantity);
	//备注
	CC_SYNTHESIZE(string, remark, Remark);

public:
	InspectDO() {
		unit_of_measure = "";
		maj_rate = 0;
		cr_rate = 0;
		min_rate = 0;
		cr_quantity = 0;
		maj_quantity = 0;
		min_quantity = 0;
		remark = "";
	}
};

class Inspect_tableDO :public Inspect_detailDO
{

};

#endif // !_INSPECT_DO_

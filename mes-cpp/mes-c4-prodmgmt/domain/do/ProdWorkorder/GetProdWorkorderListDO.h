#pragma once
#ifndef _GETPRODWORKORDERLIST_DO_
#define _GETPRODWORKORDERLIST_DO_
#include "../DoInclude.h"

/**
 * 获取生产工单列表数据库实体类
 */
class GetProdWorkorderListDO
{
	//工单ID;workorder_id;bigint
	CC_SYNTHESIZE(int, workorder_id, Workorder_id);
	//工单编码;workorder_code;varchar
	CC_SYNTHESIZE(string, workorder_code, Workorder_code);
	//工单名称;workorder_name;varchar
	CC_SYNTHESIZE(string, workorder_name, Workorder_name);
	//来源单据;source_code;varchar
	CC_SYNTHESIZE(string, source_code, Source_code);
	//产品编号;product_code;varchar
	CC_SYNTHESIZE(string, product_code, Product_code);
	//产品名称;product_name;varchar
	CC_SYNTHESIZE(string, product_name, Product_name);
	//客户编码;client_code;varchar
	CC_SYNTHESIZE(string, client_code, Client_code);
	//客户名称;client_name;varchar
	CC_SYNTHESIZE(string, client_name, Client_name);
	//工单类型;workorder_type;varchar
	CC_SYNTHESIZE(string, workorder_type, Workorder_type);
	//需求日期;request_date;datetime
	CC_SYNTHESIZE(string, request_date, Request_date);

public:
	GetProdWorkorderListDO() {
		workorder_id = 0;
		workorder_code = "";
		workorder_name = "";
		source_code = "";
		product_code = "";
		product_name = "";
		client_code = "";
		client_name = "";
		workorder_type = "";
		request_date = "";	
	}
};
 

#endif // !_GETPRODWORKORDERLIST_DO_
#pragma once

#ifndef _PRODUCT_DO_
#define _PRODUCT_DO_
#include "../DoInclude.h"
/**
 * 生产领料数据库实体类
 */
class ProductTableDO {
	//领料单id
	CC_SYNTHESIZE(uint64_t, pid, Pid);
	//领料单编号
	CC_SYNTHESIZE(string, pnum, Pnum);
	//领料单名称
	CC_SYNTHESIZE(string, pname, Pname);
	//生产工单
	CC_SYNTHESIZE(string, plist, Plist);
	//客户编号
	CC_SYNTHESIZE(string, pcnum, Pcnum);
	//客户名称
	CC_SYNTHESIZE(string, pcname, Pcname);
	//领料日期
	CC_SYNTHESIZE(string, pdate, Pdate);
	//单据状态
	CC_SYNTHESIZE(string, pstatus, Pstatus);
public:
	ProductTableDO() {
		pid = 200;
		pnum = "ISSUE20221115004";
		pname = "";
		plist = "MO202211030003";
		pcnum = "C00197";
		pcname = "";
		pdate = "2022-11-15 00:00:00";
		pstatus = "FINISHED";
	}
};
/**
 * 生产领料详情数据库实体类
 */
class ProductDetailDO :public ProductTableDO{
	//领料仓库
	CC_SYNTHESIZE(string, prname, Prname);
	//备注
	CC_SYNTHESIZE(string, premark, Premark);
public:
	ProductDetailDO() {
		prname = "";
		premark = "";
	}
};
#endif 
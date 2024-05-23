#pragma once

#ifndef _INCOMING_DO_
#define _INCOMING_DO_
#include "../DoInclude.h"

/**
 * 示例数据库实体类
 */
class IncomingDO
{
	// 来料检验单编号
	CC_SYNTHESIZE(string, incomingCode, IncomingCode);
	// 供应商编码
	CC_SYNTHESIZE(string, vendorCode, VendorCode);
	// 供应商名称
	CC_SYNTHESIZE(string, vendorName, VendorName);
	// 供应商批次号
	CC_SYNTHESIZE(string, vendorBatch, VendorBatch);
public:
	IncomingDO() {
		incomingCode = "123456";
		vendorCode = "1234567";
		vendorCode = "大西布";
		vendorBatch = "12345678";
	}
};

#endif // !_INCOMING_DO_

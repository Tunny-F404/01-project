#pragma once
/*
 Copyright Zero One Star. All rights reserved.

 @Author: awei
 @Date: 2022/10/25 11:52:32

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

	  https://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
*/
#ifndef _RETURN_DO_
#define _RETURN_DO_
#include "../DoInclude.h"

/**
 * 示例数据库实体类
 */
class ReturnDO
{
	// 退货单编号
	CC_SYNTHESIZE(uint64_t, returnId, returnid);
	// 退货单名称
	CC_SYNTHESIZE(string, returnName, returnnmame);
	// 采购单编号
	CC_SYNTHESIZE(uint64_t, purchaseId, purchaseId);
	// 供应商编码
	CC_SYNTHESIZE(uint64_t, vendorCode, vendorcode);
	// 供应商名称
	CC_SYNTHESIZE(string, vendorName, vendorname);

public:
	ReturnDO() {
		returnId = 0;
		returnName = "returnName";
		purchaseId = 1;
		vendorCode = 2;
		vendorName = "vendorName"
	}
};

#endif // !_RETURN_DO_

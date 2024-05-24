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
#ifndef _ProRouteProductBom_DO_
#define _ProRouteProductBom_DO_
#include "../DoInclude.h"

/**
 * 示例数据库实体类
 */
class ProRouteProductBomDO
{
	// 记录ID
	CC_SYNTHESIZE(uint64_t, record_id, Record_id);
	// 工艺路线ID
	CC_SYNTHESIZE(uint64_t, route_id, Route_id);
	// 工序ID
	CC_SYNTHESIZE(uint64_t, process_id, Process_id);
	// 产品物料ID
	CC_SYNTHESIZE(uint64_t, product_id, Product_id);
	// 产品物料ID
	CC_SYNTHESIZE(uint64_t, item_id, Item_id);
	// 产品物料编码
	CC_SYNTHESIZE(string, item_code, Item_code);
	// 产品物料名称
	CC_SYNTHESIZE(string, item_name, Item_name);
	// 规格型号
	CC_SYNTHESIZE(string, specification, Specification);
	// 单位
	CC_SYNTHESIZE(string, unit_of_measure, Unit_of_measure);
	// 用料比例
	CC_SYNTHESIZE(double, quantity, Quantity);
	// 备注
	CC_SYNTHESIZE(string, remark, Remark);
	// 预留字段1
	CC_SYNTHESIZE(string, attr1, Attr1);
	// 预留字段2
	CC_SYNTHESIZE(string, attr2, Attr2);
	// 预留字段3
	CC_SYNTHESIZE(int, attr3, Attr3);
	// 预留字段4
	CC_SYNTHESIZE(int, attr4, Attr4);
	// 创建者
	CC_SYNTHESIZE(string, create_by, Create_by);
	// 创建时间
	CC_SYNTHESIZE(string, create_time, Create_time);
	// 更新者
	CC_SYNTHESIZE(string, update_by, Update_by);
	// 更新时间
	CC_SYNTHESIZE(string, update_time, Update_time);
public:
	ProRouteProductBomDO() {
		record_id = 0;
		route_id = 0;
		process_id = 0;
		product_id = 0;
		item_id = 0;
		item_code = "";
		item_name = "";
		specification = "";
		unit_of_measure = "";
		quantity = 0.0;
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

#endif // !_ProRouteProductBom_DO_
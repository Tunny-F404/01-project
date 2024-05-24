#pragma once
/*
 Copyright Zero One Star. All rights reserved.

 @Author: awei
 @Date: 2023/02/17 16:25:30

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
#ifndef _WAREHOUSEMENUDO_H_
#define _WAREHOUSEMENUDO_H_

#include "../DoInclude.h"
/**
 * 测试菜单数据库实体
 */
class AreaMenuDO
{
	// 唯一编号
	CC_SYNTHESIZE(uint64_t, warehouse_id, Warehouse_id);
	// 仓库编码
	CC_SYNTHESIZE(string, warehouse_code, Warehouse_code);
	//仓库名称
	/ CC_SYNTHESIZE(string, warehouse_name, Warehouse_name);
	// 所在库区id
	CC_SYNTHESIZE(string, location_id, Location_id);
	//// 面积
	//CC_SYNTHESIZE(double_t,area, Area);
	//// 最大载重量
	//CC_SYNTHESIZE(double_t, max_loa, Max_loa);

public:
	AreaMenuDO() {}
	AreaMenuDO(uint64_t area_id, string area_code, string area_name, string location_id)
	{
		this->area_id = area_id;
		this->area_code = area_code;
		this->area_name = area_name;
		this->location_id = location_id;
	}
};

#endif // !_SAMPLEMENUDO_H_
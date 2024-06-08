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
#ifndef _DEVICE_RESOURCE_DO_
#define _DEVICE_RESOURCE_DO_
#include "../DoInclude.h"

/**
 * 示例数据库实体类
 */
class DeviceResourceDO
{
	//设备资源id
	CC_SYNTHESIZE(int, deviceResourceId, DeviceResourceId);
	// 设备编码
	CC_SYNTHESIZE(string, equipmentCode, EquipmentCode);
	// 设备名称
	CC_SYNTHESIZE(string, equipmentName, EquipmentName);
	//数量
	CC_SYNTHESIZE(int, count, Count);
public:
	DeviceResourceDO() {
		equipmentCode = "";
		equipmentName = "";
		count = 0;
	}
};

#endif // !_DEVICE_RESOURCE_DO_

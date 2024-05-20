#pragma once
/*
 Copyright Zero One Star. All rights reserved.

 @Author: awei
 @Date: 2022/10/25 14:21:55

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
#ifndef _DEVICEMANAGE_MAPPER_
#define _DEVICEMANAGE_MAPPER_

#include "Mapper.h"
#include "../../domain/do/device-manage/DeviceManageDO.h"

/**
 * ʾ�����ֶ�ƥ��ӳ��
 */
class DeviceManageMapper : public Mapper<DeviceManageDO>
{
public:
	DeviceManageDO mapper(ResultSet* resultSet) const override
	{
		DeviceManageDO data;
		data.setSubjectId(resultSet->getUInt64(1));
		data.setSubjectCode(resultSet->getString(2));
		data.setSubjectName(resultSet->getString(3));
		data.setSubjectType(resultSet->getString(4));
		data.setSubjectContent(resultSet->getString(5));
		data.setSubjectStandard(resultSet->getString(6));
		data.setEnableFlag(resultSet->getString(7));


		return data;
	}
};

class DeviceManageDelMapper : public Mapper<DeviceManageDelDO>
{
public:
	DeviceManageDelDO mapper(ResultSet* resultSet) const override
	{
		DeviceManageDelDO data;
		data.setSubjectDelId(resultSet->getString(1));

		return data;
	}
};

#endif // !_DEVICEMANAGE_MAPPER_
#pragma once
/*
 Copyright Zero One Star. All rights reserved.

 @Author: hejianwei
 @Date: 2024/05/24 10:56:55

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
#ifndef _REPAIRCONTENT_MAPPER_
#define _REPAIRCONTENT_MAPPER_

#include "Mapper.h"
#include "../../domain/do/dv_repair_line/RepaircontentDO.h"

/**
 * Ê¾Àý±í×Ö¶ÎÆ¥ÅäÓ³Éä
 */
class RepaircontentMapper : public Mapper<dv_repair_lineDO>
{
public:
	dv_repair_lineDO mapper(ResultSet* resultSet) const override
	{
		dv_repair_lineDO data;
		data.setsubject_Name(resultSet->getString(1));
		data.setMalfunction(resultSet->getString(2));
		data.setMalfunction_url(resultSet->getString(3));
		data.setrepair_Des(resultSet->getString(4));
		data.setsubject_Code(resultSet->getString(5));
		data.setsubject_Type(resultSet->getString(6));
		data.setsubject_Content(resultSet->getString(7));
		data.setCreate_by(resultSet->getString(8));
		data.setCreate_time(resultSet->getString(9));
		data.setUpdate_by(resultSet->getString(10));
		data.setUpdate_time(resultSet->getString(11));

		return data;
	}
};

#endif // !_REPAIRCONTENT_MAPPER_
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
#ifndef _PWORK_MAPPER_
#define _PWORK_MAPPER_

#include "Mapper.h"
#include "../../domain/do/ProduceWork/PworkDo.h"

/**
 * Ê¾Àý±í×Ö¶ÎÆ¥ÅäÓ³Éä
 */
class ProduceWorkMapper : public Mapper<PworkDo>
{
public:
	PworkDo mapper(ResultSet* resultSet) const override
	{
		PworkDo data;
		data.setRecord_id(resultSet->getUInt64(1));
		data.setFeedback_type(resultSet->getString(2));
		data.setWorkstation_name(resultSet->getString(3));
		data.setWorkorder_code(resultSet->getString(5));
		data.setItem_code(resultSet->getString(6));

		data.setItem_name(resultSet->getString(7));
		data.setSpecification(resultSet->getString(8));
		data.setQuantity_feedback(resultSet->getString(9));
		data.setUser_name(resultSet->getString(10));
		data.setFeedback_time(resultSet->getString(11));
		data.setRecord_nick(resultSet->getString(12));
		data.setStatus(resultSet->getString(13));
		return data;
	}
};

#endif // !_SAMPLE_MAPPER_
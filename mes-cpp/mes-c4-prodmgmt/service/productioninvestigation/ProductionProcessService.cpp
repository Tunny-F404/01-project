/*
 Copyright Zero One Star. All rights reserved.

 @Author: amie
 @Date: 2022/10/25 11:13:11

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
#include "stdafx.h"
#include "ProductionProcessService.h"
#include "../../dao/productioninvestigation/ProductionProcessDAO.h"
ProductionProcessDTO::Wrapper ProductionProcessService::listAll(const ProductionProcessQuery::Wrapper& query)
{
	// 构建返回对象
	auto res = ProductionProcessDTO::createShared();
	// 查询数据总条数
	ProductionProcessDAO dao;
	uint64_t count = dao.count(query);
	if (count <= 0)
	{
		return res;
	}
	list<ProProcessDO> result = dao.query_by_workordercode(query);
	// 将DO转换成DTO
	for (ProProcessDO sub : result)
	{
		auto dto = ProductionProcessDTO::createShared();
		dto->processName = sub.getprocessName();
		res->addData(dto);
	}
	return res;
}
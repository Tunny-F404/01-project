/*
 Copyright Zero One Star. All rights reserved.

 @Author: hejianwei
 @Date: 2024/05/24 11:13:11

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
#include "RepaircontentService.h"
#include "../../dao/dv_repair_line/RepaircontentDAO.h"
#include "../../domain/do/dv_repair_line/RepaircontentDO.h"

//RepaircontentPageDTO::Wrapper RepaircontentService::listAll(const RepaircontentQuery::Wrapper& query)
//{
//	// 构建返回对象
//	auto pages = RepaircontentPageDTO::createShared();
//	pages->pageIndex = query->pageIndex;
//	pages->pageSize = query->pageSize;
//
//	// 查询数据总条数
//	RepaircontentDAO dao;
//	uint64_t count = dao.count(query);
//	if (count <= 0)
//	{
//		return pages;
//	}
//
//	// 分页查询数据
//	pages->total = count;
//	pages->calcPages();
//	list<RepaircontentDO> result = dao.selectWithPage(query);
//	// 将DO转换成DTO
//	for (RepaircontentDO sub : result)
//	{
//		auto dto = RepaircontentDTO::createShared();
//		// 		dto->id = sub.getId();
//		// 		dto->name = sub.getName();
//		// 		dto->sex = sub.getSex();
//		// 		dto->age = sub.getAge();
//		ZO_STAR_DOMAIN_DO_TO_DTO(dto, sub, id, Id, name, Name, sex, Sex, age, Age)
//			pages->addData(dto);
//
//	}
//	return pages;
//}

//uint64_t SampleService::saveData(const SampleDTO::Wrapper& dto)
//{
//	// 组装DO数据
//	SampleDO data;
//	// 	data.setName(dto->name.getValue(""));
//	// 	data.setSex(dto->sex.getValue(""));
//	// 	data.setAge(dto->age.getValue(1));
//	ZO_STAR_DOMAIN_DTO_TO_DO(data, dto, Name, name, Sex, sex, Age, age)
//		// 执行数据添加
//		SampleDAO dao;
//	return dao.insert(data);
//}

bool RepaircontentService::updateData(const RepaircontentDTO::Wrapper& dto)
{
	// 组装DO数据
	RepaircontentDO data;
	// 	data.setId(dto->id.getValue(0));
	// 	data.setName(dto->name.getValue(""));
	// 	data.setSex(dto->sex.getValue(""));
	// 	data.setAge(dto->age.getValue(1));
	ZO_STAR_DOMAIN_DTO_TO_DO(data, dto, repair_Id, repair_id, subject_Id, subject_id, subject_Name, subject_name,
		Malfunction, malfunction, Malfunction_url, malfunction_url, repair_Des, repair_des);
		// 执行数据修改
		RepaircontentDAO dao;
	return dao.update(data) == 1;
}

//bool RepaircontentService::removeData(uint64_t id)
//{
//	RepaircontentDAO dao;
//	return dao.deleteById(id) == 1;
//}

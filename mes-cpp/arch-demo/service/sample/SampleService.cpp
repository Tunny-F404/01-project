/*
 Copyright Zero One Star. All rights reserved.

 @Author: awei
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
#include "SampleService.h"
#include "../../dao/sample/SampleDAO.h"
//根据给定的query返回查询对应的结果,类型为分页传输对象DTO
SamplePageDTO::Wrapper SampleService::listAll(const SampleQuery::Wrapper& query)
{
	// 构建返回对象
	auto pages = SamplePageDTO::createShared();
	pages->pageIndex = query->pageIndex;//提取query里包含的查询哪一页、每页的大小
	pages->pageSize = query->pageSize;

	// 查询sample表里符合query记录的总条数
	SampleDAO dao;
	uint64_t count = dao.count(query);
	if (count <= 0)//表里没有符合query的数据
	{
		return pages;
	}

	// 找到指定页的查询数据
	pages->total = count;//记录符合query的数据个数
	pages->calcPages();//根据每页大小pagesize计算一共有多少页
	list<SampleDO> result = dao.selectWithPage(query);
	// 将DO转换成DTO
	for (SampleDO sub : result)
	{
		auto dto = SampleDTO::createShared();
// 		dto->id = sub.getId();
// 		dto->name = sub.getName();
// 		dto->sex = sub.getSex();
// 		dto->age = sub.getAge();
		ZO_STAR_DOMAIN_DO_TO_DTO(dto, sub, id, Id, name, Name, sex, Sex, age, Age)//将DO类型的sub数据传到dto上:dto.id=sub.getId(),dto.name=sub.getName,dto.sex=sub.getSex...
		pages->addData(dto);
		
	}
	return pages;
}

uint64_t SampleService::saveData(const SampleDTO::Wrapper& dto)//注意dto还包含id但是并没有用到！
{
	// 组装DO数据
	SampleDO data;
// 	data.setName(dto->name.getValue(""));
// 	data.setSex(dto->sex.getValue(""));
// 	data.setAge(dto->age.getValue(1));
	ZO_STAR_DOMAIN_DTO_TO_DO(data, dto, Name, name, Sex, sex, Age, age)//data.setName(dto.name)...
	// 执行数据添加
	SampleDAO dao;
	return dao.insert(data);
}

bool SampleService::updateData(const SampleDTO::Wrapper& dto)
{
	// 组装DO数据
	SampleDO data;
// 	data.setId(dto->id.getValue(0));
// 	data.setName(dto->name.getValue(""));
// 	data.setSex(dto->sex.getValue(""));
// 	data.setAge(dto->age.getValue(1));
	ZO_STAR_DOMAIN_DTO_TO_DO(data, dto, Name, name, Sex, sex, Age, age, Id, id)
	// 执行数据修改
	SampleDAO dao;
	return dao.update(data) == 1;
}

bool SampleService::removeData(uint64_t id)
{
	SampleDAO dao;
	return dao.deleteById(id) == 1;
}

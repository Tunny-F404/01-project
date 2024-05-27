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
#include "ProcessInspectionService.h"
#include "../../domain/dto/processinspection/ProcessinSpectionDTO.h"
#include "../../dao/processinspection/ProcessInspectionDAO.h"

bool ProcessInspectionService::updateData(const ProcessinSpectionDTO::Wrapper& dto)
{
	//// 组装DO数据
	//SampleDO data;
	//// 	data.setId(dto->id.getValue(0));
	//// 	data.setName(dto->name.getValue(""));
	//// 	data.setSex(dto->sex.getValue(""));
	//// 	data.setAge(dto->age.getValue(1));
	//ZO_STAR_DOMAIN_DTO_TO_DO(data, dto, Name, name, Sex, sex, Age, age, Id, id)
	//// 执行数据修改
	//SampleDAO dao;
	//return dao.update(data) == 1;
	return true;
}

ProcessinSpectionQueryPageDTO::Wrapper ProcessInspectionService::listAll(const ProcessinSpectionQuery::Wrapper& query)
{
	ProcessInspectionDAO dao;

	auto result = ProcessinSpectionQueryPageDTO::createShared();
	//设置分页参数
	result->pageIndex = query->pageIndex;
	result->pageSize = query->pageSize;
	//查看数据是否存在
	auto count = dao.count(query);
	//不存在返回空
	if (count < 1)
		return result;
	//计算所有数据要分多少页
	result->total = count;
	result->calcPages();
	//查询
	auto dos = dao.select(query);
	//把list<do>装到QueryPageDTO中
	for (auto x : dos) {
		auto dto = ProcessinSpectionQueryDTO::createShared();
		ZO_STAR_DOMAIN_DO_TO_DTO(dto, x, id, Id, ipqc_code, Ipqc_Code, ipqc_type, Ipqc_Type, workorder_code, Workorder_Code, item_code, Item_Code, item_name, Item_Name, specification, Specification, unit_of_measure, Unit_Of_Measure, quantity_check, Quantity_Check, check_result, Check_Result, inspect_date, Inspect_Date, inspector, Inspector, status, Status_Order);
		result->addData(dto);
	}
	return result;
}

bool ProcessInspectionService::remove(uint64_t id)
{
	ProcessInspectionDAO dao;

	return dao.deleteById(id);
}

list<ProcessinSpectionDO> ProcessInspectionService::listAllExort(const ProcessinSpectionQuery::Wrapper& query)
{
	ProcessInspectionDAO dao;
	//查看数据是否存在
	auto count = dao.count(query);
	//不存在返回空
	if (count < 1)
		return {};
	//查询所有数据
	auto dos = dao.select(query);
	return dos;
}

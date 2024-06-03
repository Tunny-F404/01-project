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
	// 组装DO数据
	ProcessinSpectionDO data;
	/* 	data.setId(dto->id.getValue(0));
	// 	data.setName(dto->name.getValue(""));
	// 	data.setSex(dto->sex.getValue(""));
	// 	data.setAge(dto->age.getValue(1));
	data.setId(dto->id);
	data.setIpqc_Code(dto->ipqc_code);
	data.setIpqc_Name(dto->ipqc_name);
	data.setIpqc_Type(dto->ipqc_type);
	data.setWorkorder_Code(dto->workorder_code);
	data.setWorkorder_Name(dto->workorder_name);
	data.setWorkstation_Code(dto->workstation_code);
	data.setWorkstation_Name(dto->workstation_name);
	data.setQuantity_Check(dto->quantity_check);
	data.setItem_Code(dto->item_code);
	data.setItem_Name(dto->item_name);
	data.setUnit_Of_Measure(dto->unit_of_measure);
	data.setSpecification(dto->specification);*/
	ZO_STAR_DOMAIN_DTO_TO_DO(
		data, dto,
		Id, id,
		Ipqc_Code, ipqc_code,
		Ipqc_Name, ipqc_name,
		Ipqc_Type, ipqc_type,
		Workorder_Code, workorder_code,
		Workorder_Name, workorder_name,
		Workstation_Code, workstation_code,
		Workstation_Name, workstation_name,
		Quantity_Check, quantity_check,
		Item_Code, item_code,
		Item_Name, item_name,
		Unit_Of_Measure, unit_of_measure,
		Specification, specification
	);
		/*data.setProcess_Code(dto->process_code);
		data.setProcess_Name(dto->process_name);
		data.setTask_Code(dto->task_code);
		data.setTask_Name(dto->task_name);*/
		ZO_STAR_DOMAIN_DTO_TO_DO(
			data, dto,
			Process_Code, process_code,
			Process_Name, process_name,
			Task_Code, task_code,
			Task_Name, task_name,
			Quantity_Unqualified, quantity_unqualified,
			Quantity_Qualified, quantity_qualified,
			Cr_Quantity, cr_quantity,
			Maj_Quantity, maj_quantity,
			Min_Quantity, min_quantity,
			Inspect_Date, inspect_date,
			Check_Result, check_result,
			Inspector, inspector,
			Remark, remark
			//Status_Order, status
		);
		data.setStatus_Order(dto->status.getValue(""));
		// 执行数据修改
		ProcessInspectionDAO dao;
	return dao.update(data) == 1;
	//return true;
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
	auto dos = dao.select(query,0);
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
	auto dos = dao.select(query,1);
	return dos;
}

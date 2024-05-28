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
#include "ProduceWorkService.h"
#include "../../dao/ProduceWork/ProduceWorkDAO.h"

PworkPageDTO::Wrapper ProduceWorkService::listAll(const PworkQery::Wrapper& query)
{
	// 构建返回对象
	auto pages = PworkPageDTO::createShared();
	pages->pageIndex = query->pageIndex;
	pages->pageSize = query->pageSize;

	// 查询数据总条数
	ProduceWorkDAO dao;
	uint64_t count = dao.count(query);
	if (count <= 0)
	{
		return pages;
	}

	// 分页查询数据
	pages->total = count;
	pages->calcPages();
	list<PworkDo> result = dao.selectWithPage(query);
	// 将DO转换成DTO
	for (PworkDo sub : result)
	{
		auto dto = PworkTableDTO::createShared();
		 		dto->record_id = sub.getRecord_id();
				dto->feedback_type = sub.getFeedback_type();
				dto->workstation_name = sub.getWorkstation_name();
				dto->workorder_code = sub.getWorkorder_code();
				dto->item_code = sub.getItem_code();

				dto->item_name = sub.getItem_name();
				dto->specification = sub.getSpecification();
				dto->quantity_feedback = sub.getQuantity_feedback();
				dto->user_name = sub.getUser_name();
				dto->feedback_time = sub.getFeedback_time();

				dto->record_nick = sub.getRecord_nick();
				dto->status = sub.getStatus();

		ZO_STAR_DOMAIN_DO_TO_DTO(dto, sub, record_id, Record_id, feedback_type, Feedback_type,\
			workstation_name, Workstation_name, workorder_code, Workorder_code,item_code, Item_code,\
			item_name, Item_name, specification，Specification，quantity_feedback，Quantity_feedback\
			user_name, User_name, feedback_time, Feedback_time, record_nick, Record_nick, status, Status)
			pages->addData(dto);

	}
	return pages;
}

uint64_t ProduceWorkService::execAddtTable(const AddPworkTableDTO::Wrapper& dto)
{
	// 组装DO数据
	addProduceWorkDo data;
	 	data.setFeedback_type(dto->feedback_type.getValue(""));
	 	data.setFeedback_code(dto->feedback_code.getValue(""));
		data.setTask_code(dto->task_code.getValue(""));
		data.setProduct_code(dto->product_code.getValue(""));
		data.setProduct_name(dto->product_name.getValue(""));

		data.setUnit_of_measure(dto->unit_of_measure.getValue(""));
		data.setProduct_spc(dto->product_spc.getValue(""));
		data.setQuantity_feedback(dto->quantity_feedback.getValue(""));
		data.setQuantity_uncheck(dto->quantity_uncheck.getValue(""));
		data.setNick_name(dto->nick_name.getValue(""));

		data.setFeedback_time(dto->feedback_time.getValue(""));
		data.setRecord_nick(dto->record_nick.getValue(""));
		data.setRemark(dto->remark.getValue(""));

	ZO_STAR_DOMAIN_DTO_TO_DO(data, dto, Feedback_type, feedback_type, Feedback_code, feedback_code, \
		Task_code, task_code, Product_code, product_code, Product_name, Product_name, \
		Unit_of_measure, unit_of_measure, Product_spc, product_spc, Quantity_feedback, quantity_feedback, \
		Quantity_uncheck, quantity_uncheck, Nick_name, nick_name, Record_nick, record_nick, \
		Feedback_time, feedback_time, Remark, remark)
		// 执行数据添加
		ProduceWorkDAO dao;
	return dao.insert(data);
}

bool ProduceWorkService::execModifyTable(const treansformProduceDTO::Wrapper& dto)
{
	// 组装DO数据
	treansformProduceDO data;
	 	data.setFeedback_type(dto->feedback_type.getValue(0));
		data.setFeedback_code(dto->feedback_code.getValue(""));
		data.setTask_code(dto->task_code.getValue(""));
		data.setProduct_code(dto->product_code.getValue(""));
		data.setProduct_name(dto->product_name.getValue(""));

		data.setUnit_of_measure(dto->unit_of_measure.getValue(""));
		data.setProduct_spc(dto->product_spc.getValue(""));
		data.setQuantity_feedback(dto->quantity_feedback.getValue(""));
		data.setQuantity_uncheck(dto->quantity_uncheck.getValue(""));
		data.setNick_name(dto->nick_name.getValue(""));

		data.setRecord_nick(dto->record_nick.getValue(""));
		data.setFeedback_time(dto->feedback_time.getValue(""));
		data.setRemark(dto->remark.getValue(""));

	ZO_STAR_DOMAIN_DTO_TO_DO(data, dto, Feedback_type, feedback_type,Feedback_code, feedback_code,\
		Task_code, task_code, Product_code, product_code, Product_name, Product_name,\
		Unit_of_measure, unit_of_measure, Product_spc, product_spc, Quantity_feedback, quantity_feedback,\
		Quantity_uncheck, quantity_uncheck, Nick_name, nick_name, Record_nick, record_nick,\
		Feedback_time, feedback_time, Remark, remark)
		// 执行数据修改
		ProduceWorkDAO dao;
	return dao.update(data) == 1;
}

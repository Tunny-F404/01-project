#pragma once
/*
 Copyright Zero One Star. All rights reserved.

 @Author: awei
 @Date: 2023/02/17 16:25:30

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
#ifndef _PWORKDO_H_
#define _PWORKDO_H_

#include "../DoInclude.h"
/**
 * 测试菜单数据库实体
 */
class PworkDo
{	// 记录IDrecord_id
	CC_SYNTHESIZE(string, record_id, Record_id);
	//报工类型
	CC_SYNTHESIZE(string, feedback_type, Feedback_type);
	// 工作站名称
	CC_SYNTHESIZE(string, workstation_name, Workstation_name);
	//生产工单编号
	CC_SYNTHESIZE(string, workorder_code, Workorder_code);
	//产品物料编码
	CC_SYNTHESIZE(string, item_code, Item_code);

	//产品物料名称
	CC_SYNTHESIZE(string, item_name, Item_name);
	//规格型号
	CC_SYNTHESIZE(string, specification, Specification);
	//报工数量
	CC_SYNTHESIZE(string, quantity_feedback, Quantity_feedback);
	//报工人
	CC_SYNTHESIZE(string, user_name, User_name);
	//报工时间
	CC_SYNTHESIZE(string, feedback_time, Feedback_time);

	//审核人 -昵称
	CC_SYNTHESIZE(string, record_nick, Record_nick);
	//状态(0正常 1停用)
	CC_SYNTHESIZE(string, status, Status);
public:
	PworkDo() {}
	PworkDo(string record_id, string feedback_type,
		string workstation_name, string workorder_code,
		string item_code, string item_name,
		string specification, string quantity_feedback,
		string user_name, string feedback_time,
		string record_nick,string status,
		)
	{
		this->record_id = record_id;
		this->feedback_type = feedback_type;
		this->workstation_name = workstation_name;
		this->workorder_code = workorder_code;
		this->item_code = item_code;
		this->item_name = item_name;
		this->specification = specification;
		this->quantity_feedback = quantity_feedback;
		this->user_name = user_name;
		this->feedback_time = feedback_time;
		this->record_nick = record_nick;
		this->status = status;
	}
};

#endif // !_PWORKDO_H_